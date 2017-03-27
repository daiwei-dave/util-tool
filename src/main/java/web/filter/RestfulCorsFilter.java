package web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class RestfulCorsFilter implements Filter {


	public void destroy() {
		
	}


	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) arg1;
        //该字段是必须的。它的值要么是请求时Origin字段的值，要么是一个*，表示接受任意域名的请求。
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        //该字段可选，用来指定本次预检请求的有效期，单位为秒。
        response.setHeader("Access-Control-Max-Age", "3600");
        //可以用来判断客户端的请求是Ajax请求还是其他请求，request.getHeader("x-requested-with")为 null，则为传统同步请求，为 XMLHttpRequest，则为 Ajax 异步请求。
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        arg2.doFilter(arg0, arg1);
	}


	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
