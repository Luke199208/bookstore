package com.luke.cart.dao;

import com.luke.book.bean.Book;
import com.luke.cart.bean.Cart;
import com.luke.cart.bean.CartItem;

import java.util.List;
import java.util.Map;

/***
 * com.luke.cart.dao
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
public interface CartDao {
    //根据bid获取书籍信息
    Book cartBook(String bid);

    //根据uid,bid查询tb_cart表的Cart对象
    Cart  queryByUidBid(Cart cart);

    //向数据库的tb_cart 表添加uid bid count
    boolean insertBook(String uid,String bid,int count);

    //根据uid bid 获取书籍信息
    List<CartItem> cartBooks(String uid);

    //根据uid,bid获得CartItem对象
    CartItem findCartItem(String uid,String bid);

    //查询tb_cart by uid
    List<Cart> findTb_cartByUid(String uid);

    //按uid查询 清空购物车
    boolean clearCart(String uid);

    //根据uid,bid删除单个数据
    boolean deleteBook(String uid,String bid);

}
