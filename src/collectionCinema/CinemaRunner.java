package collectionCinema;

import collectionCinema.entity.Cinema;
import collectionCinema.entity.Film;
import collectionCinema.util.CinemaUtil;

import java.util.*;

public class CinemaRunner {
    public static void main(String[] args) {
        Film film1 = new Film(1, 1999, 10, "Ужасы", 7.1);
        Film film2 = new Film(2, 2001, 11, "Фентези", 6.6);
        Film film3 = new Film(3, 2004, 5, "Детектив", 7.0);
        Film film4 = new Film(4, 1999, 9, "Драма", 8.0);
        Film film5 = new Film(5, 2023, 5, "Фентези", 7.5);
        Film film6 = new Film(6, 2008, 11, "Ужасы", 4.0);
        Film film7 = new Film(7, 2024, 1, "Комедия", 2.1);
        Film film8 = new Film(8, 2002, 2, "Комедия", 4.5);
        Film film9 = new Film(9, 2015, 3, "Драма", 6.3);
        Film film10 = new Film(10, 2003, 4, "Детектив", 8.5);
        Film film11 = new Film(11, 2004, 6, "Ужасы", 7.0);
        Film film12 = new Film(12, 2024, 11, "Фентези", 9.1);
        Film film13 = new Film(13, 2011, 12, "Драма", 4.5);
        Film film14 = new Film(14, 2015, 7, "Ужасы", 5.2);
        Film film15 = new Film(15, 2001, 11, "Комедия", 6.3);
        Film film16 = new Film(16, 1999, 8, "Фентези", 8.2);
        Film film17 = new Film(17, 1989, 7, "Детектив", 2.8);
        Film film18 = new Film(18, 1990, 6, "Драма", 9.5);
        Film film19 = new Film(19, 2004, 11, "Ужасы", 8.0);
        Film film20 = new Film(20, 2023, 10, "Фентези", 9.8);

        Cinema cinema = new Cinema(new LinkedHashMap<>());
        /**
         * Добавление нового фильма в кинотеатр
         */
        cinema.addNewFilmInCinema(film1);
        cinema.addNewFilmInCinema(film2);
        cinema.addNewFilmInCinema(film3);
        cinema.addNewFilmInCinema(film4);
        cinema.addNewFilmInCinema(film5);
        cinema.addNewFilmInCinema(film6);
        cinema.addNewFilmInCinema(film7);
        cinema.addNewFilmInCinema(film8);
        cinema.addNewFilmInCinema(film9);
        cinema.addNewFilmInCinema(film10);
        cinema.addNewFilmInCinema(film11);
        cinema.addNewFilmInCinema(film12);
        cinema.addNewFilmInCinema(film13);
        cinema.addNewFilmInCinema(film14);
        cinema.addNewFilmInCinema(film15);
        cinema.addNewFilmInCinema(film16);
        cinema.addNewFilmInCinema(film16);
        cinema.addNewFilmInCinema(film17);
        cinema.addNewFilmInCinema(film18);
        cinema.addNewFilmInCinema(film19);
        cinema.addNewFilmInCinema(film20);


//        System.out.println(cinema);
//        for (Map.Entry<Integer, List<Film>> films : cinema.getMapCinema().entrySet()) {
//            List<Film> value = films.getValue();
//            for (Film film : value){
//                System.out.println(film);
//            }
//        }

        /**
         * TOP 10 films
         */
//        List<Film> topTenFilmsOfRating = CinemaUtil.getTopTenFilmsOfRating(cinema.getMapCinema());
//        for (Film film : topTenFilmsOfRating) {
//            System.out.println(film);
//        }
        /**Все фильмы жанра "Фентези"
         *
         */
//        List<Film> fantasy = CinemaUtil.getAllFilmsOfGenre("Фентези",cinema.getMapCinema());
//        for (Film film : fantasy) {
//            System.out.println(film);
//        }

        /**
         * Все фильмы за 2001 год 11 месяц
         */
//        List<Film> allFilmsOfYearAndMonth = CinemaUtil.getAllFilmsOfYearAndMonth(2001, 11,cinema.getMapCinema());
//        for (Film film : allFilmsOfYearAndMonth) {
//            System.out.println(film);
//        }
        /**
         * Все фильмы за 2001 год
         */
//        List<Film> allFilmsOfYear = CinemaUtil.getAllFilmsOfYear(2001,cinema.getMapCinema());
//        for (Film film : allFilmsOfYear) {
//            System.out.println(film);
//        }


    }


}
