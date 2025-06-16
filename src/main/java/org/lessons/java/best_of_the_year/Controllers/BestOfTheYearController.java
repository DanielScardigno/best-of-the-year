package org.lessons.java.best_of_the_year.controllers;

import java.util.List;

import org.lessons.java.best_of_the_year.models.Movie;
import org.lessons.java.best_of_the_year.models.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class BestOfTheYearController {
    
    @GetMapping("/")
    public String BestOfTheYearBy(Model model, @RequestParam(name = "name") String name) {
        
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

        model.addAttribute("name", name);
        return "index";
    }

    private List<Movie> getBestMovies() {
        return List.of(
            new Movie("1", "Interstellar"),
            new Movie("2", "How to train your dragon"),
            new Movie("3", "Jurassic Park")
        );
    }

    private List<Song> getBestSongs() {
        return List.of(
            new Song("1", "Loreen - Is it love"),
            new Song("2", "Alfa - A me mi piace"),
            new Song("3", "Damiano David - The first time")
        );
    }

    @GetMapping("/movies")
    public String setMovies(Model model) {

        model.addAttribute("movies", getBestMovies());

        return "movies";
    }

    @GetMapping("/songs")
    public String setSongs(Model model) {

        model.addAttribute("songs", getBestSongs());

        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String getMoviesbyId(Model model, @PathVariable("id") String movieId) {

        for (Movie movie : getBestMovies()) {
            if (movie.getId().equals(movieId)) {
                model.addAttribute("movieById", movie.getTitle());
            }
        }

        return "movieId";
    }

    @GetMapping("/songs/{id}")
    public String getSongsbyId(Model model, @PathVariable("id") String songId) {

        for (Song song : getBestSongs()) {
            if (song.getId().equals(songId)) {
                model.addAttribute("movieById", song.getTitle());
            }
        }

        return "movieId";
    }
}