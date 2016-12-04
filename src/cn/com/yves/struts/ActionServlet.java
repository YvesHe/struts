/**   
 * Filename:    ActionServlet.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-12-4 下午8:08:50   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.struts;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {

    /**
     * 做完所有的事情.
     */
    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        System.out.println(url);

        // 1.首先从页面获取数据,封装到配置的javaBean中

        // 2.获取要跳转的所有的信息

        // 3.do Action做业务,返回要要跳转的actionForWard对象

        // 4.跳转
    }

}
