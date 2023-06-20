package org.lessons.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller // dichiara che è una classe controller
@RequestMapping("/") //rotta a cui rispondono i controller, a questa rotta risponderanno i seguenti metodi
public class IndexController {

    //GET
    @GetMapping //risponde a richieste di tipo get
    public String home (Model model){ //invoco metodo model per creare oggetti da mandare insieme al return
        model.addAttribute("name", "Carlo");
        return "index"; // nome del template da rimandare
    }

    @GetMapping("/movies")
    public String movie(Model model) {
        List<movie> movies = getBestMovies();
        List<String> movieName = new ArrayList<>();
        for (movie m : movies) {
            movieName.add(m.getName());
        }

        String ListMovie = String.join(", ", movieName);
        model.addAttribute("ListMovie", ListMovie);
        return "movies";
    }

    @GetMapping("/songs")
    public String song(Model model){
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
    private List<movie> getBestMovies() {
        List<movie> movies = new ArrayList<>();
        movies.add(new movie(1, "Batman"));
        movies.add(new movie(2, "Resident Evil"));
        movies.add(new movie(3, "Inception"));
        movies.add(new movie(4, "ioRobot"));

        return movies;
    }

    private List<song> getBestSongs() {
        List<song> songs = new ArrayList<>();
        songs.add(new song(1, "O2"));
        songs.add(new song(2, "Alive"));
        songs.add(new song(3, "Zero Eclipse"));
        songs.add(new song(4, "Devils Never Cry"));

        return songs;
    }


    //PUBLIC CLASS

    //movie
    public class movie{
        //attribute
        private int id;
        private String name;

        //constructor
        public movie(int id, String name) {
            this.id = id;
            this.name = name;
        }
        //getter

        public String getName() {
            return name;
        }
    }


    //song
    public class song{
        //attribute
        private int id;
        private String name;

        //constructor
        public song(int id, String name) {
            this.id = id;
            this.name = name;
        }
        //getter

        public String getName() {
            return name;
        }
    }
}
