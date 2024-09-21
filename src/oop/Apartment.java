package oop;

import java.util.Arrays;

public class Apartment {
    private final int numberApartment;
    private final Room[] arrayRoom;

    public Apartment(int numberApartment, Room[] arrayRoom) {
        this.numberApartment = numberApartment;
        this.arrayRoom = arrayRoom;
    }

    public int getNumberApartment() {
        return numberApartment;
    }

    public Room[] getArrayRoom() {
        return arrayRoom;
    }

    public void print() {
        int count = 0;
        System.out.println("          Номер квартиры: " + getNumberApartment());
        for (int i = 0; i < getArrayRoom().length; i++) {
            Room room = getArrayRoom()[i];
            room.print();
            count++;
        }
        System.out.println("Количество комнат: " + count);

    }

    @Override
    public String toString() {
        return "Apartment{" +
                "numberApartment=" + numberApartment +
                ", arrayRoom=" + Arrays.toString(arrayRoom) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apartment apartment = (Apartment) o;

        if (numberApartment != apartment.numberApartment) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(arrayRoom, apartment.arrayRoom);
    }

    @Override
    public int hashCode() {
        int result = numberApartment;
        result = 31 * result + Arrays.hashCode(arrayRoom);
        return result;
    }
}
