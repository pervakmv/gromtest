package lesson11.HomeWork;

public interface API {
    Room[] findRooms(int price, int persons, String city, String hotel);
    Room[] getAll();

}
