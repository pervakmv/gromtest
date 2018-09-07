package lesson36.model;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hotel implements Comparable<Hotel> {
    private long id;
    private String country;
    private String city;
    private String street;

    public Hotel(long id, String country, String city, String street) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Hotel() {
    }

    @Override
    public int compareTo(Hotel o) {
        if (!this.getCountry().equals(o.getCountry())) {
            return this.getCountry().compareTo(o.getCountry());
        }
        if (!this.getCity().equals(o.getCity())) {
            return this.getCity().compareTo(o.getCity());
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (!country.equals(hotel.country)) return false;
        if (!city.equals(hotel.city)) return false;
        return street.equals(hotel.street);
    }

    @Override
    public int hashCode() {
        int result = country.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        return result;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public boolean canBeAdd() {
        if (country != null &&
                city != null &&
                street != null) {
            return true;
        }
        return false;
    }

    public String toFileFormat() {
        return id + "," + '\t' + country + "," + '\t' + city + "," + '\t' + street;
    }


    public Hotel enterDataByKeyboard() {


        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        try {
            System.out.print("Country: ");
            this.country = br.readLine();


            System.out.print("City: ");
            this.city = br.readLine();


            System.out.print("Street: ");
            this.street = br.readLine();


        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }
        return this;
    }

}
