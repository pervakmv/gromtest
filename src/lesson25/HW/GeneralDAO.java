package lesson25.HW;

import lesson25.HW.exception.SaveException;

public class GeneralDAO<T> {

    private T[] data = (T[]) new Object[10];


    public T save(T t) throws Exception {

        validToSave(t);

        int index = 0;
        for (T el : data) {
            if (el == null) {
                data[index] = t;
                return data[index];
            }
            index++;
        }

        throw new SaveException("Can't save element");
    }

    public T[] getAll() {
        return data;
    }

    private void validToSave(T t) throws Exception {
        elementNoExist(t);
        notFreeCell();
    }

    private void elementNoExist(T t) throws Exception {
        for (T el : data) {
            if (el != null && el.equals(t))
                throw new SaveException("Element is already exist");
        }
    }

    private void notFreeCell() throws Exception {
        boolean Ok = false;
        for (T el : data) {
            if (el == null) {
                Ok = true;
                break;
            }
        }
        if (Ok == false)
            throw new SaveException("No free cell. Object was not be save");
    }
}
