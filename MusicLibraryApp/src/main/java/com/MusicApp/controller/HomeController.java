/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.controller;

import com.MusicApp.model.Music;
import com.MusicApp.model.Playlist;
import com.MusicApp.model.User;
import com.MusicApp.service.MusicService;
import com.MusicApp.service.PlaylistService;
import com.MusicApp.service.UserService;
import com.MusicApp.util.FileValidator;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author anshul
 */
@Controller
public class HomeController {
    
    HttpSession session;
    
    private static String UPLOAD_LOCATION="/home/anshul/temp/";
     
    @Autowired
    FileValidator fileValidator;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private MusicService musicService;
    
    @Autowired
    private PlaylistService playlistService;
    
    //binding addMusic key with Music object to upload file
    @InitBinder("addMusic")
    protected void initBinderFileBucket(WebDataBinder binder) {
       binder.setValidator(fileValidator);
    }
    
    //mapping of home page for user
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage(HttpServletRequest request,Model model,
            @RequestParam(value="username",required=false) String username,
            @RequestParam(value="password",required=false) String pwd,
            @RequestParam(value="search", required=false) String searchKeyword,
            Principal principal) {
        if(request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin";
        }
        if(principal!= null && principal.getName() != null){
            Music music = new Music();
            List<Music> myMusicList;
            List<Music> allMusicList;
            User user = userService.getUser(principal.getName());
            Playlist playlist = playlistService.getByUserId(user.getId());
            allMusicList = musicService.getAllMusicList();
            if(playlist != null) {
                myMusicList = musicService.getMusicListByUserPlaylist(user,playlist);
            }else {
                myMusicList = new LinkedList<Music>();
            }
            model.addAttribute("addMusic", music);
          
            model.addAttribute("user",user);
            model.addAttribute("allMusicList",allMusicList);
            model.addAttribute("myMusicList",myMusicList);
            return "home";
        } else {
            return "redirect:/index";
        }
    }
    
    @RequestMapping( value = "/home", method = RequestMethod.POST)
    public String addMusic(
            @Valid @ModelAttribute("addMusic") Music addMusic,
            BindingResult result,Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value="search",required=false) String searchKeyword,
            Principal principal
    ) throws IOException {
        List<Music> myMusicList;
        List<Music> allMusicList;
        User user = userService.getUser(principal.getName());
        if(request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin";
        }
        if(principal!= null && principal.getName() != null){
            if (result.hasErrors()) {
                model.addAttribute("message","Please fill the form correctly");
                model.addAttribute("flashKind","warning");
                System.out.println("validation errors");
                return "home";
            }else if(searchKeyword != null){
                List<Music> searchMusic;
                System.out.println(searchKeyword);
                searchMusic = musicService.searchByKeyword(searchKeyword);
                System.out.println(searchMusic.size());
                Playlist playlist = playlistService.getByUserId(user.getId());
                allMusicList = musicService.getAllMusicList();
                if(playlist != null) {
                    myMusicList = musicService.getMusicListByUserPlaylist(user,playlist);
                }else {
                    myMusicList = new LinkedList<Music>();
                }
                model.addAttribute("allMusicList",allMusicList);
                model.addAttribute("myMusicList",myMusicList);
                model.addAttribute("searchMusic",searchMusic);
                return "home";
            }else {            
                System.out.println("Fetching file");
                MultipartFile multipartFile = addMusic.getFile();

                //Now do something with file...
                FileCopyUtils.copy(addMusic.getFile().getBytes(), new File(UPLOAD_LOCATION + addMusic.getFile().getOriginalFilename()));
                addMusic.setFilePath("mp3/" + addMusic.getFile().getOriginalFilename());
                
                if(musicService.createMusic(addMusic) == -1) {
                    model.addAttribute("message","Music Already Exists");
                    model.addAttribute("flashKind","warning");
                }else {
                    Music music = musicService.getByMusicTitle(addMusic.getTitle());
                    Playlist playlist = new Playlist();
                    playlist.setUserId(user.getId());
                    playlist.setMusicId(music.getMusicId());
                    playlist.setArchived(false);
                    playlistService.createPlaylist(playlist);
                    String fileName = multipartFile.getOriginalFilename();
                    model.addAttribute("fileName", fileName);
                    model.addAttribute("message","Music Succesfully Uploaded");
                    model.addAttribute("flashKind","success");
                    response.setHeader("Refresh","3; URL=home");
                }
                Playlist playlist = playlistService.getByUserId(user.getId());
                allMusicList = musicService.getAllMusicList();
                if(playlist != null) {
                    myMusicList = musicService.getMusicListByUserPlaylist(user,playlist);
                }else {
                    myMusicList = new LinkedList<Music>();
                }
                model.addAttribute("allMusicList",allMusicList);
                model.addAttribute("myMusicList",myMusicList);
                return "home";
              }
        } else {
            return "redirect:/index";
        }
    }
    
}