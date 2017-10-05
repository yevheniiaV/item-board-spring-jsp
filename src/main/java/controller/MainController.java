package controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {
    private static final Logger log = Logger.getLogger(LoginController.class);

    @RequestMapping({"/main.html","/"})
    private String goToMainPage(HttpServletRequest req, HttpServletResponse resp) {
        return "main";
    }
}
