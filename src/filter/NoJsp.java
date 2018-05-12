package filter;

import javax.servlet.*;
import java.io.IOException;


public class NoJsp implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		RequestDispatcher reqDispatcher=arg0.getRequestDispatcher("404.html");
        reqDispatcher.forward(arg0, arg1);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
