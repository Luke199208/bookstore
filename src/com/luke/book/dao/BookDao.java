package com.luke.book.dao;


import com.luke.book.bean.Book;

import java.util.List;

/***
 * com.luke.book.dao
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
public interface BookDao {
    //查询全部书籍
    List<Book> findAll();

    //按类别查询
    List<Book> findByCategory(String category);

    //查询单个书籍 按bid查找
    Book findBookByBId(String bid);

}
