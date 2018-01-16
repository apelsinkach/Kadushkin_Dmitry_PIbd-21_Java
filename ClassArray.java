package sample;

import java.util.ArrayList;

public class ClassArray<T extends ITransport> {
    private ArrayList<T> places = null;
    private T defaultValue;

    public ClassArray(int sizes, T defVal) {
        defaultValue = null;
        places = new ArrayList<T>();

        for (int i = 0; i < sizes; i++) {
            places.add(defVal);
        }
    }

    public T getObject(int ind) {
        if (ind > -1 && ind < places.size()) {
            return places.get(ind);
        }
        return defaultValue;
    }

    public static <T extends ITransport> int OpAddition(ClassArray<T> p, T train) {
        for (int i = 0; i < p.places.size(); i++) {
            if (p.CheckFreePlace(i)) {
                p.places.set(i, train);
                return i;
            }
        }
        return -1;
    }

    public static <T extends ITransport> T opSubtraction(ClassArray<T> p, int index) {
        if (!p.CheckFreePlace(index)) {
            T train = p.places.get(index);
            p.places.set(index, p.defaultValue);
            return train;
        }
        return p.defaultValue;
    }

    private boolean CheckFreePlace(int index) {
        if (index < 0 || index > places.size()) {
            return false;
        }
        if (places.get(index) == null) {
            return true;
        }
        if (places.get(index).equals(defaultValue)) {
            return true;
        }
        return false;
    }

}
