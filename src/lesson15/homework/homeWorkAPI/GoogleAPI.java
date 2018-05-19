package lesson15.homework.homeWorkAPI;

import java.util.Arrays;

public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room falshRoom = new Room(price, persons, hotel, city);
        Room[] findRoomsArray = new Room[rooms.length];
        int i = 0;
        for (Room element : rooms) {
            if (element != null) {
                if(element.equals(falshRoom)){
                    findRoomsArray[i] = element;
                }
            }
        }
        return rooms != null ? rooms[0].deleteNullElements(findRoomsArray) : null;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoogleAPI googleAPI = (GoogleAPI) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(rooms, googleAPI.rooms);
    }

    @Override
    public int hashCode() {
        return rooms.hashCode();
    }
}
