package oop;

public class House {
    private final int numberHouse;
    private final Floor[] arrayFloor;

    public House(int numberHouse, Floor[] arrayFloor) {
        this.numberHouse = numberHouse;
        this.arrayFloor = arrayFloor;
    }

    public void print() {
        int count = 0;
        System.out.println("Номер дома: " + getNumberHouse());
        for (int i = 0; i < getArrayFloor().length; i++) {
            Floor floor = getArrayFloor()[i];
            floor.print();
            count++;
        }
        System.out.println();
        System.out.print("Количество этажей в доме: " + count);


    }

    public int getNumberHouse() {
        return numberHouse;
    }

    public Floor[] getArrayFloor() {
        return arrayFloor;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
