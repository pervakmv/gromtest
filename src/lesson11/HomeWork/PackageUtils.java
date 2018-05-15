package lesson11.HomeWork;

public class PackageUtils {

    public Room[] deleteNullElements(Room[] rooms) {
        Room[] arrayWithoutNullElement = new Room[numberNullElements(rooms)];
        int index = 0;
        for (Room element : rooms) {
            if (element != null) {
                arrayWithoutNullElement[index] = element;
                index++;
            }
        }
        return arrayWithoutNullElement;
    }

    public int numberNullElements(Room[] rooms) {
        int index = 0;
        for (Room element : rooms) {
            if (element == null)
                index++;
        }

        return index;
    }

    public int intAbs(int arg) {
        if (arg > 0)
            return arg;
        else
            return -1 * arg;
    }

}
