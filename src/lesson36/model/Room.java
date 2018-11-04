package lesson36.model;


import lesson36.Utils.Utils;
import lesson36.repository.HotelRepository;


import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.Date;

public class Room extends Entity{

    private int numberOfGuests;
    double price;
    boolean breakfastIncluded;
    boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    public Room(long id, int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        super(id);
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
        return super.getId() + "," + '\t' + numberOfGuests + "," + '\t' + price + "," + '\t' + breakfastIncluded + "," + '\t' +
                petsAllowed + "," + '\t' + dateAvailableFrom.getDate() + "-" + (dateAvailableFrom.getMonth() + 1) + "-" + (dateAvailableFrom.getYear() + 1900) + "," + '\t' +
                hotel.getId();
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

    public boolean equalsByFilter(Filter filter) {
        if (numberOfGuests != filter.getNumberOfGuests()) return false;
        if (Double.compare(price, filter.getPrice()) == 1) return false;
        if (breakfastIncluded != filter.isBreakfastIncluded()) return false;
        if (petsAllowed != filter.isPetsAllowed()) return false;


        if (dateAvailableFrom.getYear() != filter.getDateAvailableFrom().getYear()) return false;
        if (dateAvailableFrom.getMonth() != filter.getDateAvailableFrom().getMonth()) return false;
        if (dateAvailableFrom.getDate() != filter.getDateAvailableFrom().getDate()) return false;

        if (!hotel.getCountry().equals(filter.getCountry())) return false;
        if (!hotel.getCity().equals(filter.getCity())) return false;

        return true;
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
        return super.getId();
    }

    public int getNumberOfGuests() {
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
        super.setId(id);
    }

    public boolean canBeAdd() {
        if (hotel != null)
            return true;
        return false;

    }

    public Room enterDataByKeyboard() throws Exception{


        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Number of guests : ");
            this.numberOfGuests = Integer.parseInt(br.readLine());
            System.out.println("Price :");
            this.price = Double.parseDouble(br.readLine());
            System.out.println("Breakfast inclueded 1-Yes/2-No");
            if (Integer.valueOf(br.readLine()) == 1)
                this.breakfastIncluded = true;
            else
                this.breakfastIncluded = false;

            System.out.println("Pets allowed 1-Yes/2-No");
            if (Integer.parseInt(br.readLine()) == 1)
                this.petsAllowed = true;
            else
                this.petsAllowed = false;

            System.out.println("Date available from ");

            int date = 0;
            int month = 0;
            int year = 0;
            do {
                System.out.println("Day");
                date = Integer.parseInt(br.readLine());

            } while (!(date > 0 && date < 32));


            do {
                System.out.println("Month");
                month = Integer.parseInt(br.readLine());
            } while (!(month >= 1 && month < 12));


            do {
                System.out.println("Year");
                year = Integer.parseInt(br.readLine());
            } while (!(year > 2017 && year < 2030));

            dateAvailableFrom = new Date(year - 1900, month - 1, date);


            HotelRepository hotelRepository = new HotelRepository("c:/Temp/Hotel.txt", 1000, 5, null);
            System.out.println("HotelId ");
            long hotelId = Long.valueOf(br.readLine());
            this.hotel = hotelRepository.findHotelById(hotelId);
        }

        return this;
    }
}
