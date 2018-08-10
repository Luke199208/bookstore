package com.luke.cart.bean;

import java.util.Map;

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
public class Cart {
    private String cartId;
    private String uid;
    private String bid;
    private int count;

    public Cart(String cartId, String uid, String bid, int count) {
        this.cartId = cartId;
        this.uid = uid;
        this.bid = bid;
        this.count = count;
    }

    public String getCartId() {

        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", uid='" + uid + '\'' +
                ", bid='" + bid + '\'' +
                ", count=" + count +
                '}';
    }

    public Cart() {
    }

    public String getUid() {

        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
