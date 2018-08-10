package com.luke.cart.dao.impl;

import com.lanou.commons.CommonUtils;
import com.lanou.jdbc.GxQueryRunner;
import com.luke.book.bean.Book;
import com.luke.cart.bean.Cart;
import com.luke.cart.bean.CartItem;
import com.luke.cart.dao.CartDao;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * com.luke.cart.dao.impl
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
public class CartDaoImpl implements CartDao {
    GxQueryRunner runner = new GxQueryRunner();

    @Override
    public Book cartBook(String bid) {
        String sql = "select * from book where bid = ?";
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
    public Cart queryByUidBid(Cart cart) {
        try {
            Cart cart1 = runner.query("select  *  from tb_cart where  uid =?  and  bid = ?",
                    new BeanHandler<>(Cart.class), cart.getUid(), cart.getBid());
            return cart1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean insertBook(String uid, String bid, int count) {
        Cart cart = new Cart();
        cart.setBid(bid);
        cart.setUid(uid);
        cart.setCount(count);
        if (queryByUidBid(cart) == null){
            String sql = "insert into tb_cart values(?,?,?)";
            try {
                int insertResult = runner.update(sql,
                        uid,
                        bid,
                        count);
                return insertResult == 1;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            try {
                int i = runner.update("update tb_cart set count = ? where uid =? and  bid = ?"
                        , queryByUidBid(cart).getCount() + cart.getCount(), cart.getUid(), cart.getBid());
                return  i > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return false;
    }

    @Override
    public List<CartItem> cartBooks(String uid) {
        String sql = "select * from tb_cart t left join book b on t.bid = b.bid where t.uid = ? and b.bid = ?";
        List<CartItem> cartItemList = new ArrayList<>();
        try {
            //多种书籍处理
            List<Cart> cartList = findTb_cartByUid(uid);
            for (Cart cart : cartList) {

                //一种书
                //得到Map集合
                Map map = runner.query(sql, new MapHandler(), uid, cart.getBid());
                //将Map中的部分数据封装到cartItem中
                CartItem cartItem = CommonUtils.toBean(map, CartItem.class);
                //将Map中的部分数据封装到book中
                Book book = CommonUtils.toBean(map, Book.class);
                //将两个实体类建立关系
                cartItem.setBook(book);

                cartItemList.add(cartItem);
            }
            return cartItemList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CartItem findCartItem(String uid, String bid) {
        String sql = "select * from tb_cart t left join book b on t.bid = b.bid where t.uid = ? and b.bid = ?";
        Map map = null;
        try {
            map = runner.query(sql, new MapHandler(), uid, bid);
            //将Map中的部分数据封装到cartItem中
            CartItem cartItem = CommonUtils.toBean(map, CartItem.class);
            //将Map中的部分数据封装到book中
            Book book = CommonUtils.toBean(map, Book.class);
            //将两个实体类建立关系
            cartItem.setBook(book);
            return cartItem;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }


    @Override
    public List<Cart> findTb_cartByUid(String uid) {
        String sql = "select * from tb_cart where uid=?";
        try {
            List<Cart> cartList = runner.query(sql,
                    new BeanListHandler<>(Cart.class),
                    uid);
            return cartList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean clearCart(String uid) {
        String sql = "delete from tb_cart where uid = ?";
        try {
            int deleteCart = runner.update(sql, uid);
            return deleteCart > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBook(String uid, String bid) {
        String sql = "delete from tb_cart where uid = ? and bid = ?";
        try {
            int deleteBook = runner.update(sql, uid,bid);
            return deleteBook == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
