package com.luke.cart.servlet;

import com.luke.book.bean.Book;
import com.luke.cart.bean.CartItem;
import com.luke.cart.service.impl.CartServiceImpl;
import com.luke.user.servlet.LoginServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * ${PACKAGE_NAME}
 * dllo
 * 18/6/22
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
@WebServlet(name = "ShowCartServlet",urlPatterns = "/showcart")
public class ShowCartServlet extends HttpServlet {

    CartServiceImpl cartService = new CartServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");//往界面发送是改成utf8
        response.setCharacterEncoding("utf8");//响应时改成utf8
        request.setCharacterEncoding("utf8");//服务器

        //获取当前用户uid  根据LoginServlet设置的uid属性
        String uid = (String) request.getSession().getAttribute("uid");

        //获取uid对应的购物车信息 书籍 uid
        List<CartItem> cartItemList = cartService.cartBooks(uid);

        //计算结算 单个订单钱数 money
        double money = 0;
        for (CartItem cartItem : cartItemList) {
            money += cartService.subtatol(uid,cartItem.getBook().getBid());
        }


        HttpSession session = request.getSession();
        //接收ClearServlet传过来的msg
        String msg = (String) request.getAttribute("msg");
        session.setAttribute("msg",msg);
        //订单结算
        session.setAttribute("money",money);
        //订单书目
        session.setAttribute("cartList",cartItemList);
        request.getRequestDispatcher("/jsps/cart/list.jsp").forward(request, response);


    }
}
