package lesson27.HW2;

import java.util.LinkedList;

public class UserRepository {
    private LinkedList<User> users = new LinkedList<>();

    public UserRepository(LinkedList<User> users) {
        this.users = users;
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    public String[] getUserNames() {

        Object[] objects = users.toArray();
        String[] names = new String[objects.length];
        int index = 0;
        for (User element : users) {
            names[index] = element.getName();
            index++;
        }
        return names;

    }

    public long[] getUserIds() {
        Object[] objects = users.toArray();
        long[] res = new long[objects.length];
        int index = 0;
        for (User element : users) {
            res[index] = element.getId();
            index++;
        }
        return res;
    }

    public int numberOfNullElement() {
        int res = 0;
        for (User element : users) {
            if (element == null) res++;
        }
        return res;
    }


    public String getUserNameById(long id) {
        for (User element : users) {
            if (element != null) {
                if (element.getId() == id) {
                    return element.getName();
                }
            }
        }
        return null;
    }


    public User getUserByName(String name) {
        for (User element : users) {
            if (element != null && element.getName() == name) {
                return element;
            }
        }
        return null;
    }

    public User getUserById(long id) {
        for (User element : users) {
            if (element != null && element.getId() == id) {
                return element;
            }
        }
        return null;
    }

    private User findById(long id) {
        for (User element : users) {
            if (element != null && element.getId() == id) {
                return element;
            }
        }
        return null;
    }

    public User getUserBySessionId(String sessionId) {
        for (User element : users) {
            if (element != null && element.getSessionId() == sessionId) {
                return element;
            }
        }
        return null;
    }

    public User save(User user) {

        if (users.add(user))
            return user;
        return null;
    }

    public User update(User user) {

        if (users.contains(user)) {
            int index = 0;
            for (User element : users) {
                if (element.equals(user)) {
                    users.set(index, user);
                    return user;
                }
                index++;
            }

        }
        return null;
    }

    public void delete(long id) {
        if (findById(id) != null) {
            int index = 0;
            for (User element : users) {
                if (element != null && element.getId() == id) {
                    users.remove(element);
                }
                index++;
            }
        }
    }
}
