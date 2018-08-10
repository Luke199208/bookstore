package com.luke.cart.servlet;

import com.luke.cart.service.impl.CartServiceImpl;
import com.luke.category.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * ${PACKAGE_NAME}
 * dllo
 * 18/6/23
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
@WebServlet(name = "com.luke.cart.servlet.ClearServlet", urlPatterns = "/clear")
public class ClearServlet extends HttpServlet {

    private CartServiceImpl cartService = new CartServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uid = (String) request.getSession().getAttribute("uid");
       // System.out.println("*---Clear---*"+uid);

        String bid = request.getParameter("bid");
        String method = request.getParameter("Method");
        switch (method){
            case "clearAll":
                if (cartService.clearCart(uid)){
                request.setAttribute("uid",uid);
                request.getRequestDispatcher("/showcart").forward(request,response);
            }else {
                    request.setAttribute("msg","购物车已清空!");
                    request.getRequestDispatcher("/jsps/cart/list.jsp").forward(request,response);
                }
                break;
            case "delete":
                cartService.deleteBook(uid,bid);
                request.setAttribute("uid",uid);
                request.getRequestDispatcher("/showcart").forward(request,response);
        }

    }
}
