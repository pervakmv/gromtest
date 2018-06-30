package lesson31.CW;

public class Building {
    private String address;
    private int floors;

    public Building(String address, int floors) {
        this.address = address;
        this.floors = floors;
    }

    public String getAddress() {
        return address;
    }

    public int getFloors() {
        return floors;
    }
}
