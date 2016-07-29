/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.controller;

import com.MusicApp.model.Music;
import com.MusicApp.service.MusicService;
import java.util.List;
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
    
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String searchPage(Model model,HttpServletRequest request,
            @RequestParam(name="search") String searchKeyword,
             HttpServletResponse response) {
        List<Music> searchMusic;
        System.out.println(searchKeyword);
        searchMusic = musicService.searchByKeyword(searchKeyword);
        System.out.println(searchMusic.size());
        model.addAttribute("addMusic",new Music());
        request.setAttribute("searchMusic",searchMusic);
        return "home";
        
    }
}
