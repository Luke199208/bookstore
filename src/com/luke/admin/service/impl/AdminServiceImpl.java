package com.luke.admin.service.impl;

import com.lanou.commons.CommonUtils;
import com.luke.admin.bean.Admin;
import com.luke.admin.dao.impl.AdminDaoImpl;
import com.luke.admin.service.AdminService;
import com.luke.book.bean.Book;
import com.luke.category.bean.Category;

import java.util.List;

/***
 * com.luke.admin.service.impl
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
public class AdminServiceImpl implements AdminService {

    AdminDaoImpl adminDao = new AdminDaoImpl();

    @Override
    public Admin loginAdmin(String adminname, String adminpw) {
        Admin admin = adminDao.loginAdmin(adminname,adminpw);
        if (admin!=null){
            return admin;
        }
        return null;
    }

    @Override
    public boolean addCategory(Category category) {
        category.setCid(CommonUtils.uuid());
        boolean add = adminDao.addCategory(category);
        if (add){
            return add;
        }
        return false;
    }

    @Override
    public boolean checkCategory(String cname) {
        boolean flag = adminDao.checkCategory(cname);
        if (flag){
            return flag;
        }
        return false;
    }

    @Override
    public List<Category> findCategorys() {
        List<Category> categoryList = adminDao.findCategorys();
        if (categoryList!=null){
            return categoryList;
        }
        return null;
    }

    @Override
    public boolean deleteCategory(String cid) {

            boolean dl = adminDao.deleteCategory(cid);
            if (dl){
                return dl;
            }

        return false;
    }

    @Override
    public List<Book> findBooksByCid(String cid) {
        List<Book> bookList = adminDao.findBooksByCid(cid);
        if (bookList!=null){
            return bookList;
        }
        return null;
    }

    @Override
    public boolean updateCategory(String cid, String cname) {
        boolean update = adminDao.updateCategory(cid,cname);
        if (update){
            return update;
        }
        return false;
    }
}
