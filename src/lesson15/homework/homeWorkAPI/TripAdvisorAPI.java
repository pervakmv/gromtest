package lesson15.homework.homeWorkAPI;

import java.util.Arrays;

public class TripAdvisorAPI implements API {
    Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room falshRoom = new Room(price, 1, hotel, city);
        Room[] findRoomsArray = new Room[rooms.length];
        int i = 0;
        for (Room element : rooms) {
            if (element != null) {
                if((element.equalsWithoutPersons(falshRoom)) &&
                        element.intAbs((element.getPersons() - persons)) <= 1){
                    findRoomsArray[i] = element;
                    i++;
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

        TripAdvisorAPI that = (TripAdvisorAPI) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(rooms, that.rooms);
    }

    @Override
    public int hashCode() {
        return rooms.hashCode();
    }
}
