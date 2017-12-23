package sample;

public class Grille {
    private Meat meat;

    private Coal coal;

    private Meat Meat;

    private Coal Coal;

    private boolean isReady;


    public sample.Meat getMeat() {
        return meat;
    }

    public void setMeat(sample.Meat meat) {
        this.meat=meat;
    }

    public sample.Coal getCoal() {
        return coal;
    }

    public void setCoal(sample.Coal coal) {
        this.coal=coal;
    }

    public boolean isReady() {
        return meat.isHas_ready();
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }


    public void CookCoal()
    {
        if (coal == null) { return; }
        if (!coal.isHas_ready()) { coal.Burning(); }
    }

    public void Cook()
    {
        if (!Cheak()) { return; }
        if (!meat.isHas_ready()) { meat.GetHeat(); }
    }
    private boolean Cheak()
    {
        if (coal == null) { return false; }
        if (!coal.isHas_ready()) { return false; }
        if (meat == null) { return false; }
        return true;
    }
    public boolean CoalReady()
    {
        if (coal == null) { return false; }
        if (!coal.isHas_ready()) { return false; }
        return true;
    }
}
