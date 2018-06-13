package lesson25.HW;

import lesson25.HW.Entity;
import lesson25.HW.Gender;

public class Man extends Entity  {
    private String secondName;
    private Gender gender;
    private int age;
    private MaritailStatus maritailStatus;

    public Man(long id, String name, String secondName, Gender gender, int age, MaritailStatus maritailStatus) {
        super(id, name);
        this.secondName = secondName;
        this.gender = gender;
        this.age = age;
        this.maritailStatus = maritailStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Man man = (Man) o;

        if (age != man.age) return false;
        if (secondName != null ? !secondName.equals(man.secondName) : man.secondName != null) return false;
        if (gender != man.gender) return false;
        return maritailStatus == man.maritailStatus;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (maritailStatus != null ? maritailStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Man{" +
                "  id=" + id +
                ", name='" + name + '\'' +
                "secondName='" + secondName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", maritailStatus=" + maritailStatus +

                '}';
    }
}
