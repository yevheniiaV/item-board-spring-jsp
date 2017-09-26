package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountController {

    @RequestMapping("/account.html")
    public String goToMyAccountPage(HttpServletRequest req) {
        return "account";
    }

}
