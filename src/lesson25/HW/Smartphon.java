package lesson25.HW;

public class Smartphon extends Entity {
    String model;
    String OS;
    float diagonal;
    int weight;

    public Smartphon(long id, String name, String model, String OS, float diagonal, int weight) {
        super(id, name);
        this.model = model;
        this.OS = OS;
        this.diagonal = diagonal;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Smartphon smartphon = (Smartphon) o;

        if (Double.compare(smartphon.diagonal, diagonal) != 0) return false;
        if (weight != smartphon.weight) return false;
        if (!model.equals(smartphon.model)) return false;
        return OS.equals(smartphon.OS);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + model.hashCode();
        result = 31 * result + OS.hashCode();
        temp = Double.doubleToLongBits(diagonal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + weight;
        return result;
    }

    @Override
    public String toString() {
        return "Smartphon{" +
                "  id=" + id +
                ", name='" + name + '\'' +
                "model='" + model + '\'' +
                ", OS='" + OS + '\'' +
                ", diagonal=" + diagonal +
                ", weight=" + weight +

                '}';
    }
}
