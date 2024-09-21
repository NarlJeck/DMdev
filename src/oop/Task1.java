package oop;

/**
 * Задание 1
 * <p>
 * Представить в виде классов и их композиции следующую модель.
 * <p>
 * - Каждый дом содержит свой номер (int), и множество этажей (массив).
 * <p>
 * - Каждый этаж содержит номер этажа (int), и множество квартир (массив).
 * <p>
 * - Каждая квартира содержит свой номер (int), и множество комнат (массив).
 * <p>
 * - Каждая комната содержит поле проходная она или нет (boolean).
 * <p>
 * В каждом классе реализовать метод print, который на консоль выводит информацию об объекте (должны присутствовать все поля объекта!).
 * <p>
 * Например, метод print класса этаж должен выводить на консоль:
 * <p>
 * “Этаж 2, количество квартир 18”
 * <p>
 * Создание всех объектов вынести в отдельный класс с методом main.
 * <p>
 * Там же реализовать метод printAllInformation, который на вход принимает объект типа дом, и выводит информацию о нем, его этажах, квартирах и комнатах, вызывая методы print.
 * <p>
 * <p>
 * добавить комментарий к уроку
 */
public class Task1 {
    public static void main(String[] args) {
        Room room = new Room(true);
        Room room1 = new Room(false);
        Room room2 = new Room(false);
        Room room3 = new Room(false);


        Room[] arrayRoom1 = {room, room1, room2, room3};
        Room[] arrayRoom2 = {room, room1, room2};

        Apartment apartment1 = new Apartment(1, arrayRoom1);
        Apartment apartment2 = new Apartment(2, arrayRoom2);
        Apartment apartment3 = new Apartment(3, arrayRoom2);
        Apartment apartment4 = new Apartment(4, arrayRoom2);

        Apartment[] arrayApartments1 = {apartment1, apartment2};
        Apartment[] arrayApartments2 = {apartment3, apartment4};

        Floor floor1 = new Floor(1, arrayApartments1);
        Floor floor2 = new Floor(2, arrayApartments2);

        Floor[] arrayFloors = {floor1, floor2};

        House house = new House(32, arrayFloors);
        printAllInformation(house);
    }

    public static void printAllInformation(House house) {
        house.print();
    }


}
