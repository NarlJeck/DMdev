package collectionCinema.entity;

public enum Genre {
    HORROR("Ужасы"),
    COMEDY("Комедии"),
    FANTASY("Фентези"),
    DRAMA("Драма"),
    DETECTIVE("Детектив");

    private String name;

    Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
