package com.luke.cart.service.impl;

import com.luke.book.bean.Book;
import com.luke.cart.bean.Cart;
import com.luke.cart.bean.CartItem;
import com.luke.cart.dao.impl.CartDaoImpl;
import com.luke.cart.service.CartService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/***
 * com.luke.cart.service.impl
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
public class CartServiceImpl implements CartService {
    CartDaoImpl cartDao = new CartDaoImpl();

    @Override
    public Book cartBook(String bid) {
        Book book = cartDao.cartBook(bid);
        if (book != null) {
            return book;
        }
        return null;
    }

    @Override
    public Cart queryByUidBid(Cart cart) {
        return cartDao.queryByUidBid(cart);
    }

    @Override
    public boolean insertBook(String uid, String bid, int count) {
        return cartDao.insertBook(uid,bid,count);
    }

    @Override
    public List<CartItem> cartBooks(String uid) {
        List<CartItem> cartItemList = cartDao.cartBooks(uid);
        if (cartItemList != null) {
            return cartItemList;
        }
        return null;
    }

    @Override
    public boolean clearCart(String uid) {
        boolean clearCart = cartDao.clearCart(uid);
        if (clearCart) {
            return clearCart;
        }
        return false;
    }

    @Override
    public boolean deleteBook(String uid, String bid) {
        boolean deleteBook = cartDao.deleteBook(uid,bid);
        if (deleteBook) {
            return deleteBook;
        }
        return false;
    }

    @Override
    public double subtatol(String uid, String bid) {
        //使用BigDecimal 不会有误差
        //要求必须使用String类型构造器
        CartItem cartItem = cartDao.findCartItem(uid,bid);
        BigDecimal count = new BigDecimal(cartItem.getCount()+"");
        BigDecimal price = new BigDecimal(cartItem.getBook().getPrice()+"");
        BigDecimal suntatol = count.multiply(price);
        return suntatol.doubleValue();
    }
}
