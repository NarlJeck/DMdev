package oop;

public class Floor {
    private  final int numberFloor;
    private  final Apartment[] arrayApartment;


    public Floor(int numberFloor, Apartment[] arrayApartment) {
        this.numberFloor = numberFloor;
        this.arrayApartment = arrayApartment;
    }

    public void print() {
        int count = 0;
        System.out.println("    Номер этажа: " + getNumberFloor());
        for (int i = 0; i < getArrayApartment().length; i++) {
            Apartment apartment = getArrayApartment()[i];
            apartment.print();
            count++;
        }
        System.out.println("Квартир на этаже: " + count);
        System.out.println("__________________________________");
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public Apartment[] getArrayApartment() {
        return arrayApartment;
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
