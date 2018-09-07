package lesson36.model;

import lesson36.repository.HotelRepository;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Room {
    private long id;
    private int numberOfGuests;
    double price;
    boolean breakfastIncluded;
    boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    public Room(long id, int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        this.id = id;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }


    public Room() {
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", numberOfGuests=" + numberOfGuests +
                ", price=" + price +
                ", breakfastIncluded=" + breakfastIncluded +
                ", petsAllowed=" + petsAllowed +
                ", dateAvailableFrom=" + dateAvailableFrom +
                ", hotel=" + hotel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (numberOfGuests != room.numberOfGuests) return false;
        if (Double.compare(room.price, price) != 0) return false;
        if (breakfastIncluded != room.breakfastIncluded) return false;
        if (petsAllowed != room.petsAllowed) return false;
        return hotel.equals(room.hotel);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = numberOfGuests;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (breakfastIncluded ? 1 : 0);
        result = 31 * result + (petsAllowed ? 1 : 0);
        result = 31 * result + hotel.hashCode();
        return result;
    }

    public long getId() {
        return id;
    }

    public int getNumberOfCuests() {
        return numberOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean canBeAdd() {
        if (hotel != null)
            return true;
        return false;

    }

    public String toFileFormat() {
        return id + "," + '\t' + numberOfGuests + '\t' + "," + price + '\t' + "," + breakfastIncluded + '\t' + ","
                + petsAllowed + '\t' + dateAvailableFrom.getDay() + "/" + dateAvailableFrom.getMonth() + "/" + dateAvailableFrom.getYear() + "," + '\t' +
                hotel.getId();
    }


    public Room enterDateByKeyboard() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        try {
            System.out.println("Number of guests : ");
            this.numberOfGuests = Integer.valueOf(br.readLine());
            System.out.println("Price :");
            this.price = Double.valueOf(br.readLine());
            System.out.println("Breakfast inclueded 1-Yes/2-No");
            if (Integer.valueOf(br.readLine()) == 1)
                this.breakfastIncluded = true;
            else
                this.breakfastIncluded = false;

            System.out.println("Pets allowed 1-Yes/2-No");
            if (Integer.valueOf(br.readLine()) == 1)
                this.petsAllowed = true;
            else
                this.petsAllowed = false;

            System.out.println("Date available from ");

            int value = 0;
            do {
                System.out.println("Day");
                value = Integer.valueOf(br.readLine());
            } while (value > 0 && value < 32);
            this.dateAvailableFrom.setDate(value);
            do {
                System.out.println("Month");
                value = Integer.valueOf(br.readLine());
            } while (value > 0 && value < 13);
            this.dateAvailableFrom.setMonth(value);

            do {
                System.out.println("Year");
                value = Integer.valueOf(br.readLine());
            } while (value > 2018 && value < 2030);
            this.dateAvailableFrom.setYear(value);

            HotelRepository hotelRepository = new HotelRepository();
            System.out.println("HotelId ");
            long hotelId = Long.valueOf(br.readLine());
            this.hotel = hotelRepository.findHotelById(hotelId, hotelRepository.mapping());
        } catch (Exception e) {
            System.err.println("Reading from keyboard faile");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }
        return this;
    }
}
