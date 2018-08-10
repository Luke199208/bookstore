package com.luke.book.dao.impl;

import com.lanou.jdbc.GxQueryRunner;
import com.luke.book.bean.Book;
import com.luke.book.dao.BookDao;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import java.sql.SQLException;
import java.util.List;

/***
 * com.luke.book.dao.impl
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
public class BookDaoImpl implements BookDao {
    GxQueryRunner runner = new GxQueryRunner();
    @Override
    public List<Book> findAll() {
        String sql = "select * from book b left join category c on b.cid = c.cid";
        try {
            List<Book> bookList = runner.query(sql,
                    new BeanListHandler<>(Book.class));
            return bookList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> findByCategory(String category) {
        String sql = "select * from book b left join category c on b.cid = c.cid where cname = ? ";
        try {
            List<Book> bookList = runner.query(sql,
                    new BeanListHandler<>(Book.class),
                    category);
            return bookList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book findBookByBId(String bid) {
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


}
