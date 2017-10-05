package controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class LogOutController {
    private static final Logger log = Logger.getLogger(LoginController.class);

    @RequestMapping("/logout.html")
    private String goToMainPage(HttpSession session, HttpServletResponse response) throws IOException {
        String login = session.getAttribute("login").toString();
        if ( login != null) {
            log.info("User "+ login + " was logged out!");
            session.removeAttribute("login");
        }
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
        }
    }
