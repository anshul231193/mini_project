/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.exception;
import java.io.IOException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import com.MusicApp.exception.KeywordNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    
          //handling all thn exceptions in general
	  @ExceptionHandler(Exception.class)
	  public ModelAndView myError(Exception exception) {
	    System.out.println("----Caught Exception----");
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", exception);
	    mav.setViewName("globalerror");
	    return mav;
	  }
          
          //handling keyword not found exception
	  @ExceptionHandler(KeywordNotFoundException.class)
	  public String notFound() {
            System.out.println("----Caught KeywordNotFoundException----");
            return "404";
	  }
} 
