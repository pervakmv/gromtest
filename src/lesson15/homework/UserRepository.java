package lesson15.homework;

public class UserRepository {
    private User[] users = new User[10];


    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }


    public User save(User user) {
        if (thereIsSuchaUser(user))//Якщо є вже такий едемент покидаємо виводимо null
            return null;
        int index = indexEmptyCell();
        if (index < 0)
            return null;
        users[index] = user;
        return users[index];
    }

    public User update(User user) {
        int index = indexFindByUsersId(user);

        if (index < 0)
            return null;
        else
            users[index] = user;
        return users[index];
    }

    public void delete(long id) {
        User findUserById = userFindById(id);

        int index = -1;
        for (User element : users) {
            index++;
            if (element != null) {
                if (element.equalsById(findUserById)) {
                    users[index] = null;
                    break;
                }
            }
        }
    }

    public User userFindById(long id) {
        User falshUser = new User(id, "FalshUser", "FalshSession");
        for (User element : users) {
            if (element != null) {
                if (element.equalsById(falshUser)) {
                    return element;
                }
            }
        }
        return null;
    }

    private int indexFindByUsersId(User user) {
        int res = -1;
        int index = 0;

        for (User element : users) {
            if (element != null) {
                if (element.equalsById(user)) {
                    res = index;
                    return res;
                }
            }
            index++;
        }
        return res;
    }

    private int indexEmptyCell() {
        int res = -1;
        int index = 0;
        for (User element : users) {
            if (element == null) {
                res = index;
                return res;
            }
            index++;
        }
        return res;
    }

    private int indexOfEqualUser(User user) {
        int res = -1;
        int index = 0;

        for (User element : users) {
            if (element != null) {
                if (element.equals(user) &&
                        (element.hashCode() == user.hashCode())) {
                    return index;
                }
            }
            index++;
        }
        return res;
    }

    private boolean thereIsSuchaUser(User user) {

        for (User element : users) {
            if (element != null) {
                if (element.equals(user) &&
                        (element.hashCode() ==
                                user.hashCode()))
                    return true;
            }

        }
        return false;
    }
}
