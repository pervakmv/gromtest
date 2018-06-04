package lesson20.task1;

import lesson20.task1.exception.BadRequestException;
import lesson20.task1.exception.InternalServelException;
import lesson20.task1.exception.UserNotFoundException;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }


    public String[] getUserNames() {

        User[] userNames = getUsers();
        String[] names = new String[userNames.length];
        int i = 0;
        for (User element : userNames) {
            if (element != null) names[i] = element.getName();
            i++;
        }
        return names;
    }

    public long[] getUserIds() {
        User[] users = getUsers();
        long[] id = new long[users.length - numberOfNullElement()];
        int i = 0;
        for (User element : users) {
            if (element != null) {
                id[i] = element.getId();
                i++;
            }

        }
        return id;
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

    public User findById(long id) throws UserNotFoundException {
        for (User element : users) {
            if (element != null && element.getId() == id) {
                return element;
            }
        }
        throw new UserNotFoundException("User with id: " + id + " not found");

    }

    public User getUserBySessionId(String sessionId) {
        for (User element : users) {
            if (element != null && element.getSessionId() == sessionId) {
                return element;
            }
        }
        return null;
    }

    public User save(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't save null user");

        try {

            findById(user.getId());
            throw new BadRequestException("User with id: " + user.getId() + " already exist");
        } catch (UserNotFoundException e) {
            System.out.println("User with id: " + user.getId() + " not found. Will be saved");
        }

        int index = 0;
        for (User element : users) {
            if (element == null) {
                users[index] = user;
                return users[index];
            }
            index++;
        }
        throw new InternalServelException("Not enought space to save user with id: " + user.getId());
    }


    public User update(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't update null user");


        findById(user.getId());


        int index = 0;
        for (User element : users) {
            if (element != null && element.getId() == user.getId()) {
                users[index] = user;
                return users[index];

            }
            index++;
        }
        throw new InternalServelException("Unexpcted error");
    }

    public void delete(long id) throws Exception {
        findById(id);


        int index = 0;
        for (User element : users) {
            if (element != null && element.getId() == id) {
                users[index] = null;
                break;
            }
            index++;
        }

    }
}
