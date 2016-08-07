/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.controller;

import com.MusicApp.domain.Tag;
import com.MusicApp.model.Music;
import com.MusicApp.service.MusicService;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author anshul
 */
@Controller
public class SearchController {
    
    @Autowired
    private MusicService musicService;
    
    List<Tag> data = new ArrayList<Tag>();
    
    
    public SearchController(){
    }

    //tags in json format
    @RequestMapping(value = "/getTags", method = RequestMethod.GET)
	public @ResponseBody
	List<Tag> getTags(@RequestParam String tagName,
                HttpServletRequest request,
                HttpServletResponse response,
                Principal principal) throws IOException {
            if(request.isUserInRole("ROLE_ADMIN")) {
                response.sendRedirect("admin");
            }
            if(principal!= null && principal.getName() != null){
                return simulateSearchResult(tagName);
            }else {
                response.sendRedirect("index");
            }
            return null;
	}

	private List<Tag> simulateSearchResult(String tagName) {
                data.clear();
                List<Music> searchMusic;
                searchMusic = musicService.searchByKeyword(tagName);
                System.out.println(searchMusic.size());
                ListIterator<Music> listIterator = searchMusic.listIterator();
	        int i=0;
                while (listIterator.hasNext()) {
                    Music music = listIterator.next();
                    data.add(new Tag(i,music.getTitle()));
                    i++;
	        }
		List<Tag> result = new ArrayList<Tag>();
                // iterate a list and filter by tagName
		for (Tag tag : data) {
			result.add(tag);
		}
                System.out.println(result.size()+" "+data.size());
		
		return result;
	}   
        
    //mapping for search result
    @RequestMapping(value = "/search")
    @ResponseBody
    public List<Music> searchPage(Model model,HttpServletRequest request,
            @RequestParam(required=false) String searchKeyword,
             HttpServletResponse response,
             Principal principal) throws IOException {
        if(request.isUserInRole("ROLE_ADMIN")) {
           response.sendRedirect("admin");
        }
        if(principal!= null && principal.getName() != null){
            List<Music> searchMusic;
            System.out.println(searchKeyword);
            searchMusic = musicService.searchByKeyword(searchKeyword);
            System.out.println(searchMusic.size());
            model.addAttribute("addMusic",new Music());
            request.setAttribute("searchMusic",searchMusic);
            return searchMusic;
        } else {
            response.sendRedirect("index");
        }
        return null;
    }
}
