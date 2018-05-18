package lesson15.homework.homeWorkAPI;

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

    public Room(int price, int persons, String hotelName, String cityName) {
        this.price = price;
        this.persons = persons;
        this.hotelName = hotelName;
        this.cityName = cityName;
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


    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", price=" + price +
                ", persons=" + persons +
                ", dateAvailableFrom=" + dateAvailableFrom +
                ", hotelName='" + hotelName + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }


    public boolean equalsWithoutPrice(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

       // if (id != room.id) return false;
        if (persons != room.persons) return false;
       // if (!dateAvailableFrom.equals(room.dateAvailableFrom)) return false;
        if (!hotelName.equals(room.hotelName)) return false;
        return cityName.equals(room.cityName);
    }


    public int hashCodePrice() {
      //  int result = (int) (id ^ (id >>> 32));
        int result = 1;
        result = 31 * result + persons;
       // result = 31 * result + dateAvailableFrom.hashCode();
        result = 31 * result + hotelName.hashCode();
        result = 31 * result + cityName.hashCode();
        return result;
    }


    public boolean equalsWithoutPersons(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

      //  if (id != room.id) return false;
        if (price != room.price) return false;
        //if (!dateAvailableFrom.equals(room.dateAvailableFrom)) return false;
        if (!hotelName.equals(room.hotelName)) return false;
        return cityName.equals(room.cityName);
    }


    public int hashCodeWithoutPersons() {
       // int result = (int) (id ^ (id >>> 32));
        int result = 1;
        result = 31 * result + price;
        //result = 31 * result + dateAvailableFrom.hashCode();
        result = 31 * result + hotelName.hashCode();
        result = 31 * result + cityName.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

      //  if (id != room.id) return false;
        if (price != room.price) return false;
        if (persons != room.persons) return false;
        //if (!dateAvailableFrom.equals(room.dateAvailableFrom)) return false;
        if (!hotelName.equals(room.hotelName)) return false;
        return cityName.equals(room.cityName);
    }

    @Override
    public int hashCode() {
       // int result = (int) (id ^ (id >>> 32));
        int result =1;
        result = 31 * result + price;
        result = 31 * result + persons;
       // result = 31 * result + dateAvailableFrom.hashCode();
        result = 31 * result + hotelName.hashCode();
        result = 31 * result + cityName.hashCode();
        return result;
    }
}
