package com.luke.book.service;

import com.luke.book.bean.Book;

import java.util.List;

/***
 * com.luke.book.service
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
public interface BookService  {
    //业务逻辑处理 查询所有书籍
    List<Book> findAll();

    //业务逻辑处理 按类别查询书籍
    List<Book> findByCategory(String category);

    //业务逻辑处理 按bid查询书籍
    Book findBookByBid(String bid);
}
