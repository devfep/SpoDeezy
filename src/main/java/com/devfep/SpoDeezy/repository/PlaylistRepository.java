package com.devfep.SpoDeezy.repository;

import com.devfep.SpoDeezy.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    Playlist findPlaylistByUserId(Long id);
}
