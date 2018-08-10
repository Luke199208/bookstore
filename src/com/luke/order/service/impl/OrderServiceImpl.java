package com.luke.order.service.impl;

import com.lanou.commons.CommonUtils;
import com.luke.book.bean.Book;
import com.luke.cart.bean.Cart;
import com.luke.order.bean.Order;
import com.luke.order.bean.OrderItem;
import com.luke.order.dao.impl.OrderDaoImpl;
import com.luke.order.service.OrderService;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/***
 * com.luke.order.service.impl
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
public class OrderServiceImpl implements OrderService {
    OrderDaoImpl orderDao = new OrderDaoImpl();

    @Override
    public boolean addOrders(Order order) {
        order.setOid(CommonUtils.uuid());
        boolean flag = orderDao.addOrders(order);
        if (flag) {
            return flag;
        }
        return false;
    }

    @Override
    public boolean addOrderItem(Order order) {
        OrderItem orderItem = new OrderItem();
        List<Cart> cartList = orderDao.getCart(order.getUid());
        boolean flag = false;
        if (cartList != null) {
            for (Cart cart : cartList) {
                String iid = CommonUtils.uuid();
                orderItem.setIid(iid);
                orderItem.setCount(cart.getCount());
                orderItem.setSubtotal(cart.getCount() * orderDao.findBookByBid(cart.getBid()).getPrice());
                orderItem.setOrder(order);
                orderItem.setBid(cart.getBid());
                flag = orderDao.insertOrderItem(orderItem);

            }
        }
        if (flag){
            orderDao.clearCart(order.getUid());
        }

        return false;
    }

    @Override
    public  List<Order> findOrderItemByUid(String uid) {
       List<Order> orderList = orderDao.findOrderItemByUid(uid);
        if (orderList!=null){
            return orderList;
        }

        return null;
    }

    @Override
    public Order findOrderItem(String oid) {
        Order order = orderDao.findOrderItem(oid);
        if (order!=null){
            return order;
        }
        return null;
    }

    @Override
    public boolean setOrderState(int state,String oid) {
        boolean flag = orderDao.setOrderState(state,oid);
        if (flag){
            return flag;
        }
        return false;
    }


    /**
     * 7    * 获取现在时间
     * 8    *
     * 9    * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
     * 10
     */
    public static String getNowDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
//        ParsePosition pos = new ParsePosition(8);
//        Date currentTime_2 = formatter.parse(dateString, pos);
        return dateString;
    }

}
