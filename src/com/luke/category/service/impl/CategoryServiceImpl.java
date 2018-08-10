package com.luke.category.service.impl;

import com.luke.category.bean.Category;
import com.luke.category.dao.impl.CategoryDaoImpl;
import com.luke.category.service.CategoryService;

import java.util.List;

/***
 * com.luke.category.service.impl
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
public class CategoryServiceImpl implements CategoryService {

    CategoryDaoImpl categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        List<Category> categoryList = categoryDao.findAll();
        //System.out.println(categoryList);
        if (categoryList!=null){
            return categoryList;
        }
        return null;
    }

}
