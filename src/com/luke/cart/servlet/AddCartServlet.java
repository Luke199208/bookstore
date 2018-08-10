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
import java.util.HashMap;
import java.util.Map;

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
@WebServlet(name = "AddCartServlet", urlPatterns = "/addcart")
public class AddCartServlet extends HttpServlet {

    CartServiceImpl cartService = new CartServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");//往界面发送是改成utf8
        response.setCharacterEncoding("utf8");//响应时改成utf8
        request.setCharacterEncoding("utf8");//服务器

        //向CartItem对象传入用户点击购买的书籍的信息
        CartItem cartItem = new CartItem();
        String bid = request.getParameter("bid");
        Book book = cartService.cartBook(bid);

        //System.out.println(book);
        cartItem.setBook(book);
        //添加购买书籍的count
        int count = Integer.parseInt(request.getParameter("count"));
        cartItem.setCount(count);

        //获取当前用户uid  根据LoginServlet设置的uid属性
        String uid = (String) request.getSession().getAttribute("uid");
        //System.out.println("***addServlet****"+uid);
        //将购物车信息存入数据库
        boolean addCart = cartService.insertBook(uid, bid, count);

        //给前端添加是否成功信息
        if(addCart){
            request.setAttribute("msg","添加购物车成功");
            request.getRequestDispatcher("/single").forward(request,response);
        }else {
            request.setAttribute("msg","添加购物车失败");
            request.getRequestDispatcher("/single").forward(request,response);
        }

    }
}
