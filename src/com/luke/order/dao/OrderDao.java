package com.luke.order.dao;

import com.luke.book.bean.Book;
import com.luke.cart.bean.Cart;
import com.luke.order.bean.Order;
import com.luke.order.bean.OrderItem;
import com.luke.order.dao.impl.OrderDaoImpl;

import java.util.List;
import java.util.Map;

/***
 * com.luke.order.dao
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
public interface OrderDao {

    //生成一个订单
    boolean addOrders(Order order);
    //创建一个订单条目
    //得到单个订单条目的cart信息
    List<Cart> getCart(String uid);

    //将单个条目信息存入orderItem表
    boolean insertOrderItem(OrderItem orderItem);
    //删除生成订单的购物车内容
    boolean clearCart(String uid);

    //根据oid获取OrderItem对象
    Order findOrderItem(String oid);

    //根据uid获取订单条目及订单书籍
    List<Order> findOrderItemByUid(String uid);

    //设置订单状态
    boolean setOrderState(int state,String oid);


}
