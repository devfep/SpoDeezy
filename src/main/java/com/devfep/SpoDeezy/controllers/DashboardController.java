package com.devfep.SpoDeezy.controllers;

import com.devfep.SpoDeezy.dto.PlaylistItemDto;
import com.devfep.SpoDeezy.entity.Playlist;
import com.devfep.SpoDeezy.service.Impl.PlaylistServiceImpl;
import com.devfep.SpoDeezy.service.PlaylistService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {
    @Autowired
    private PlaylistServiceImpl playlistServiceImpl;

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private ModelMapper mapper;

    protected  List<PlaylistItemDto> playlistsToBackUp = new ArrayList<>();

//    @Autowired
//    private PlaylistRepository playlistRepository;


    @RequestMapping("")
    public String displayDashboard(Model model, Authentication authentication) throws ExecutionException, JsonProcessingException, InterruptedException {
        model.addAttribute("username", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        if (model.containsAttribute("playlistBackUp")){
            return "dashboard.html";
        }
        model.addAttribute("playlistBackUp", new Playlist());
        try{

            List<PlaylistItemDto> returnObj = playlistServiceImpl.getListOfCurrentUsersPlaylists_Async();
            model.addAttribute("listOfPlaylists", returnObj);
            playlistsToBackUp = returnObj;

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return "dashboard.html";
    }


    @PostMapping("/playlist-backup")
    public String backupPlaylist(@ModelAttribute("playlistBackUp") Playlist playlist, Authentication authentication, RedirectAttributes redirectAttrs){

        playlistService.savePlaylist(playlist);

        redirectAttrs.addFlashAttribute("message", "Playlist saved");

        return "redirect:/dashboard";
    }




}
