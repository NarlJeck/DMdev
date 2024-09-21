package oop;

public class Room {

    private  boolean walkThroughRoom;

    public Room(boolean walkThroughRoom) {
        this.walkThroughRoom = walkThroughRoom;
    }

    public void print() {
        if (isWalkThroughRoom()) {
            System.out.println("            Комната проходная");
        } else
            System.out.println("            Комната не проходная");

    }

    public boolean isWalkThroughRoom() {
        return walkThroughRoom;
    }

    public void setWalkThroughRoom(boolean walkThroughRoom) {
        this.walkThroughRoom = walkThroughRoom;
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
