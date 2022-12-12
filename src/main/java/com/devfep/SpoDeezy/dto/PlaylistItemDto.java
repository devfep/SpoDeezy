package com.devfep.SpoDeezy.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class PlaylistItemDto {
    @JsonProperty("id")
    private String spotifyPlaylistId;
    private List<Image> images;
    private String imageUrl;
    private int totalNumberOfTracks;
    private Tracks tracks;
    @JsonProperty("name")
    private String playlistName;
    private List<String> listOfIsrc;
    private List<String> listOfSongIds;

    public void setImageUrl(PlaylistItemDto playlistItemDto) {
        this.imageUrl = playlistItemDto.getImages().get(0).getUrl();
    }

    public void setTotalNumberOfTracks(PlaylistItemDto playlistItemDto) {
        this.totalNumberOfTracks = playlistItemDto.getTracks().getTotal();
    }


}
