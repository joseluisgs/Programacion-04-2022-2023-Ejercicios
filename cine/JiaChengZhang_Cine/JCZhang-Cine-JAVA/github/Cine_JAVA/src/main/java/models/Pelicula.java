package models;

public class Pelicula {
    String title = "Avatar: The Way Of Water";
    String year = "2022";
    String director = "James Cameron";
    String genre = "Science Fiction";

    @Override
    public String toString() {
        return "Pelicula{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
