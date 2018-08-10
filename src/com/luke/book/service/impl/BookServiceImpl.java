package com.luke.book.service.impl;

import com.luke.book.bean.Book;
import com.luke.book.dao.impl.BookDaoImpl;
import com.luke.book.service.BookService;

import java.util.List;

/***
 * com.luke.book.service.impl
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
public class BookServiceImpl implements BookService {
    BookDaoImpl bookDao = new BookDaoImpl();
    @Override
    public List<Book> findAll() {
        List<Book> bookList = bookDao.findAll();
        if (bookList!=null){
            return bookList;
        }else {
            return null;
        }
    }

    @Override
    public List<Book> findByCategory(String category) {
        List<Book> bookList = bookDao.findByCategory(category);
        if (bookList!=null){
            return bookList;
        }else {
            return null;
        }
    }

    @Override
    public Book findBookByBid(String bid) {
        Book book = bookDao.findBookByBId(bid);
        if (book!=null){
            return  book;
        }
        return null;
    }
}
