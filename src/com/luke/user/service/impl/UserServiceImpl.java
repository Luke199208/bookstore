package com.luke.user.service.impl;

import com.lanou.commons.CommonUtils;
import com.luke.user.bean.UserBean;
import com.luke.user.dao.UserDao;
import com.luke.user.dao.impl.UserDaoImpl;
import com.luke.user.service.UserService;

/***
 * com.luke.user.service.impl
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
public class UserServiceImpl implements UserService {

    UserDaoImpl userDao = new UserDaoImpl();

    //业务逻辑处理放在service中
    @Override
    public boolean registerUser(UserBean userBean) {
        boolean flag_username = userDao.queryByUsername(userBean.getUsername());
        boolean flag_email = userDao.queryByEmail(userBean.getEmail());
        if (flag_username) {
            //用户名已存在
            return false;
        }else if (flag_email){
            return false;
        }else {
            //设置uid
            userBean.setUid(CommonUtils.uuid());//封装好的UUid方法  随机id 比主键自增长更安全
            return userDao.registerUser(userBean);
        }
    }

    @Override
    public UserBean loginUser(UserBean userBean) {
        UserBean bean = userDao.loginUser(userBean);
        if (bean!=null&&!bean.equals(null)){
            return bean;
        }
        return null;
    }
}
