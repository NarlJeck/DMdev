package collectionCinema.util;

import collectionCinema.entity.Film;

import java.util.*;

public final class CinemaUtil {

    private CinemaUtil() {
    }



    public static List<Film> getAllFilmsOfYear(Integer year, LinkedHashMap<Integer, List<Film>> mapCinema) {
        if (mapCinema.containsKey(year)) {
            return mapCinema.get(year);
        }
        return null;
    }

    public static List<Film> getAllFilmsOfYearAndMonth(Integer year, Integer month,LinkedHashMap<Integer, List<Film>> mapCinema) {
        List<Film> arrayFilmsYearAndMonth = new ArrayList<>();
        if (mapCinema.containsKey(year)) {
            List<Film> films = mapCinema.get(year);
            for (Film film : films) {
                if (Objects.equals(film.getMonthPublication(), month)) {
                    arrayFilmsYearAndMonth.add(film);

                }

            }
            return arrayFilmsYearAndMonth;
        }
        return null;
    }
    public static List<Film> getAllFilmsOfGenre(String genre,LinkedHashMap<Integer, List<Film>> mapCinema) {
        List<Film> arrayFilmsByGenre = new ArrayList<>();
        Set<Map.Entry<Integer, List<Film>>> entries = mapCinema.entrySet();
        for (Map.Entry<Integer, List<Film>> entry : entries) {
            List<Film> value = entry.getValue();
            for (Film film : value) {
                if (film.getGenre().equalsIgnoreCase(genre)) {
                    arrayFilmsByGenre.add(film);
                }

            }
        }
        return arrayFilmsByGenre;
    }
    public static List<Film> getTopTenFilmsOfRating(LinkedHashMap<Integer, List<Film>> mapCinema) {
        List<Film> allFilms = new ArrayList<>();
        List<Film>topTenFilmsOfRating = new ArrayList<>();
        Set<Map.Entry<Integer, List<Film>>> entries = mapCinema.entrySet();
        for (Map.Entry<Integer, List<Film>> entry : entries) {
            List<Film> value = entry.getValue();
            allFilms.addAll(value);
        }
        Collections.sort(allFilms);
        for (int i=0;i<10;i++) {
            topTenFilmsOfRating.add(allFilms.get(i));
        }

        return topTenFilmsOfRating;
    }


}
