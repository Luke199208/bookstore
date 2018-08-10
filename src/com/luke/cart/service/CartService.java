package com.luke.cart.service;

import com.luke.book.bean.Book;
import com.luke.cart.bean.Cart;
import com.luke.cart.bean.CartItem;

import java.util.List;
import java.util.Map;

/***
 * com.luke.cart.service
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
public interface CartService {
    //业务逻辑处理 根据bid获取书籍信息
    Book cartBook(String bid);
    Cart queryByUidBid(Cart cart);

    //业务逻辑处理 向数据库的tb_cart 表添加uid bid count
    boolean insertBook(String uid,String bid,int count);

    //业务逻辑处理 根据uid 获取购物车内书籍信息
    List<CartItem> cartBooks(String uid);

    //业务逻辑处理 根据uid删除tb_cart内相应的内容
    boolean clearCart(String uid);

    //根据uid,bid删除单个数据
    boolean deleteBook(String uid,String bid);

    //小计功能
    double subtatol(String uid,String bid);
}
