package DesignPatterns.DelegatePatterns.springMvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * @author daiwei
 * @date 2018/8/28 11:17
 */
public class webTest {
    public static void main(String[] args) {

        MyRequest myRequest=new MyRequest();
        myRequest.setParameter("mid");
        myRequest.setRequestURI("/web/getMemberById.json");

        new ServletDispachter(myRequest,new MyResponse());
    }

}


