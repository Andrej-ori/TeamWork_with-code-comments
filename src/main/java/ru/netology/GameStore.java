package ru.netology;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameStore {        // класс GameStore (каталог игр) здесь логика для подсчета времени проведенного инроком в игре
    private List<Game> games = new ArrayList<>(); // обьявляем приватный(не изменяемой нигде кроме класса GameStore) список games(игры)

    /**
     * Информация о том, какой игрок сколько играл в игры этого каталога
     * Ключ - имя игрока
     * Значение - суммарное количество часов в игры этого каталога
     */
    private Map<String, Integer> playedTime = new HashMap<>();  // обьявляем приватный(не изменяемой нигде кроме класса GameStore) MAP playerTime(время игры) (имя игрока, время игры) !!(может быть ошибка логики - ключем выступает имя, а имена могут повторятся)

    /**
     * Создание объекта игры с заданными заголовком и жанром
     * Каждый объект игры помнит объект каталога, которому она принадлежит
     */
    public Game publishGame(String title, String genre) { //обьявление метода publishGame(регистрация игры) принимает значения: название игры, жанр игры
        Game game = new Game(title, genre, this); // метод регистрации принимает название и жанр
        games.add(game);                                // добавление игры в список games(игры)
        return game;                                    // возвращает
    }

    /**
     * Проверяет наличие игры в каталоге и возврашает true
     * если игра есть и false иначе
     */
    public boolean containsGame(Game game) { // метод проверки есть игра в каталоге или нет
        for (int i = 1; i < games.size(); i++) { // цикл от 1 до размера списка games(игры) с шагом 1
            if (games.get(i - 1).equals(game)) { // если в ячейка списка games(игры) i-1 есть данная игра то возвращает true(верно)
                return true;
            }
        }
        return false;                              // иначе озвращает ложь (строку нада пернести выше на две строки с операторос else (так как код всегда будет возвращать ложь(код пройдет цикл и уже после выполнения цикла будет команда верни ложь)
    }

    /**
     * Регистрирует количество времени, которое проиграл игрок
     * за игрой этого каталога. Игрок задаётся по имени. Время должно
     * суммироваться с прошлым значением для этого игрока
     */
    public void addPlayTime(String playerName, int hours) { // обьявление метода addPlayTime(добавить время игры) принимаются значения (playerName(имя игрока), hours(часы) !!(здесь умеются в виду время проведенное в игре)
        if (playedTime.containsKey(playerName)) { // условие если для MAPы playedTime(время игры): есть ключ pkayerName(имя игрока)
            playedTime.put(playerName, playedTime.get(playerName)); // то выполняется: добавление в МАРу playedTime(время игры) ключ playerName(имя игрока), MAPа plaedTime(время игры) для данного игрока !! типо к существующему времени прибавляется hours время проведенное в игре
        } else {
            playedTime.put(playerName, hours); // иначе : в МАРу playedTime(время игры) добавляется ключ playerName(имя игрока) и количество hours(часов) проведенных им в игре
        }
    }

    /**
     * Ищет имя игрока, который играл в игры этого каталога больше всего
     * времени. Если игроков нет, то возвращется null
     */
    public String getMostPlayer() { //
        int mostTime = 1; // обьявление переменной тип INT mostTime(лучшее время) и присваевает значение 1 !! ПОЧЕМУ???
        String bestPlayer = null; // Обьявляет переменную тип STRING bestPlayer(лучший игрок) и присваивает значение null (пустое)
        for (String playerName : playedTime.keySet()) { // цикл для переменной playerName до размера MAPы playedTime(время игры) по ключу
            int playerTime = playedTime.get(playerName); // обьявление переменной тип INT playerTime(время игрока) и берем количество часов из ячейки MAPы playedTime(время игры) с ключом playerName(имя игрока)
            if (playerTime > mostTime) {                 // если playerTime(время игрока) > mostTime(лучшее временя)
                mostTime = playerTime;                  // то mostTime(лучшее время) = playerTime(время игрока)
                bestPlayer = playerName;                // bestPlayer(лучший игрок) = playerName(имя игрока)
            }
        }
        return bestPlayer;                              // возвращает переменую bestPlayer
    }

    /**
     * Суммирует общее количество времени всех игроков, проведённого
     * за играми этого каталога
     */
    public int getSumPlayedTime() {  // этот метод всегда возвращает 0 !! надо написать всю логику
        return 0;
    }
}