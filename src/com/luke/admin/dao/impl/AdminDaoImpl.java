package com.luke.admin.dao.impl;

import com.lanou.jdbc.GxQueryRunner;
import com.luke.admin.bean.Admin;
import com.luke.admin.dao.AdminDao;
import com.luke.book.bean.Book;
import com.luke.category.bean.Category;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/***
 * com.luke.admin.dao.impl
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
public class AdminDaoImpl implements AdminDao {
    GxQueryRunner runner = new GxQueryRunner();

    @Override
    public Admin loginAdmin(String adminname, String adminpw) {
        String sql = "select * from admin where adminname = ? and adminpw = ?";
        try {
            Admin admin = runner.query(sql,new BeanHandler<>(Admin.class),adminname,adminpw);
           return admin;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addCategory(Category category) {
        String sql = "insert into category values(?,?)";
        try {
            int add = runner.update(sql, category.getCid(), category.getCname());
            return add == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkCategory(String cname) {
        String sql = "select * from category where cname =?";
        try {
            Category category = runner.query(sql,new BeanHandler<>(Category.class),cname);
            if (category!=null){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Category> findCategorys() {
        List<Category> categoryList = new ArrayList<>();
        String sql = "select * from category";
        try {
            categoryList = runner.query(sql,new BeanListHandler<>(Category.class));
            return  categoryList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteCategory(String cid) {
        String sql = "delete from category where cid=?";
        try {
            int dl = runner.update(sql,cid);
            return dl==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Book> findBooksByCid(String cid) {
        String sql = "select * from category c left join book b on c.cid = b.cid where c.cid = ?";
        try {
            List<Book> bookList = runner.query(sql,
                    new BeanListHandler<>(Book.class),
                    cid);
            return bookList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateCategory(String cid,String cname) {
        String sql = "update category set cname = ? where cid = ?";
        try {
            int update = runner.update(sql,cname,cid);
            return update==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
