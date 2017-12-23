package sample;

public class Lemon {
    private int dirty = 10;
    private int has_cleaned = 0;

    private int Dirty;
    private int Has_cleaned;


    public int getDirty() {
        return Dirty;
    }

    public void setDirty(int dirty) {
        if (dirty > -1 && dirty < 11) {
            Dirty = dirty;
        }
    }

    public int getHas_cleaned() {
        return Has_cleaned;
    }

    public void setHas_cleaned(int has_cleaned) {
        if (has_cleaned > -1 && has_cleaned < 11) {
            Has_cleaned = has_cleaned;
        }
    }
}
