package agh.ii.jtp.fp;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;


import static agh.ii.jtp.fp.dal.ImdbTop250.movies;
import static java.util.Map.Entry.comparingByValue;


public class PlayWithMovies {

    /**
     * Returns the movies (only titles) directed (or co-directed) by a given director
     */


    static List<String> ex01(String director){

       List l = movies().stream()
               .flatMap(Collection::stream)
               .map(film->film.title()+ "#" +film.directors())
               .filter(e->e.contains(director))
               .map(e->e.substring(0,e.indexOf("#")))
               .toList();

        System.out.println("test1 " + l);

        return l;
    }





    /**
     * Returns the movies (only titles) in which an actor played
     */
    static Set<String> ex02(String actor) {

        Set s = movies().stream()
                .flatMap(Collection::stream)
                .map(film->film.title()+ "#" +film.actors())
                .filter(e->e.contains(actor))
                .map(e->e.substring(0,e.indexOf("#")))
                .collect(Collectors.toSet());

        System.out.println("test1 " + s);
        return s;
    }

    /**
     * Returns the number of movies per director (as a map)
     */
    static Map<String,Long> ex03() {

        Map m =  movies().stream()
                .flatMap(Collection::stream)
                .map(film->film.directors())
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(x -> x, x -> 1L, (x1, x2) -> x1+x2));
        System.out.println("test1 " + m);
        return  m;
    }

    /**
     * Returns the 10 directors with the most films on the list
     */
    static Map<String, Long> ex04() {

        Map m =  movies().stream()
                .flatMap(Collection::stream)
                .map(film->film.directors())
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(x -> x, x -> 1L, (x1, x2) -> x1+x2))

                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new))

                .entrySet().stream()
                .limit(10L)
                .collect(Collectors.toMap(x->x.getKey(), x-> x.getValue()))

                ;




        System.out.println("test1 " + m);
        return  m;
    }

    /**
     * Returns the movies (only titles) made by each of the 10 directors found in {@link PlayWithMovies#ex04 ex04}
     */

    static Map<String, Set<String>> ex05() {
        throw new RuntimeException("ex05 is not implemented!");
    }

    /**
     * Returns the number of movies per actor (as a map)
     */
    static Map<String, Long> ex06() {

        Map m =  movies().stream()
                .flatMap(Collection::stream)
                .map(film->film.actors())
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(x -> x, x -> 1L, (x1, x2) -> x1+x2));
        System.out.println("test1 " + m);
        return  m;
    }

    /**
     * Returns the 9 actors with the most films on the list
     */
    static Map<String, Long> ex07() {

        Map m =  movies().stream()
                .flatMap(Collection::stream)
                .map(film->film.actors())
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(x -> x, x -> 1L, (x1, x2) -> x1+x2))

                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new))

                .entrySet().stream()
                .limit(9L)
                .collect(Collectors.toMap(x->x.getKey(), x-> x.getValue()));

        System.out.println("test1 " + m);
        return  m;

    }

    /**
     * Returns the movies (only titles) of each of the 9 actors from {@link PlayWithMovies#ex07 ex07}
     */
    static Map<String, Set<String>> ex08() {
        throw new RuntimeException("ex08 is not implemented!");
    }

    /**
     * Returns the 5 most frequent actor partnerships (i.e., appearing together most often)
     */
    static Map<String, Long> ex09() {
        throw new RuntimeException("ex08 is not implemented!");
    }

    /**
     * Returns the movies (only titles) of each of the 5 most frequent actor partnerships
     */
    static Map<String, Set<String>> ex10() {
        throw new RuntimeException("ex10 is not implemented!");
    }
}


