package lesson25.HW;

public class Car extends Entity {
    private String color;
    private String type;
    private int price;

    public Car(long id, String name, String color, String type, int price) {
        super(id, name);
        this.color = color;
        this.type = type;
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Car car = (Car) o;

        if (price != car.price) return false;
        if (color != null ? !color.equals(car.color) : car.color != null) return false;
        return type != null ? type.equals(car.type) : car.type == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                " id=" + id +
                ", name='" + name + '\'' +
                "color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +


                '}';
    }
}
