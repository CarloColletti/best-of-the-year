package org.lessons.bestoftheyear.controller;

import org.lessons.bestoftheyear.model.movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller // dichiara che è una classe controller
@RequestMapping("/movies") //rotta a cui rispondono i controller, a questa rotta risponderanno i seguenti metodi
public class MovieController {

    //GET

    @GetMapping
    public String movie(Model model) {
        model.addAttribute("ListMovie", getBestMovies());
        return "movies";
    }
    @GetMapping("/{id}")
    public String movieDetail( Model model, @PathVariable int id){
        movie movie = null;
        for (movie m : getBestMovies()) {
            if(m.getId() == id) {
                movie = m;
            }
        }

        if(movie != null) {
            model.addAttribute("movie", movie);
            return "movieDetail";
        } else {
            return "redirect:/";
        }
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

}
