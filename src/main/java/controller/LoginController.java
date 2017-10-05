package controller;

import dao.UserDAO;
import dao.UserDAOService;
import entity.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class LoginController {

    private static final Logger log = Logger.getLogger(LoginController.class);


    @ModelAttribute("user")
    public User createModel() {
        return new User();
    }

    @RequestMapping(value = "/login.html", method = RequestMethod.POST)
    public String login(String emailLogin, String passwordLogin, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        UserDAOService userDAOService = new UserDAOService(new UserDAO());
        User userResult = userDAOService.getByLogin(emailLogin);
        if (userResult != null && (!(emailLogin.equals("") &&(passwordLogin.equals("")))) && userResult.getPass().equals(passwordLogin)) {
            log.info("User "+ emailLogin + " was logged!");
            request.getSession().setAttribute("login", emailLogin);
            response.sendRedirect("/");
            return null;
        } else if((emailLogin.equals("")) && passwordLogin.equals("")){
            log.info("User "+ emailLogin + " was not logged! Empty fields");
            model.addAttribute("errorForm", "Please fill empty fields!");
            return "account";
        }else if(emailLogin.equals("")){
            log.info("User "+ emailLogin + " was not logged! Empty login field");
            model.addAttribute("errorLogin", "Please fill login field!");
            return "account";
        }else if(passwordLogin.equals("")){
            log.info("User "+ emailLogin + " was not logged! Empty password field");
            model.addAttribute("errorPass", "Please fill password field!");
            return "account";
        } else {
            log.info("User "+ emailLogin + " was not logged! Incorrect credentials!");
            model.addAttribute("errorForm", "Incorrect credentials!");
            return "account";
        }
    }
}