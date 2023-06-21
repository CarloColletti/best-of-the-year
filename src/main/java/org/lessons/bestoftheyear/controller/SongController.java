package org.lessons.bestoftheyear.controller;

import org.lessons.bestoftheyear.model.movie;
import org.lessons.bestoftheyear.model.song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller // dichiara che è una classe controller
@RequestMapping("/songs") //rotta a cui rispondono i controller, a questa rotta risponderanno i seguenti metodi
public class SongController {

    //GET
    @GetMapping
    public String song(Model model) {
        List<song> songs = getBestSongs();
        List<String> songName = new ArrayList<>();
        for (song s : songs) {
            songName.add(s.getName());
        }
        String ListSong = String.join(", ", songName);
        model.addAttribute("listSong", ListSong);
        return "songs";
    }

    //PRIVATE METHOD

    private List<song> getBestSongs() {
        List<song> songs = new ArrayList<>();
        songs.add(new song(1, "O2"));
        songs.add(new song(2, "Alive"));
        songs.add(new song(3, "Zero Eclipse"));
        songs.add(new song(4, "Devils Never Cry"));

        return songs;
    }
}

