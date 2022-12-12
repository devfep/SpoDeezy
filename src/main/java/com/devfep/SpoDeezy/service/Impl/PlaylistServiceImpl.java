package com.devfep.SpoDeezy.service.Impl;

import com.devfep.SpoDeezy.dto.PlaylistItemDto;
import com.devfep.SpoDeezy.dto.Root;
import com.devfep.SpoDeezy.entity.Playlist;
import com.devfep.SpoDeezy.repository.PlaylistRepository;
import com.devfep.SpoDeezy.service.PlaylistService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.model_objects.specification.Image;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.PlaylistSimplified;
import se.michaelthelin.spotify.model_objects.specification.PlaylistTrack;
import se.michaelthelin.spotify.requests.data.playlists.GetListOfCurrentUsersPlaylistsRequest;
import se.michaelthelin.spotify.requests.data.playlists.GetPlaylistsItemsRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

import static com.devfep.SpoDeezy.controllers.SpotifyAuthenticationController.spotifyApi;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    @Autowired
    PlaylistRepository playlistRepository;
    public static List<PlaylistItemDto> listOfPlaylists = new ArrayList<>();
    PlaylistItemDto playlistItemDto;
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    Gson gson;


    public List<PlaylistItemDto> getListOfCurrentUsersPlaylists_Async() throws JsonProcessingException, ExecutionException, InterruptedException {

        final GetListOfCurrentUsersPlaylistsRequest getListOfCurrentUsersPlaylistsRequest = spotifyApi
                .getListOfCurrentUsersPlaylists()
                .limit(20)
                .offset(0)
                .build();

        try {
            final CompletableFuture<Paging<PlaylistSimplified>> pagingFuture = getListOfCurrentUsersPlaylistsRequest.executeAsync();


            final Paging<PlaylistSimplified> playlistSimplifiedPaging = pagingFuture.get();


            System.out.println(playlistSimplifiedPaging.getTotal());


            String json = gson.toJson(playlistSimplifiedPaging);
            Root root = objectMapper.readValue(json, Root.class);

            for (int i = 0; i < root.getItems().size(); i++) {

                String newJson = gson.toJson(root.getItems().get(i));
                System.out.println(newJson);
                playlistItemDto = objectMapper.readValue(newJson, PlaylistItemDto.class);
                playlistItemDto.setImageUrl(playlistItemDto);
                playlistItemDto.setTotalNumberOfTracks(playlistItemDto);
                listOfPlaylists.add(playlistItemDto);
            }

            for (int i = 0; i < listOfPlaylists.size(); i++) {
                listOfPlaylists.get(i).setListOfIsrc(getPlaylistsItems_Async(listOfPlaylists.get(i).getSpotifyPlaylistId()));
                System.out.println("final result" + listOfPlaylists.toString());
            }
            return listOfPlaylists;

        } catch (CompletionException e) {
            System.out.println("Error: " + e.getCause().getMessage());
        } catch (CancellationException e) {
            System.out.println("Async operation cancelled.");
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public List<String> getPlaylistsItems_Async(String playlistId) throws JsonProcessingException {
        List<String> isrcList = new ArrayList<>();

        final GetPlaylistsItemsRequest getPlaylistsItemsRequest = spotifyApi
                .getPlaylistsItems(playlistId)
                .limit(20)
                .additionalTypes("track")
                .build();
        try {
            final CompletableFuture<Paging<PlaylistTrack>> pagingFuture = getPlaylistsItemsRequest.executeAsync();

            final Paging<PlaylistTrack> playlistTrackPaging = pagingFuture.get();

            for (int i = 0; i < playlistTrackPaging.getItems().length; i++) {
                String json = gson.toJson(playlistTrackPaging.getItems()[i].getTrack());

                JsonNode root = objectMapper.readTree(json);
                String isrcValue = root.get("externalIds").get("externalIds").get("isrc").asText();

                isrcList.add(isrcValue);
            }
            return isrcList;

        } catch (CompletionException e) {
            System.out.println("Error: " + e.getCause().getMessage());
        } catch (CancellationException e) {
            System.out.println("Async operation cancelled.");
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @Override
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    @Override
    public void savePlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
    }

    @Override
    public Playlist getPlaylistById(Long id) {
        Optional<Playlist> optional = playlistRepository.findById(id);
        Playlist playlist;
        if (optional.isPresent()){
            playlist = optional.get();
        } else {
            throw new RuntimeException("Playlist not found");
        }
        return playlist;

    }

    @Override
    public void deletePlaylistById(Long id){
        playlistRepository.deleteById(id);
    }
}

