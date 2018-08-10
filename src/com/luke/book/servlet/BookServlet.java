package com.luke.book.servlet;

import com.luke.book.bean.Book;
import com.luke.book.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/***
 * ${PACKAGE_NAME}
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
@WebServlet(name = "BookServlet", urlPatterns = "/book")
public class BookServlet extends HttpServlet {

    BookServiceImpl bookService = new BookServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");//往界面发送是改成utf8
        response.setCharacterEncoding("utf8");//响应时改成utf8
        request.setCharacterEncoding("utf8");//服务器



        //按类别查询书籍
        String queryMode = request.getParameter("cname");
        switch (queryMode){
            case "All":
                //查询所有书籍
                List<Book> bookList = bookService.findAll();
                if (bookList!=null){
                    HttpSession session = request.getSession();
                    session.setAttribute("books",bookList);
                    request.getRequestDispatcher("/jsps/book/list.jsp").forward(request,response);
                }else {
                    notFind(request,response);
                }
                break;
            case "JavaSE":
                List<Book> javaSEList = bookService.findByCategory(queryMode);
                //System.out.println(javaSEList);
                if (javaSEList!=null){
                    request.setAttribute("books",javaSEList);
                    request.getRequestDispatcher("/jsps/book/list.jsp").forward(request,response);
                }else {
                    notFind(request,response);
                }
                break;
            case "JavaEE":
                List<Book> javaEEList = bookService.findByCategory(queryMode);
                if (javaEEList!=null){
                    request.setAttribute("books",javaEEList);
                    request.getRequestDispatcher("/jsps/book/list.jsp").forward(request,response);
                }else {
                    notFind(request,response);
                }
                break;
            case "Javascript":
                List<Book> javascriptList = bookService.findByCategory(queryMode);
                if (javascriptList!=null){
                    request.setAttribute("books",javascriptList);
                    request.getRequestDispatcher("/jsps/book/list.jsp").forward(request,response);
                }else {
                    notFind(request,response);
                }
                break;
        }



    }
    protected void notFind(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");//往界面发送是改成utf8
        response.setCharacterEncoding("utf8");//响应时改成utf8
        request.setCharacterEncoding("utf8");//服务器

        request.setAttribute("msg","未查询到相关书籍");
        request.getRequestDispatcher("/jsps/book/list.jsp").forward(request,response);
    }

}
