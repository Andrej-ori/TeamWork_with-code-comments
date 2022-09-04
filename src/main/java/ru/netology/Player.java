package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class Player { // ласс Player(игрок) здесь описана логика сущности игрок
    private String name; // обьявление приватной(не изменяемой нигде кроме класса Player) переменной тип STRING name(имя)

    /** информация о том, в какую игру сколько часов было сыграно
     ключ - игра
     значение - суммарное количество часов игры в эту игру */
    private Map<Game, Integer> playedTime = new HashMap<>(); // обьявление приватной(не изменяемой нигде кроме класса Player) MAPы playedTime(время игры) c ключом Game(игра), и значением тип INTEGER(целе число) !!(

    public Player(String name) { // конструкт для Player(игрок) принимает переменную name(имя)
        this.name = name;
    }

    public String getName() { // геттер для name
        return name;
    }

    /** добавление игры игроку
     если игра уже была, никаких изменений происходить не должно */
    public void installGame(Game game) { // возвращает installGame(установка игры) со значение game(игра)
        playedTime.put(game, 0);         // в МАРу playedTime(время игры) добавляется ключ game(игра) со значением 0 !! (нет проверки на то что такой ключ game(игра) уже есть. может привести к тому что если такая игра уже добавлена время проведенное в ней сбросится!!
    }

    /** игрок играет в игру game на протяжении hours часов
     об этом нужно сообщить объекту-каталогу игр, откуда была установлена игра
     также надо обновить значения в мапе игрока, добавив проигранное количество часов
     возвращает суммарное количество часов, проигранное в эту игру.
     если игра не была установлена, то надо выкидывать RuntimeException */
    public int play(Game game, int hours) {       // обьявление переменной тип INT play(играть)???ПОЧЕМУ ПЕРЕМЕННАЯ???  которая принимает значения game(игра) и hours(часы)
        game.getStore().addPlayTime(name, hours); // метод game(игра) со значением Store(каталог) добавляем в MAPу playTime(время игры) с ключом имя и значением часы
        if (playedTime.containsKey(game)) {       // если в MAPе playedTime есть ключ game(игра)
            playedTime.put(game, playedTime.get(game)); // то в MAPу playedTime в ключ game добавляем время ?? не понятна логика playedTime.get(game)
        } else {
            playedTime.put(game, hours);  // иначе в MAPу playedTime добавляем ключ game со значением hours
        }
        return playedTime.get(game);      // возвращаем MAPу playedTime.get(game) !!! не понял зачем .get(game)
    }                                      // !!! где логика на отлов исключения и гда сам файл с логикой исключения RuntimeException ?????

    /** Метод принимает жанр игры (одно из полей объекта игры) и
     суммирует время, проигранное во все игры этого жанра этим игроком */
    public int sumGenre(String genre) {  // обьявление переменной тип INT sumGenre(сумма жанров) !!! ПОЧЕМУ ПЕРЕМЕННАЯ!!! которая принимет переменную типа STRING genre(жфнр)
        int sum = 0;                     // обьявление переменной sum = 0
        for (Game game : playedTime.keySet()) {     // цикл для  game до размера MAPы playedTime(время игры) по ключу
            if (game.getGenre().equals(genre)) {    // если game со значением genre(жанр) есть в game !!!(здесь берется game и в нем ищется ganre(который принимается выше) и если он есть то условие выполняется)!!!
                sum += playedTime.get(game);        // к переменной sum прибавляется значение которое хранится в MAPе playedTime в ячейке с ключом game
            } else {
                sum = 0;                            // иначе sum = 0 ?? е понятна логика возможна ошибка
            }
        }
        return sum;                                 // возвращается переменная sum
    }

    /** Метод принимает жанр и возвращает игру этого жанра, в которую играли больше всего
     Если в игры этого жанра не играли, возвращается null */
    public Game mostPlayerByGenre(String genre) { // не написана логика !!!! этот метод всегда возвращает null
        return null;
    }
}