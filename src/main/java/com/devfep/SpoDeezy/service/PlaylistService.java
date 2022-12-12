package com.devfep.SpoDeezy.service;

import com.devfep.SpoDeezy.entity.Playlist;

import java.util.List;

public interface PlaylistService {
    List<Playlist> getAllPlaylists();

    void savePlaylist(Playlist playlist);

    Playlist getPlaylistById(Long id);

    void deletePlaylistById(Long id);
}
