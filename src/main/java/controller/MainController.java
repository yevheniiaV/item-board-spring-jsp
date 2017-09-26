package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    @RequestMapping("/main.html")    
    private String goToMainPage(HttpServletRequest req, HttpServletResponse resp) {
        return "main";
    }
}
