package lesson11.HomeWork;

import java.util.Date;

public class Room {
    private long id;
    private int price;
    private int persons;
    private Date dateAvailableFrom;
    private String hotelName;
    private String cityName;

    public Room(long id, int price, int persons, Date dateAvaiableFrom, String hotelName, String cityName) {
        this.id = id;
        this.price = price;
        this.persons = persons;
        this.dateAvailableFrom = dateAvaiableFrom;
        this.hotelName = hotelName;
        this.cityName = cityName;
    }

    public Room() {
    }

    public long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getPersons() {
        return persons;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }


    public Room[] deleteNullElements(Room[] rooms) {
        Room[] arrayWithoutNullElement = new Room[numberNotNullElements(rooms)];
        int index = 0;
        for (Room element : rooms) {
            if (element != null) {
                arrayWithoutNullElement[index] = element;
                index++;
            }
        }
        return arrayWithoutNullElement;
    }

    public int numberNullElements(Room[] rooms) {
        int index = 0;
        for (Room element : rooms) {
            if (element == null)
                index++;
        }

        return index;
    }

    public int numberNotNullElements(Room[] rooms) {
        int index = 0;
        for (Room element : rooms) {
            if (element != null)
                index++;
        }
        return index;
    }

    public int intAbs(int arg) {
        if (arg > 0)
            return arg;
        else
            return -1 * arg;
    }

    public void sysoutRoomsData() {
        System.out.println(id + " " + price + " " + persons + " " + dateAvailableFrom + " " + hotelName + " " + cityName);
    }
}
