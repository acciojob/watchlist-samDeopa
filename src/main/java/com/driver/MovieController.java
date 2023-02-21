package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    HashMap<String, String> db = new HashMap<>();

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        String res = movieService.addMovie(movie);
        return  new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        String res = movieService.addDirector(director);
        return  new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    @PutMapping("/movies/add-movie-director-pair")
    public  ResponseEntity addMovieDirectorPair(@RequestParam("movie_name")String movieName, @RequestParam("director_name") String directorName ){
        String res = movieService.addMovieDirectorPair(movieName, directorName);
        return  new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public  ResponseEntity getMovieByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getMovieByName(name),HttpStatus.FOUND);

    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public  ResponseEntity getDirectorByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getDirectorByName(name),HttpStatus.FOUND);

    }
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public  ResponseEntity getMoviesByDirectorName(@PathVariable String director){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(director),HttpStatus.FOUND);

    }
    @GetMapping("/movies/get-all-movies")
    public  ResponseEntity findAllMovies(){
        return  new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.FOUND );
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public  ResponseEntity deleteDirectorByName(@RequestParam String directorName){
        return  new ResponseEntity<>(movieService.deleteDirectorByName(directorName), HttpStatus.OK );
    }

    @DeleteMapping("/movies/delete-all-directors")
    public  ResponseEntity deleteAllDirectors(){
        return  new ResponseEntity<>(movieService.deleteAllDirectors(), HttpStatus.OK );
    }

}
