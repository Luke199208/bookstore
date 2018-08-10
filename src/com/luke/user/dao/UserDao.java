package com.luke.user.dao;

import com.luke.user.bean.UserBean;

/***
 * com.luke.user.dao
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
public interface UserDao {
    //注册
    boolean registerUser(UserBean userBean);

    //判断用户名是否被占用
    boolean queryByUsername(String username);

    //判断邮箱是否被占用
    boolean queryByEmail(String email);

    //登录
    UserBean loginUser(UserBean userBean);
}
