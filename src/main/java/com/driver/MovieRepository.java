package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String, Movie> movieDB = new HashMap<>();
    HashMap<String, Director> directorDB = new HashMap<>();

    HashMap<String, List<String> >  pairDB = new HashMap<>();


    public  String addMovie(Movie movie){
        movieDB.put(movie.name, movie);
        return "Successfully Created";
    }
    public  String addDirector(Director director){
        directorDB.put(director.name, director);
        return "Successfully Created";
    }
    public  String addMovieDirectorPair(String movieName, String directorName ){
        if(pairDB.containsKey(directorName)){
            pairDB.get(directorName).add(movieName);
        }else {
            List<String> lis = new ArrayList<>();
            lis.add(movieName);
            pairDB.put(directorName,  lis);
        }

        return  "successfully paired";
    }
    public  Movie getMovieByName( String name){
        return movieDB.get(name);
    }

    public  Director getDirectorByName( String name){
        return directorDB.get(name);
    }


    public List getMoviesByDirectorName(String name) {
        return  pairDB.get(name);
    }

    public List findAllMovies() {
        List<String> allMovies = new ArrayList<>();
        for(String name: movieDB.keySet()){
            allMovies.add(name);
        }
        return allMovies;
    }

    public String deleteDirectorByName(String directorName) {
        List<String> lis = pairDB.get(directorName);
        for(String movieName:lis){
            movieDB.remove(movieName);
        }
        directorDB.remove(directorName);
        pairDB.remove(directorName);
        return "Removed all the movies";
    }


    public String deleteAllDirectors() {
        for(String directorName: pairDB.keySet()){
            deleteDirectorByName(directorName);
        }
        return  "removed all the directors";
    }
}
