package com.luke.order.servlet;

import com.luke.cart.bean.CartItem;
import com.luke.order.bean.Order;
import com.luke.order.bean.OrderItem;
import com.luke.order.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/***
 * ${PACKAGE_NAME}
 * dllo
 * 18/6/24
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
@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {
    OrderServiceImpl orderService = new OrderServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uid = (String) request.getSession().getAttribute("uid");

        HttpSession session = request.getSession();

        String method = request.getParameter("Method");
        switch (method) {
            case "addOneOrder":
                double money = Double.parseDouble(request.getParameter("money"));
                Order order = new Order();
                order.setUid(uid);
                order.setTotal(money);
                String date = String.valueOf(orderService.getNowDate());
                order.setOrdertime(date);
                // System.out.println(date);
                //设置state 默认未付款
                order.setState(1);
                order.setAddress("根据uid获得用户地址");
                //添加订单
                boolean addOrder = orderService.addOrders(order);
                //添加订单条目
                boolean addOrderItem = orderService.addOrderItem(order);

                request.setAttribute("msg", "订单已生成");
                request.getRequestDispatcher("/showcart").forward(request, response);
                break;
            case "showOrderItem":
                List<Order> orders = orderService.findOrderItemByUid(uid);
//                for (Order order1 : orders) {
//                    System.out.println(order1);
//                }
                session.setAttribute("orders", orders);
                request.getRequestDispatcher("/jsps/order/list.jsp").forward(request, response);
                break;
            case "pay":

                String oid = request.getParameter("oid");
                Order or = orderService.findOrderItem(oid);
                //System.out.println(or);

                session.setAttribute("order",or);
                request.getRequestDispatcher("/jsps/order/desc.jsp").forward(request,response);
                break;
            case "setState":
                String oidSet = request.getParameter("oidSet");
                int state = Integer.parseInt(request.getParameter("state"));
                System.out.println(oidSet +"***"+ state);
                orderService.setOrderState(state,oidSet);
                request.getRequestDispatcher("/order?Method=showOrderItem").forward(request,response);
                break;
        }
    }
}
