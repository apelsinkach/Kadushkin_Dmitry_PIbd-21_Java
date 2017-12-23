package sample;

public class Knife {

    public void CuttingMeat(Meat m) {
        if (m.getHas_cleaned() == 0) {
            m.setHas_cleaned(10);
        }
    }

    public void CuttingLemon(Lemon l) {
        if (l.getHas_cleaned() == 0) {
            l.setHas_cleaned(10);
        }
    }


}
