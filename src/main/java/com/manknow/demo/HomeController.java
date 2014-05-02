package com.manknow.demo;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manknow.demo.dao.CarDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Resource
	CarDao d;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/abc.html", method = RequestMethod.GET)
	public String home(Locale locale, HttpSession session, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		d.addCarHistory();
		String s = (String) session.getAttribute("success");
		
		return "home";
	}
	@RequestMapping(value = "/test.html", method = RequestMethod.GET)	 
	 public String getSessionIncontroller
	         (HttpSession session) 
	{

	  session.setAttribute("success" , "successfully accessed");
	  return "home";
	 }
	
}
