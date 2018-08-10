package com.luke.category.dao.impl;

import com.lanou.jdbc.GxQueryRunner;
import com.luke.category.bean.Category;
import com.luke.category.dao.CategoryDao;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/***
 * com.luke.category.dao.impl
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
public class CategoryDaoImpl implements CategoryDao {

    GxQueryRunner runner = new GxQueryRunner();

    @Override
    public List<Category> findAll() {
        String sql = "select cname from category";
        try {
            List<Category> categoryList = runner.query(sql,
                    new BeanListHandler<>(Category.class));
            //System.out.println(categoryList);
            return categoryList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
