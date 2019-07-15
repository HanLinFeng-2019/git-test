package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.Impl.UserServiceImpl;
import cn.itcast.service.UserService;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取数据
        String verifycode = request.getParameter("verifycode");
        //3.验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");

        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性

        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            //验证码不正确
            //提示信息
            request.setAttribute("login_msg","验证码错误!");
            //转发到login.jsp页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }

        Map<String, String[]> map = request.getParameterMap();
        //4.封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //5.调用Service查询
        UserService service = new UserServiceImpl();
         User loginUser= service.login(user);
        //6.判断是否登陆成功
        if(loginUser!=null){
                //登陆成功,将用户名信息共享到服务器的session
            session.setAttribute("user",loginUser);
            //重定向页面，跳转到index.jsp页面
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else{
            //登陆失败
            //提示信息
            request.setAttribute("login_msg","用户名或密码错误");
            //转发到login.jsp页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
