package com.luke.admin.servlet;

import com.luke.admin.bean.Admin;
import com.luke.admin.service.impl.AdminServiceImpl;
import com.luke.book.bean.Book;
import com.luke.category.bean.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/***
 * ${PACKAGE_NAME}
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
@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    AdminServiceImpl adminService = new AdminServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =request.getSession();

        String method = request.getParameter("Method");
        switch (method){
            case "login":
                String adminname = request.getParameter("adminname");
                String adminpw = request.getParameter("password");
                Admin admin = adminService.loginAdmin(adminname,adminpw);
                if (admin!=null){
                    session.setAttribute("adminname",admin.getAdminname());
                    request.getRequestDispatcher("/adminjsps/admin/main.jsp").forward(request,response);
                }else {
                    request.setAttribute("msg","管理员信息不存在");
                    request.getRequestDispatcher("/adminjsps/login.jsp").forward(request,response);
                }
                break;
            case "addCategory":
                String cname = request.getParameter("cname");
                boolean check = adminService.checkCategory(cname);
                if (!check){
                    Category category = new Category();
                    category.setCname(cname);
                    adminService.addCategory(category);
                }else {
                    request.setAttribute("msg","分类名称已存在");
                    request.getRequestDispatcher("/adminjsps/admin/category/add.jsp").forward(request,response);
                }
                break;
            case "findCategorys":
                List<Category> categoryList= adminService.findCategorys();
                session.setAttribute("categorys",categoryList);
                request.getRequestDispatcher("/adminjsps/admin/category/list.jsp").forward(request,response);
                break;
            case "deleteCategory":
                String cidDel = request.getParameter("cid");
                //先查询 要删除的类别名称下 是否有书目 有则不能删除
                List<Book> bookList = adminService.findBooksByCid(cidDel);
                List<String> bnameList = new ArrayList<>();
                for (Book book : bookList) {
                    if (book.getBname()!=null){
                        bnameList.add(book.getBname());
                    }
                }
                if (bnameList.isEmpty()){
                    //列类别名下没有书目 可以删除
                    adminService.deleteCategory(cidDel);
                    request.setAttribute("msg","删除成功");
                    request.getRequestDispatcher("/adminjsps/admin/category/del.jsp").forward(request,response);
                }else {
                    request.setAttribute("msg","该类别下有书目展示,不可删除");
                    request.getRequestDispatcher("/adminjsps/admin/category/del.jsp").forward(request,response);
                }
                break;
            case "mod":
                String cidMod = request.getParameter("cid");
                String cnameMod = request.getParameter("cname");
                boolean update = adminService.updateCategory(cidMod,cnameMod);
                if (update){
                    request.setAttribute("msg","类名已修改成功");
                    request.getRequestDispatcher("/adminjsps/admin/category/mod.jsp").forward(request,response);
                }else {
                    request.setAttribute("msg","类名未修改成功");
                    request.getRequestDispatcher("/adminjsps/admin/category/mod.jsp").forward(request,response);
                }
                break;
        }

    }
}
