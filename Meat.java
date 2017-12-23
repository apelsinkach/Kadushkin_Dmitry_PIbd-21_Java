package sample;

public class Meat {

    private int has_ready = 0;

    private int marinade = 0;

    private int has_cleaned = 0;

    private int dirty = 10;

    private boolean Has_ready;

    private boolean Has_marinade;

    private int Has_cleaned;

    private int Dirty;

    public void GetHeat() {
        if (has_ready < 10) {
            has_ready++;
        }
    }

    public void Marinade() {
        if (marinade < 10) {
            marinade++;
        }
    }

    public boolean isHas_ready() {
        if (has_ready >= 10) {
            return true;
        } else
            return false;
    }

    public void setHas_ready(boolean has_ready) {
        Has_ready = has_ready;
    }

    public boolean isHas_marinade() {
        if (marinade >= 10)
            return true;
        else return false;
    }

    public void setHas_marinade(boolean has_marinade) {
        Has_marinade = has_marinade;
    }

    public int getHas_cleaned() {
        return Has_cleaned;
    }

    public void setHas_cleaned(int has_cleaned) {
        if (has_cleaned > -1 && has_cleaned < 11) Has_cleaned = has_cleaned;
    }

    public int getDirty() {
        return Dirty;
    }

    public void setDirty(int dirty) {
        if (dirty > -1 && dirty < 11) Dirty = dirty;
    }
}
