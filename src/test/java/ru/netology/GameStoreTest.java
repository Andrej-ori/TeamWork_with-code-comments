package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    GameStore store = new GameStore();

    @Test
    public void shouldAddGame() { // тест на проверку добавления игры. ОШИБКА!! Мой комментарий есть в методе по исправлению

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddTwoGames() { // тест на проверку добавления двух игр. ОШИБКА!! Мой комментарий есть в методе по исправлению

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Игра2", "Аркады");

        assertTrue(store.containsGame(game2));
    }

    @Test
    public void shouldNotAddGame() { // тест на проверку, что если игра существует, но не была добавлена в store. Store не должна ее находить

        Game game = new Game("Нетология Баттл Онлайн", "Аркады", store);

        assertFalse(store.containsGame(game));
    }

    @Test
    public void shouldAddHoursIfOneHour() { // тест на проверку было ли добавлено время игры 1 час. ОШИБКА

        store.addPlayTime("Игрок1", 1);

        String expected = "Игрок1";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotAddHoursIfZero() { // тест на проверку было ли добавлено время игры 1 час. ОШИБКА

        store.addPlayTime("Игрок1", 0);

        String expected = null;
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldNotAddHoursIfMinus() { // тест на проверку было ли добавлено время игры -1 час. Тест пройден

        store.addPlayTime("Игрок1", -1);

        String expected = null;
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddHoursIfBigNumber() { // тест на проверку было ли добавлено время игры 100000 часов. Тест пройден

        store.addPlayTime("Игрок1", 100_000);
        store.addPlayTime("Игрок2", 100);

        String expected = "Игрок1";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddHours() { // тест на проверку было ли добавлено новое время игры. ТЕСТ ПРОЙДЕН

        store.addPlayTime("Игрок1", 2);

        String expected = "Игрок1";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddNewHours() { // тест на проверку было ли добавлено новое время ранее играной игры. ОШИБКА!! Мой комментарий есть в методе по исправлению

        store.addPlayTime("Игрок1", 5);
        store.addPlayTime("Игрок1", 6);
        store.addPlayTime("Игрок2", 8);

        String expected = "Игрок1";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotAddNewHoursIfZero() { // тест на проверку было ли добавлено новое время ранее играной игры если ноль. ОШИБКА!! Мой комментарий есть в методе по исправлению

        store.addPlayTime("Игрок1", 5);
        store.addPlayTime("Игрок1", 0);
        store.addPlayTime("Игрок2", 6);

        String expected = "Игрок2";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowMostPlayerIfDraw() { // тест на проверку лучшего играка если ничья. Тест прошел. Логика такая что результат нужно побить, тогда только станешь лучшим

        store.addPlayTime("Игрок1", 5);
        store.addPlayTime("Игрок2", 5);

        String expected = "Игрок1";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowSumPlayedTime() { // тест на проверку покажет ли метод getSumPlayedTime общее количество времени всех игроков. ОШИБКА!! Мой комментарий есть в методе по исправлению

        store.addPlayTime("Игрок1", 5);
        store.addPlayTime("Игрок2", 8);
        store.addPlayTime("Игрок3", 0);

        int expected = 13;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowSumPlayedTimeIfZero() { // тест на проверку покажет ли метод getSumPlayedTime общее количество времени всех игроков, игроков нет. Тест пройден

        int expected = 0;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);
    }
}