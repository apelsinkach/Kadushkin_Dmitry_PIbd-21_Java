package sample;

import java.util.Dictionary;
import java.util.Hashtable;

public class ClassArray<T extends ITransport> {
    private T defaultValue;
    private int maxCount;
    private Dictionary<Integer, T> places;

    public ClassArray(int sizes, T defVal) {
        defaultValue = null;
        places = new Hashtable<Integer, T>();
        maxCount = sizes;
    }

    public static <T extends ITransport> int OpAddition(ClassArray<T> p, T train) {
        if (p.places.size() == p.maxCount) {
            return -1;
        }
        for (int i = 0; i < p.places.size(); i++) {
            if (p.CheckFreePlace(i)) {
                p.places.put(i, train);
                return i;
            }
        }
        p.places.put(p.places.size(), train);
        return p.places.size() - 1;
    }

    public static <T extends ITransport> T opSubtraction(ClassArray<T> p, int index) {
        if (!p.CheckFreePlace(index)) {
            T train = p.places.get(index);
            p.places.remove(index);
            return train;
        }
        return p.defaultValue;
    }

    private boolean CheckFreePlace(int index) {
        if (places.get(index) == null) return true;
        return false;
    }

    public T getTrain(int ind) {
        if (places.get(ind) != null) return places.get(ind);
        return defaultValue;
    }
}
