package ru.netology;

import java.util.Objects;

public class Game { // клясс Game(игра) здесь логика для описания сущности игра
    private final String title; // название игры
    private final String genre; // жанр игры
    private final GameStore store; // каталог игры (история)

    public Game(String title, String genre, GameStore store) { // конструкт Игра (принимает значения: Название, жанр, и каталог)
        this.title = title;
        this.genre = genre;
        this.store = store;
    }

    public String getTitle() { // прием названия игры
        return title;
    }

    public String getGenre() { // прием жанра игры
        return genre;
    }

    public GameStore getStore() { // прием каталога игры
        return store;
    }

    @Override
    public boolean equals(Object o) {  //
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(title, game.title) &&
                Objects.equals(genre, game.genre) &&
                Objects.equals(store, game.store);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, store);
    }
}