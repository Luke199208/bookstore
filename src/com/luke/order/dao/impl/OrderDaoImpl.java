package com.luke.order.dao.impl;

import com.lanou.commons.CommonUtils;
import com.lanou.jdbc.GxQueryRunner;
import com.luke.book.bean.Book;
import com.luke.cart.bean.Cart;
import com.luke.order.bean.Order;
import com.luke.order.bean.OrderItem;
import com.luke.order.dao.OrderDao;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * com.luke.order.dao.impl
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
public class OrderDaoImpl implements OrderDao {
    GxQueryRunner runner = new GxQueryRunner();

    @Override
    public boolean addOrders(Order order) {
        String sql = "insert into orders values(?,?,?,?,?,?)";
        try {
            int flag = runner.update(sql,
                    order.getOid(),
                    order.getOrdertime(),
                    order.getTotal(),
                    order.getState(),
                    order.getUid(),
                    order.getAddress());
            return flag ==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Cart> getCart(String uid) {
        String sql = " select * from tb_cart where uid = ?";
        try {
            List<Cart> cartList = runner.query(sql,
                    new BeanListHandler<>(Cart.class),
                    uid);
            return  cartList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public boolean insertOrderItem(OrderItem orderItem) {


                String sql = "insert into orderitem values(?,?,?,?,?)";
                try {
                    int flag = runner.update(sql,
                            orderItem.getIid(),
                            orderItem.getCount(),
                            orderItem.getSubtotal(),
                            orderItem.getOrder().getOid(),
                            orderItem.getBid());
                    return flag == 1;
                } catch (SQLException e) {
                    e.printStackTrace();
                }



        return false;
    }

    @Override
    public boolean clearCart(String uid) {
        String sql = "delete from tb_cart where uid = ?";
        try {
            int flag = runner.update(sql,uid);
            return flag > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Order findOrderItem(String oid) {
        String sql = "select * from orderitem where oid = ?";
        try {
            List<OrderItem> orderItems = runner.query(sql,
                    new BeanListHandler<>(OrderItem.class),
                    oid);
            for (OrderItem orderItem : orderItems) {
                Book book = runner.query("select * from orderitem o left join book b on o.bid = b.bid where o.bid = ? ",
                        new BeanHandler<>(Book.class),orderItem.getBid());
                orderItem.setBook(book);
            }
            Order order = runner.query("select * from orders where oid = ?",new BeanHandler<>(Order.class),oid);
            order.setOrderItems(orderItems);
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Book findBookByBid(String bid){
        String sql = "select * from book where  bid = ?";
        try {
            Book book = runner.query(sql,
                    new BeanHandler<>(Book.class),
                    bid);
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> findOrderItemByUid(String uid) {

        try {
            List<Order> orders = runner.query("select * from orders where uid = ?",
                    new BeanListHandler<>(Order.class),
                    uid);
            for (Order order : orders) {
                List<OrderItem> orderItems = runner.query("select * from orderitem where oid=?",
                        new BeanListHandler<>(OrderItem.class),
                        order.getOid());
                for (OrderItem orderItem : orderItems) {
                    Book book = runner.query("select * from book where bid = ?",
                            new BeanHandler<>(Book.class),
                            orderItem.getBid());
                    orderItem.setBook(book);
                }
                order.setOrderItems(orderItems);
            }
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean setOrderState(int state,String oid) {
        String sql = "update orders set state=? where oid = ?";
        try {
            int flag = runner.update(sql,state,oid);
           return flag==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
