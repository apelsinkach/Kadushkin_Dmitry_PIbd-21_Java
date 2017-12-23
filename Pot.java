package sample;

public class Pot {
    private Meat meat;

    private Oil oil;

    private Spices spices;

    private Lemon lemon;

    private boolean marinadeReady = false;

    private boolean OilIn;

    private boolean MeatIn;

    private boolean MarinadeReady;

    private boolean ReadyToCook;


    public boolean isOilIn() {
        if (oil != null) return true;
        else return false;
    }


    public void setOilIn(boolean oilIn) {
        OilIn = oilIn;
    }

    public boolean isMeatIn() {
        if (meat != null) return true;
        else return false;
    }

    public void setMeatIn(boolean meatIn) {
        MeatIn = meatIn;
    }

    public boolean isMarinadeReady() {
        return marinadeReady;
    }

    public void setMarinadeReady(boolean marinadeReady) {
        MarinadeReady = marinadeReady;
    }

    public boolean isReadyToCook() {
        return !Check();
    }

    public void setReadyToCook(boolean readyToCook) {
        ReadyToCook = readyToCook;
    }


    public void AddOil(Oil oil) {
        this.oil = oil;
    }

    public void CreateMarinade(Spices spices, Lemon lemon) {
        if (!marinadeReady && oil != null) {
            this.spices = spices;
            this.lemon = lemon;
            marinadeReady = true;
        }
    }

    public void addMeat(Meat meat) {
        if (this.meat == null) {
            this.meat = meat;
        }
    }

    public boolean Check() {
        if (meat.isHas_marinade()) return false;
        return true;
    }

    public void GetMarinade() {
        if (!Check()) {
            return;
        }
        if (marinadeReady) {
            meat.Marinade();
        }
    }

    public Meat GetMeat() {
        return meat;
    }


}
