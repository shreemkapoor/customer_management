package ems.controller;


import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice

public class ExceptionController {

/*	static Logger logger = Logger.getLogger(LoggerInterceptor.class);
*/	
	@ExceptionHandler({SQLException.class,DataAccessException.class})
	public String handleSQLException(HttpServletRequest request, Exception ex,Model model,HttpSession session){
		//ex.printStackTrace();
		//System.out.println("This is global exception handler for SQLException and DataAccessException");
		
		//logger.info("SQLException Occured:: URL="+request.getRequestURL());
		model.addAttribute("errors", "The sql error selected");
		 model.addAttribute("exception", ex);
		    model.addAttribute("url", request.getRequestURL());
		session.invalidate();
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	  public String handleError(HttpServletRequest req, Exception ex,Model model,HttpSession session) {
		System.out.println("404error");
	   //logger.error("Request: " + req.getRequestURL() + " raised " + ex);
	    
	    ex.printStackTrace();
  System.out.println( ex.getClass());
	    model.addAttribute("exception", ex.getClass());
	    model.addAttribute("errors", "The global error selected");
		session.invalidate();
	    return "error";
	  }
	
	
}
