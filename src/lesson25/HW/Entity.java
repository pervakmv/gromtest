package lesson25.HW;

public abstract class Entity {
    long id;
    String name;


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    public Entity(long id, String name) {
        this.id = id;
        this.name = name;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        if (id != entity.id) return false;

        return name != null ? name.equals(entity.name) : entity.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);

        return result;
    }
}
