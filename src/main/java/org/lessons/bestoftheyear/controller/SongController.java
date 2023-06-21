package org.lessons.bestoftheyear.controller;

import org.lessons.bestoftheyear.model.movie;
import org.lessons.bestoftheyear.model.song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller // dichiara che è una classe controller
@RequestMapping("/songs") //rotta a cui rispondono i controller, a questa rotta risponderanno i seguenti metodi
public class SongController {

    //GET
    @GetMapping
    public String song(Model model) {
        model.addAttribute("ListSong", getBestSongs());
        return "songs";
    }

    @GetMapping("/{id}")
    public String songDetail( Model model, @PathVariable int id){
        song song = null;
        for (song s : getBestSongs()) {
            if(s.getId() == id) {
                song = s;
            }
        }

        if(song != null) {
            model.addAttribute("song", song);
            return "songDetail";
        } else {
            return "redirect:/";
        }
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

