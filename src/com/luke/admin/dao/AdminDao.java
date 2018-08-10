package com.luke.admin.dao;

import com.luke.admin.bean.Admin;
import com.luke.book.bean.Book;
import com.luke.category.bean.Category;

import java.util.List;

/***
 * com.luke.admin.dao
 * dllo
 * 18/6/26
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
public interface AdminDao {

    //管理员登录
    Admin loginAdmin(String adminname, String adminpw);

    /*--------Category---------*/
    //添加分类
    boolean addCategory(Category category);
    //查看分类名称是否已存在
    boolean checkCategory(String cname);
    //返回List<Category>
    List<Category> findCategorys();
    //删除分类
    boolean deleteCategory(String cid);
    //根据cid查询书目
    List<Book> findBooksByCid(String cid);
    //修改分类名称 cid
    boolean updateCategory(String cid,String cname);

}
