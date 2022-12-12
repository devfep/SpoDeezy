package com.devfep.SpoDeezy.controllers;

import com.devfep.SpoDeezy.entity.Playlist;
import com.devfep.SpoDeezy.service.PlaylistService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ExecutionException;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/playlist-console")
public class PlaylistConsoleController {

    @Autowired
    PlaylistService playlistService;

    @Autowired
    DashboardController dashboardController;

    @RequestMapping("")
    public String displayPlaylistConsole(Model model, Authentication authentication) throws ExecutionException, JsonProcessingException, InterruptedException {

        model.addAttribute("username", authentication.getName());
        model.addAttribute("listOfSavedPlaylists", playlistService.getAllPlaylists());


        return "playlist-console";
    }


    @DeleteMapping("/{id}")
    public String deletePlaylistFromDB(@PathVariable(value = "id") long id, Model model){
        System.out.println(id);
        playlistService.deletePlaylistById(id);

        return "redirect:/playlist-console";
    }
}
