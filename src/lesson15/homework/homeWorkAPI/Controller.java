package lesson15.homework.homeWorkAPI;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }


    public API[] getApis() {
        return apis;
    }

    Room[] requestRooms(int price, int persons, String city, String hotel) {
        Room[] res = null;

        for (API element : apis) {
            res = AddArrays(res, element.findRooms(price, persons, city, hotel));
            element.findRooms(price, persons, city, hotel);
        }
        return res;
    }

    Room[] AddArrays(Room[] ar1, Room[] ar2) {
        int size = 0;
        if (ar1 != null) size += ar1.length;
        if (ar2 != null) size += ar2.length;
        Room res[] = new Room[size];

        int index = 0;
        if (ar1 != null) {
            for (Room elementAr1 : ar1) {
                if (elementAr1 != null) res[index] = elementAr1;
                index++;
            }
        }
        if (ar2 != null) {
            for (Room elementAr2 : ar2) {
                if (elementAr2 != null) res[index] = elementAr2;
                index++;
            }
        }

        return res;
    }

    Room[] check(API api1, API api2) {

        Room[] res = new Room[api1.getAll().length];

        int index = 0;
        for (Room elementAr1 : api1.getAll()) {
            for (Room elementAr2 : api2.getAll()) {
                if (elementAr1.equals(elementAr2)) {
                    res[index] = elementAr1;
                    index++;
                }
            }
        }
        return res[0].deleteNullElements(res);
    }

}
