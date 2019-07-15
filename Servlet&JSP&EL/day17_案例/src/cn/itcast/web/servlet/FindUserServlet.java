package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.Impl.UserServiceImpl;
import cn.itcast.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
        String id = request.getParameter("id");
        //调用UserService查询User
        UserService service = new UserServiceImpl();
        User user=service.findUserById(id);
        //将user存入到request
        request.setAttribute("user",user);
        //转发到update.jsp页面
        request.getRequestDispatcher("/update.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
