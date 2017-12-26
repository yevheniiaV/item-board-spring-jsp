package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AccountController {

    @RequestMapping("/account.html")
    public String goToMyAccountPage(HttpSession session, Model model) {
        if (session.getAttribute("login") != null) {
            String login = (String)session.getAttribute("login");
            model.addAttribute("login", login);
        }
        return "account";
    }

}
