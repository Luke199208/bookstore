package com.luke.user.dao.impl;

import com.lanou.jdbc.GxQueryRunner;
import com.luke.user.bean.UserBean;
import com.luke.user.dao.UserDao;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/***
 * com.luke.user.dao.impl
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
public class UserDaoImpl implements UserDao {
    GxQueryRunner runner = new GxQueryRunner();

    //用户注册 数据插入用户表
    @Override
    public boolean registerUser(UserBean userBean) {
        String sql = "insert into tb_user values(?,?,?,?,?,?)";
        try {
            int count = runner.update(
                    sql,
                    userBean.getUid(),
                    userBean.getUsername(),
                    userBean.getPassword(),
                    userBean.getEmail(),
                    userBean.getCode(),
                    userBean.getState());
            return count == 1 ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    //判断用户名是否被占用
    @Override
    public boolean queryByUsername(String username) {
        String sql = "select * from tb_user where username = ?";
        try {
            /*List<UserBean> userBeanList = runner.query(
                    sql,
                    new BeanListHandler<>(UserBean.class),
                    username);
            return userBeanList.size()>0;*/
            UserBean bean = runner.query(
                    sql,
                    new BeanHandler<>(UserBean.class),
                    username);
            return bean != null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //判断邮箱是否被占用
    @Override
    public boolean queryByEmail(String email) {
        String sql = "select * from tb_user where email = ?";
        try {
            UserBean bean = runner.query(sql,
                    new BeanHandler<>(UserBean.class),
                    email);
            return bean != null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //登录 查询用户表中是否有该用户 用户名和密码是否正确
    @Override
    public UserBean loginUser(UserBean userBean) {
        String sql = "select * from tb_user where username = ? and password = ?";
        try {
            UserBean bean = runner.query(sql,
                    new BeanHandler<>(UserBean.class),
                    userBean.getUsername(),
                    userBean.getPassword());
            return bean;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
