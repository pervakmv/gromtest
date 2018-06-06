package lesson22.repository;

public class UserRepository {
    private static User[] users = new User[10];

    public UserRepository() {
    }

    public UserRepository(User[] users) {
        this.users = users;
    }

    public static User[] getUsers() {
        return users;
    }


    public static String[] getUserNames() {

        User[] userNames = getUsers();
        String[] names = new String[userNames.length];
        int i = 0;
        for (User element : userNames) {
            if (element != null) names[i] = element.getName();
            i++;
        }
        return names;
    }

    public static long[] getUserIds() {
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

    public static int numberOfNullElement() {
        int res = 0;
        for (User element : users) {
            if (element == null) res++;
        }
        return res;
    }


    public static String getUserNameById(long id) {
        for (User element : users) {
            if (element != null) {
                if (element.getId() == id) {
                    return element.getName();
                }
            }
        }
        return null;
    }


    public static User getUserByName(String name) {
        for (User element : users) {
            if (element != null && element.getName() == name) {
                return element;
            }
        }
        return null;
    }

    public static User getUserById(long id) {
        for (User element : users) {
            if (element != null && element.getId() == id) {
                return element;
            }
        }
        return null;
    }

    private static User findById(long id) {
        for (User element : users) {
            if (element != null && element.getId() == id) {
                return element;
            }
        }
        return null;
    }

    public static User getUserBySessionId(String sessionId) {
        for (User element : users) {
            if (element != null && element.getSessionId() == sessionId) {
                return element;
            }
        }
        return null;
    }

    public static User save(User user) {
        if (user == null)
            return null;
            int index = 0;
            for (User element : users) {
                if (element == null) {
                    users[index] = user;
                    return users[index];
                }
                index++;
            }

        return null;
    }

    public static User update(User user) {

        if (findById(user.getId()) != null) {
            int index = 0;
            for (User element : users) {
                if (element != null && element.getId() == user.getId()) {
                    users[index] = user;
                    return users[index];

                }
                index++;
            }
        }
        return null;
    }

    public static void delete(long id){
        if(findById(id)!=null){
            int index = 0;
            for(User element:users){
                if(element!=null && element.getId()==id){
                    users[index] = null;
                    break;
                }
                index++;
            }
        }
    }
}
