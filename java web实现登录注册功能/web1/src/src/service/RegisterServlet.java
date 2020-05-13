package src.service;

import src.bean.User;
import src.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "RegisterServlet",urlPatterns={"RegisterServlet"})
@WebServlet(name = "Register",       urlPatterns={"/Register.action" })
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        UserDAO userDAO = new UserDAO();
        boolean flag = userDAO.register(user);
        if(flag){
            System.out.println("×¢²á³É¹¦");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else{
            System.out.println("×¢²áÊ§°Ü");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
