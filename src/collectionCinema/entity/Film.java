package collectionCinema.entity;

/**
 * - Фильм с 5-ю полями: Уникальный Целочисленный идентификатор (id), Год издания, Месяц издания, Жанр и Рейтинг;
 */
public class Film implements Comparable<Film>{

    private Integer id;
    private Integer yearPublication;
    private Integer monthPublication;
    private Genre genre;
    private Double rating;

    public Film(Integer id, Integer yearPublication, Integer mothPublication, Genre genre, Double rating) {
        this.id = id;
        this.yearPublication = yearPublication;
        this.monthPublication = mothPublication;
        this.genre = genre;
        this.rating = rating;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(Integer yearPublication) {
        this.yearPublication = yearPublication;
    }

    public Integer getMonthPublication() {
        return monthPublication;
    }

    public void setMonthPublication(Integer monthPublication) {
        this.monthPublication = monthPublication;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", yearPublication=" + yearPublication +
                ", mothPublication=" + monthPublication +
                ", genre='" + genre.getName() + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int compareTo(Film o) {
        return o.getRating().compareTo(rating);
    }
}
