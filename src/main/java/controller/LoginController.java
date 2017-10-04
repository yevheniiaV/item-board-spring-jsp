package controller;

import dao.UserDAO;
import dao.UserDAOService;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class LoginController {

    @RequestMapping(value = "/login.html", method = RequestMethod.POST)
    public String login(String emailLogin, String passwordLogin, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        UserDAOService userDAOService = new UserDAOService(new UserDAO());
        User userResult = userDAOService.getByLogin(emailLogin);
        if (userResult != null && (!(emailLogin.equals("") &&(passwordLogin.equals("")))) && userResult.getPass().equals(passwordLogin)) {
            request.getSession().setAttribute("login", emailLogin);
            response.sendRedirect("/");
            return null;
        } else if((emailLogin.equals("")) && passwordLogin.equals("")){
            model.addAttribute("errorForm", "Please fill empty fields!");
            return "account";
        }else if(emailLogin.equals("")){
            model.addAttribute("errorLogin", "Please fill login field!");
            return "account";
        }else if(passwordLogin.equals("")){
            model.addAttribute("errorPass", "Please fill password field!");
            return "account";
        } else {
            model.addAttribute("errorForm", "Incorrect credentials!");
            return "account";
        }
    }
}