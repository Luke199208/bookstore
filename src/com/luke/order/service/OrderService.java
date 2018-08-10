package com.luke.order.service;

import com.luke.book.bean.Book;
import com.luke.order.bean.Order;
import com.luke.order.bean.OrderItem;

import java.util.List;
import java.util.Map;

/***
 * com.luke.order.service
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
public interface OrderService {
    //添加一个订单
    boolean addOrders(Order order);
    //添加一个订单条目
    boolean addOrderItem( Order order);

    //查询订单信息
    List<Order> findOrderItemByUid(String uid);
    //根据oid获取OrderItem对象
    Order findOrderItem(String oid);
    //设置订单状态
    boolean setOrderState(int state,String oid);

}
