package com.luke.order.bean;

import com.luke.book.bean.Book;

/***
 * com.luke.order.bean
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
public class OrderItem {
    private String bid;
    private String iid;
    private int count;
    private double subtotal;
    private Order order;
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "bid='" + bid + '\'' +
                ", iid='" + iid + '\'' +
                ", count=" + count +
                ", subtotal=" + subtotal +
                ", order=" + order +
                ", book=" + book +
                '}';
    }

    public OrderItem(String bid, String iid, int count, double subtotal, Order order, Book book) {
        this.bid = bid;
        this.iid = iid;
        this.count = count;
        this.subtotal = subtotal;
        this.order = order;
        this.book = book;
    }

    public OrderItem() {
    }

    public String getIid() {

        return iid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


}
