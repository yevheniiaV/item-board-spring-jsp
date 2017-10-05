package controller;

import dao.UserDAO;
import dao.UserDAOService;
import entity.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class RegistrationController {
    private static final Logger log = Logger.getLogger(LoginController.class);
    UserDAOService userDAOService = new UserDAOService(new UserDAO());

    @ModelAttribute("user")
    public User createModel() {
        return new User();
    }

    private void registerUser(User user, HttpSession session, String login){
        userDAOService.add(user);
        session.setAttribute("login", login);
        log.info("User "+ login + " was registrated successfully!");
    }

    @RequestMapping(value = "/register.html", method = RequestMethod.POST)
    public String login(@Valid User user, BindingResult result, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model, String email, String name, String pass, String pass2, String phone, String city) throws IOException {
        if (result.hasErrors()){
            if(!pass.equals(pass2)){
                log.info("User "+ user.getName() + " was not registrated! Passwords not equal");
                return "account";
                }else {
                    return "account";}
        } else if((userDAOService.getByEmail(email) == null) && (pass.equals(pass2))) {
            registerUser(user, session, name);
            response.sendRedirect("/");
            return "main";
        } else if (!(userDAOService.getByEmail(email) == null)){
            model.addAttribute("userExistError", "User exists!");
            log.info("User "+ user.getName() + " was not registrated! User exists!");
            return "account";
        }
        return null;
    }
}
