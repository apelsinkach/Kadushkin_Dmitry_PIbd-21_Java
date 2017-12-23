package sample;

public class Coal {

    public int Weight;

    private int has_ready = 0;

    private boolean burning = false;
    private boolean IsBurning;
    private boolean Has_ready;


    public void Burning() {
        if (has_ready < 10 && burning) {
            has_ready++;
        }
    }

    public boolean isBurning() {
        return burning;
    }

    public void setBurning(boolean burning) {
        this.burning = burning;
    }

    public boolean isHas_ready() {
        if (has_ready >= 10) {
            return true;
        } else {
            return false;
        }
    }

    public void setHas_ready(boolean has_ready) {
        Has_ready = has_ready;
    }
}
