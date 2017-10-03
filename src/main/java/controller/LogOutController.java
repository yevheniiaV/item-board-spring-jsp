package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class LogOutController {

    @RequestMapping("/logout.html")
    private String goToMainPage(HttpSession session, HttpServletResponse response) throws IOException {
        if (session.getAttribute("login") != null) {
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
