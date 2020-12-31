package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {

    private FilmManager manager = new FilmManager();
    private Film first = new Film(1, "Toy Story", "ts", "Animation", false);
    private Film second = new Film(2, "Ice Age", "ia", "Animation", false);
    private Film third = new Film(3, "Inception", "i", "Science fiction", false);

    void setUp() {
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
    }

    @Test
    void shouldGetEmpty() {
        Film[] expected = new Film[0];
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetOne() {
        manager.addFilm(first);
        Film[] expected = new Film[]{first};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAll() {
        setUp();
        Film[] expected = new Film[]{third, second, first};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetSeveral() {
        setUp();
        manager.filmsQuantity(2);
        Film[] expected = new Film[]{third, second};
        Film[] actual = manager.getSeveral();
        assertArrayEquals(expected, actual);
    }
}