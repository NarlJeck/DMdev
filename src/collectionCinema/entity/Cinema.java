package collectionCinema.entity;


import java.util.*;

/**
 * Задание 1
 * <p>
 * Даны 2 класса:
 * <p>
 * - Фильм с 5-ю полями: Уникальный Целочисленный идентификатор (id), Год издания, Месяц издания, Жанр и Рейтинг;
 * <p>
 * - Кинотеатр, где есть всего лишь одно единственное поле: отсортированный ассоциативный массив, где ключом является
 * год издания, а значением - все фильмы, выпустившиеся в этом году.
 * <p>
 * Добавить функционал в кинотеатр таким образом, чтобы можно было:
 * <p>
 * - добавлять в него новый фильм
 * <p>
 * - получить все фильмы по переданному году
 * <p>
 * - получить все фильмы по переданному году и месяцу
 * <p>
 * - получить все фильмы по переданному жанру
 * <p>
 * - получать ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания
 * <p>
 * Учесть следующее:
 * <p>
 * - в кинотеатре фильмы должны храниться в порядке их добавления в него (т.е. предусмотреть порядок значения ассоциативного массива)
 * <p>
 * - не должен добавляться фильм, если такой уже есть в кинотеатре
 * <p>
 * Продемонстрировать работу кинотеатра в отдельном классе.
 */

public class Cinema {

    private LinkedHashMap<Integer, List<Film>> mapCinema;

    public Cinema(LinkedHashMap<Integer, List<Film>> mapCinema) {
        this.mapCinema = mapCinema;
    }

    public void addNewFilmInCinema(Film film) {
        if (mapCinema.containsKey(film.getYearPublication())) {
            List<Film> films = new ArrayList<>();
            List<Film> filmsOnYear = mapCinema.get(film.getYearPublication());
            for (Film thisFilm : filmsOnYear) {
                if (!thisFilm.equals(film)) {
                    films.add(thisFilm);
                }

            }
            films.add(film);

            mapCinema.put(film.getYearPublication(), films);
        } else
            mapCinema.put(film.getYearPublication(), Arrays.asList(film));
    }


    public LinkedHashMap<Integer, List<Film>> getMapCinema() {
        return mapCinema;
    }

    public void setMapCinema(LinkedHashMap<Integer, List<Film>> mapCinema) {
        this.mapCinema = mapCinema;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "mapCinema=" + mapCinema +
                '}';
    }
}
