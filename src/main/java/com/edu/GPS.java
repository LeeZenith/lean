package com.edu;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GPS extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {

        InputStream is=null;
        Properties configContext=new Properties();
        is=this.getClass().getClassLoader().getResourceAsStream(config.getInitParameter("com.edu"));
        try {
            configContext.load(is);
            System.out.println(configContext.getProperty("scanPackage"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.init(config);
    }
}
