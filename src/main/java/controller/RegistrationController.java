package controller;

import dao.UserDAO;
import dao.UserDAOService;
import entity.User;
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

    @ModelAttribute("user")
    public User createModel() {
        return new User();
    }

    UserDAOService userDAOService = new UserDAOService(new UserDAO());

    private void registerUser(User user, HttpSession session, String login){
        userDAOService.add(user);
        session.setAttribute("login", login);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String login(@Valid User user, BindingResult result, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model, String email, String name, String pass, String pass2, String phone, String city) throws IOException {

        if (result.hasErrors()){
            if(!pass.equals(pass2)){
                System.out.println(pass);
                System.out.println(pass2);
                model.addAttribute("passwordsNotEqualsError", "olol");
                    return "account";
                }else {
                    return "account";}
        }else if((userDAOService.getByLogin(name) == null) && (pass.equals(pass2)) && (!(name.equals("")) && !(email.equals("")) && !(pass.equals("")) && !(pass2.equals("")))) {
            user = new User(email, name, pass, phone, city);
            registerUser(user, session, name);
            response.sendRedirect("/");
            return "main";
        } return null;
    }
}
