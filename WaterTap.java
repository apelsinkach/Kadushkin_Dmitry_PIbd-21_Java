package sample;

public class WaterTap {
    public boolean State;

    public void WashingMeat(Meat m)
    {
        if (State)
        {
            m.setDirty(0);
        }
    }

    public void WashingLemon(Lemon l)
    {
        if (State)
        {
            l.setDirty(0);
        }
    }


}
