package ems.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import ems.entity.Employee;

@ControllerAdvice
public class SessionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		 if(!uri.endsWith("/") && !uri.endsWith("/login") && !uri.endsWith("/checkUser") && !uri.endsWith("/captchaimg"))
			 
		    {
			  
				 System.out.println("inspecting for bad url "+request.getRequestURI());
		      Employee usersession = (Employee) request.getSession().getAttribute("empsession");
		     if(usersession == null)
		      { 
		    	 
		    	/* throw new SessionUserValidationException("session Exception come");*/
		    		ModelAndView mav = new ModelAndView("redirect:/login");
					throw new ModelAndViewDefiningException(mav);
		    	    
		     }   
		  }
		  return true;
		 }
		

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
