package com.luke.user.servlet;

import com.lanou.commons.CommonUtils;
import com.luke.user.bean.UserBean;
import com.luke.user.dao.UserDao;
import com.luke.user.dao.impl.UserDaoImpl;
import com.luke.user.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

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
        //用于存放前端数据
        UserBean userBean = new UserBean();

        //利用工具类(反射机制) 获取前端数据
        userBean = CommonUtils.toBean(request.getParameterMap(), UserBean.class);


        //注册业务 中间层
        // 调用dao里面的注册方法
        boolean flag = userService.registerUser(userBean);
        if (flag) {
            request.getRequestDispatcher("/jsps/user/login.jsp").forward(request, response);
        } else {
            UserDaoImpl userDao = new UserDaoImpl();
            if (userDao.queryByUsername(userBean.getUsername())) {
                request.setAttribute("msg", "注册失败,用户名已存在");
                request.getRequestDispatcher("/jsps/user/regist.jsp").forward(request, response);
            }
            if (userDao.queryByEmail(userBean.getEmail())) {
                request.setAttribute("msg", "注册失败,邮箱已被占用");
                request.getRequestDispatcher("/jsps/user/regist.jsp").forward(request, response);
            }
        }

    }
}
