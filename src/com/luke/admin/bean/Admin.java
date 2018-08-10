package com.luke.admin.bean;

/***
 * com.luke.admin.bean
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
public class Admin {
    private String adminID,adminname,adminpw;

    @Override
    public String toString() {
        return "Admin{" +
                "adminID='" + adminID + '\'' +
                ", adminname='" + adminname + '\'' +
                ", adminpw='" + adminpw + '\'' +
                '}';
    }

    public Admin() {
    }

    public Admin(String adminID, String adminname, String adminpw) {

        this.adminID = adminID;
        this.adminname = adminname;
        this.adminpw = adminpw;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminpw() {
        return adminpw;
    }

    public void setAdminpw(String adminpw) {
        this.adminpw = adminpw;
    }
}
