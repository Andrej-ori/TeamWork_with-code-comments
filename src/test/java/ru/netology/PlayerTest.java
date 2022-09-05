package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() { // Суммирует время, проигранныые во все игры жанра "Аркады" игроком "Petya", если добавлена ТОЛЬКО ОДНА ИГРА
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test // Суммирует время, проигранныые во все игры жанра "Аркады" игроком "Petya", если добавлено НЕСКОЛЬКО ИГР одного жанра
    public void shouldSumGenreIfSomeGame() {
        GameStore store = new GameStore();

        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Покорение Марса", "Аркады");
        Game game3 = store.publishGame("Арканоид", "Аркады");

        Player player = new Player("Petya");

        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);

        player.play(game1, 3);
        player.play(game2, 5);
        player.play(game3, 12);

        int expected = 3 + 5 + 12;
        int actual = player.sumGenre("Аркады");

        assertEquals(expected, actual);
    }

    @Test
    public void sumGenreTwoGames() { //  Суммирует время, проигранныые во все игры жанра "Аркады" игроком "Petya", если добавлено НЕСКОЛЬКО ИГР разных жанров
        GameStore store = new GameStore();

        Game game1 = store.publishGame("Арканоид", "Аркады");   // обьявляем игры и их жанр
        Game game2 = store.publishGame("Ведьмак", "РПГ");
        Game game3 = store.publishGame("Нетология Батл Онлайн", "Аркады");

        Player player = new Player("Petya"); // обьявляем игрока(имя)

        player.installGame(game1);      // запускаем игры
        player.installGame(game2);
        player.installGame(game3);

        player.play(game1, 5);    // обьявляем сколько времени проводим в данной игре
        player.play(game2, 3);
        player.play(game3,3);

        int expected = 5 + 3;
        int actual = player.sumGenre("Аркады");

        assertEquals(expected,actual);
    }

    @Test // Считает количество часов, которое играли в игру, если она УСТАНОВЛЕНА
    public void shouldCountHoursWhenGameInstalled() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);

        int actual = player.play(game, 3);

        assertEquals(3, actual);
    }

    @Test
    // Выкидывает исключение при попытке сосчитать количество часов, которое играли в игру, если она НЕ УСТАНОВЛЕНА
    public void shouldThrowExceptionWhenGameNotInstalled() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        assertThrows(RuntimeException.class, () -> player.play(game, 3));
    }

    @Test // Выдает игру заданного жанра "Аркады", в которую играли бОльшее количество часов если играли только в игры одного жанра
    public void shouldReturnMostPlayedByGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Покорение Марса", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, 3);

        player.installGame(game2);
        player.play(game2, 5);

        assertEquals("Покорение Марса", player.mostPlayerByGenre("Аркады"));
    }

    @Test // Выдает игру заданного жанра "Аркады", в которую играли бОльшее количество часов, если добавлены несколько игр разного жанра
    public void shouldReturnMostPlayedByGenreWhenSomeGamesDifferentGenres() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Покорение Марса", "Аркады");
        Game game3 = store.publishGame("Формула 1", "Гонки");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, 3);

        player.installGame(game2);
        player.play(game2, 5);

        player.installGame(game3);
        player.play(game3, 15);

        assertEquals("Покорение Марса", player.mostPlayerByGenre("Аркады"));
    }

    @Test // Выдает игру заданного жанра "Аркады", в которую играли бОльшее количество часов
    public void shouldReturnMostPlayedByGenreIfNoonePlayedThisGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Формула 1", "Гонки");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, 3);

        player.installGame(game2);
        player.play(game2, 5);

        assertNull(player.mostPlayerByGenre("Квесты"));
    }
}