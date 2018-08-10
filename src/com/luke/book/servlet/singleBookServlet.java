package com.luke.book.servlet;

import com.luke.book.bean.Book;
import com.luke.book.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * ${PACKAGE_NAME}
 * dllo
 * 18/6/22
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
@WebServlet(name = "singleBookServlet", urlPatterns = "/single")
public class singleBookServlet extends HttpServlet {
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

        //按bid查询书籍
        String bid =request.getParameter("bid");

        //获得addCartServlet传过来的 添加书籍成功信息 传给前端desc.jsp
        String msg = (String) request.getAttribute("msg");
        request.setAttribute("msg",msg);

        Book book = bookService.findBookByBid(bid);
        request.setAttribute("book",book);
        request.getRequestDispatcher("/jsps/book/desc.jsp").forward(request,response);
    }
}
