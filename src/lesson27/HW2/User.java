package lesson27.HW2;

public class User {
    private long id;
    private String name;
    private String sessionId;

    public User(long id, String name, String sessionId) {
        this.id = id;
        this.name = name;
        this.sessionId = sessionId;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public String getName() {

        return name;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void printDataOfUser() {
        System.out.print("id: ");
        System.out.println(id);

        System.out.print("Name: ");
        System.out.println(name);

        System.out.print("SessionId:");
        System.out.println(sessionId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
