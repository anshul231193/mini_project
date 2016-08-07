/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.controller;

import com.MusicApp.model.Music;
import com.MusicApp.service.MusicService;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anshul
 */
@Controller
public class AdminController {
    
    @Autowired
    private MusicService musicService;
    
    //mapping for admin section
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage(Principal principal,
                HttpServletRequest request,
                HttpServletResponse response) throws Exception {
          if(request.isUserInRole("ROLE_ADMIN")) {
            List<Music> allMusicList;
            allMusicList = musicService.getAllMusicList();
            ModelAndView model = new ModelAndView();
            model.addObject("title", "Spring Security Login Form - Database Authentication");
            model.addObject("message", "This page is for ROLE_ADMIN only!");
            model.addObject("allMusicList", allMusicList);
            model.setViewName("admin");
            return model;
          }
        if(principal!= null && principal.getName() != null){
            response.sendRedirect("home");
            return null;
        }else {
            response.sendRedirect("index");
            return null;
        }
          
	}
        
        //mapping for edditing music section
        @RequestMapping(value = "/admin/updateMusic", method = RequestMethod.GET)
        public String updateMusic(Model model,
                HttpServletRequest request,
                HttpServletResponse response,
                Principal principal,
                @RequestParam int musicId) throws IOException {
            if(request.isUserInRole("ROLE_ADMIN")) {
                Music music = musicService.getByMusicId(musicId);
                model.addAttribute("music", music);
                return "editMusic";
            }if(principal!= null && principal.getName() != null){
                return "redirect:/home";
            }else {
                return "redirect:/index";
            }
            
        }
        
        @RequestMapping(value = "/admin/updateMusic", method = RequestMethod.POST)
        public String editMusic(Model model,
                @RequestParam int musicId,
                @RequestParam String genre,
                @RequestParam String title,
                @RequestParam String desc,
                @RequestParam String lyrics,
                @RequestParam String artistName,
                @RequestParam String albumName,
                HttpServletResponse response) throws IOException{
            
            if(musicService.getByMusicTitle(title) != null &&
                    musicId != musicService.getByMusicTitle(title).getMusicId()) {
                model.addAttribute("message","Music Title should be unique. Already Exists!!");
                model.addAttribute("flashKind", "warning");
                Music music = musicService.getByMusicId(musicId);
                model.addAttribute("music", music);
                return "editMusic";
            }
            Music music = musicService.getByMusicId(musicId);
            music.setMusicGenre(genre);
            music.setTitle(title);
            music.setDescription(desc);
            music.setLyrics(lyrics);
            music.setArtistName(artistName);
            music.setAlbumName(albumName);
            music.setArchived(false);
            musicService.update(music);
            model.addAttribute("message","Music successfully updated!!");
            model.addAttribute("flashKind", "success");
            response.setHeader("Refresh", "3;url=../admin");
            return "editMusic";
        }
}
