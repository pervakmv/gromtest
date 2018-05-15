package lesson11.HomeWork;

public class GoogleAPI implements API{
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room[] findRoomsArray = new Room[rooms.length];
        int i = 0;
        for (Room element : rooms) {
            if (element != null) {
                if ((element.getPersons() == persons) &&
                        element.getCityName() == city &&
                        element.getHotelName() == hotel &&
                        element.getPrice() == price) {
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
}
