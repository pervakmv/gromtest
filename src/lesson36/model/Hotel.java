package lesson36.model;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hotel extends Entity implements Comparable<Hotel> {

    private String name;
    private String country;
    private String city;
    private String street;

    public Hotel(long id, String name, String country, String city, String street) {
        super(id);
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Hotel() {
    }

    @Override
    public int compareTo(Hotel o) {
        if (!this.getName().equals(o.getName())) {
            return this.getName().compareTo(o.getName());
        }

        if (!this.getCountry().equals(o.getCountry())) {
            return this.getCountry().compareTo(o.getCountry());
        }
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
                "id=" + super.getId() + '\'' +
                ", name=" + name + '\'' +
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

        if (!name.equals(hotel.name)) return false;
        if (!country.equals(hotel.country)) return false;
        if (!city.equals(hotel.city)) return false;
        return street.equals(hotel.street);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        return result;
    }

    public void setId(long id) {
        super.setId(id);
    }

    public void setName(String name) {
        this.name = name;
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
        return super.getId();
    }

    public String getName() {
        return name;
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
                name != null &&
                city != null &&
                street != null) {
            return true;
        }
        return false;
    }

    public String toFileFormat() {
        return super.getId() + "," + '\t'  + name  + "," + '\t' + country + "," + '\t' + city + "," + '\t' + street;
    }


    public Hotel enterDataByKeyboard() throws Exception{


        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Name: ");
            this.name = br.readLine();

            System.out.print("Country: ");
            this.country = br.readLine();


            System.out.print("City: ");
            this.city = br.readLine();


            System.out.print("Street: ");
            this.street = br.readLine();


        }
        return this;
    }

}
