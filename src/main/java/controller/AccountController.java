package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountController {

    @RequestMapping("/account.html")
    public String goToMyAccountPage(HttpServletRequest req, Model model) {
        User user = new User();
        model.addAttribute(user);
        return "account";
    }

}
