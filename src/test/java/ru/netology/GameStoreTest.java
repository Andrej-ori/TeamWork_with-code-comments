package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() { // тест на проверку добавления игры. ОШИБКА!! Мой комментарий есть в методе по исправлению

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddHours() { // тест на проверку было ли добавлено время игры. ТЕСТ ПРОЙДЕН

        GameStore store = new GameStore();
        store.addPlayTime("Игрок1", 5);

        String expected = "Игрок1";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddNewHours() { // тест на проверку было ли добавлено новое время игры. ОШИБКА!! Мой комментарий есть в методе по исправлению

        GameStore store = new GameStore();
        store.addPlayTime("Игрок1", 5);
        store.addPlayTime("Игрок1", 6);
        store.addPlayTime("Игрок2", 8);

        String expected = "Игрок1";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowPlayerWithOneHour() { // тест на проверку показывает ли метод getMostPlayer игорока с 1 часом игры. ОШИБКА. Мои комментарии по исправлению есть в методе

        GameStore store = new GameStore();
        store.addPlayTime("Игрок1", 1);

        String expected = "Игрок1";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowSumPlayedTime() { // тест на проверку покажет ли метод getSumPlayedTime общее количество времени всех игроков. ОШИБКА!! Мой комментарий есть в методе по исправлению

        GameStore store = new GameStore();
        store.addPlayTime("Игрок1", 5);
        store.addPlayTime("Игрок2", 8);

        int expected = 13;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);
    }

}