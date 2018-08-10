package com.luke.cart.bean;

import com.luke.book.bean.Book;

import java.io.Serializable;

/***
 * com.luke.cart
 * dllo
 * 18/6/21
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
public class CartItem implements Serializable{
    private String bid;
    private Book book;
    private int count;

    @Override
    public String toString() {
        return "CartItem{" +
                "bid='" + bid + '\'' +
                ", book=" + book +
                ", count=" + count +
                '}';
    }

    public CartItem() {
    }

    public CartItem(String bid, Book book, int count) {
        this.bid = bid;
        this.book = book;
        this.count = count;
    }

    public Book getBook() {

        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
