package com.luke.user.servlet;

import com.lanou.commons.CommonUtils;
import com.luke.cart.bean.Cart;
import com.luke.user.bean.UserBean;
import com.luke.user.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/***
 * ${PACKAGE_NAME}
 * dllo
 * 18/6/21
 *             ,%%%%%%%%,
 *           ,%%/\%%%%/\%%
 *          ,%%%\c "" J/%%%
 * %.       %%%%/ 0  0 \%%%
 * `%%.     %%%%    _  |%%%
 *  `%%     `%%%%(__Y__)%%'
 *  //       ;%%%%`\-/%%%'
 * ((       /  `%%%%%%%'
 *  \\    .'     '%%%'|    攻
 *   \\  /       \  | |    城
 *    \\/         ) | |    湿
 *     \         /_ | |__
 *     (___________))))))) 
 *
 *       我湿一吼  BUG无有                        
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");//往界面发送是改成utf8
        response.setCharacterEncoding("utf8");//响应时改成utf8
        request.setCharacterEncoding("utf8");//服务器

        UserBean userBean = CommonUtils.toBean(request.getParameterMap(),UserBean.class);

        UserBean bean = userService.loginUser(userBean);

        if (bean!=null){
            HttpSession session = request.getSession();
            session.setAttribute("username",bean.getUsername());
            session.setAttribute("uid",bean.getUid());

            request.getRequestDispatcher("/jsps/main.jsp").forward(request,response);
        }else {
            request.setAttribute("msg","用户名或密码错误");
            request.getRequestDispatcher("/jsps/user/login.jsp").forward(request,response);
        }


    }
}
