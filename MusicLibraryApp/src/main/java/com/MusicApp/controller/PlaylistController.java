/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.controller;

import com.MusicApp.model.Music;
import com.MusicApp.model.Playlist;
import com.MusicApp.service.PlaylistService;
import com.MusicApp.service.UserService;
import java.io.IOException;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author anshul
 */
@Controller
public class PlaylistController {
    
    @Autowired
    private PlaylistService playlistService;
    
    @Autowired
    private UserService userService;
    
    
    @RequestMapping(value = "/mp3/**", method = RequestMethod.GET)
    public void mp3(Principal principal,Model model,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException{
        if(principal!= null && principal.getName() != null){
            
        }else {
            response.sendRedirect(request.getContextPath());
        }
    }


    
    @RequestMapping(value = "/addToPlaylist", method = RequestMethod.GET)
    public String addPlaylist(HttpServletRequest request,
            HttpServletResponse response,
            Principal principal,
            Model model,
            @RequestParam int musicId,
            @RequestParam(required=false) Integer userId){
            if(request.isUserInRole("ROLE_ADMIN")) {
                return "redirect:/admin";
            }
            if(principal!= null && principal.getName() != null){
                model.addAttribute("addMusic",new Music());
                if(userId == null) {
                    userId = new Integer(userService.getUser(principal.getName()).getId());
                }
                Playlist playlist = playlistService.findByMusicUserId(musicId,userId);
                if(playlist!=null){
                   model.addAttribute("msgAddPlaylist","Already Added to your Playlist");
                   model.addAttribute("flashKind","warning");
                }else {
                    playlist = new Playlist();
                    playlist.setMusicId(musicId);
                    playlist.setUserId(userId);
                    playlist.setArchived(false);
                    playlistService.createPlaylist(playlist);
                    model.addAttribute("flashKind", "success");
                    model.addAttribute("msgAddPlaylist","Successfully Added to your Playlist!! Enjoy");
                }
                response.setHeader("Refresh","3; URL=home");
                return "home";
            }else {
                return "redirect:/index";
            }

    }
    
    @RequestMapping(value = "/deleteFromPlaylist", method = RequestMethod.GET)
    public String deleteSong(HttpServletRequest request,
            HttpServletResponse response,
            Principal principal,
            Model model,
            @RequestParam int musicId,
            @RequestParam int userId){
        if(request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin";
        }
        if(principal!= null && principal.getName() != null){
            model.addAttribute("addMusic",new Music());
            Playlist playlist = playlistService.findByMusicUserId(musicId,userId);
            playlist.setArchived(true);
            playlistService.deleteSong(playlist);
            model.addAttribute("msgAddPlaylist","Song archived from your playlist!!");
            model.addAttribute("flashKind","warning");
            response.setHeader("Refresh", "3;url=home");
            return "home";
        }else{
            return "redirect:/index";
        }
        
    }
}
