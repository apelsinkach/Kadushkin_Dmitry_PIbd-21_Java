package sample;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;;
import javafx.scene.shape.Rectangle;

public class CartLocomotive extends Locomotive {
    private boolean pipe;
    private boolean coal;

    private Color dopColor;

    public CartLocomotive(int maxSpeed, int maxCountPassenger, int maxCapacityGenerator, double weight, javafx.scene.paint.Color color, boolean pipe, boolean coal, Color dopColor) {
        super(maxSpeed, maxCountPassenger, maxCapacityGenerator, weight, color);
        this.pipe = pipe;
        this.coal = coal;
        this.dopColor = dopColor;
    }

    @Override
    protected Node drawBaseLocomotive() {
        Rectangle rectangle6 = new Rectangle(startPosX + 70, startPosY - 20, 10, 20);
        rectangle6.setOpacity(0);
        Rectangle rectangle7 = new Rectangle(startPosX + 10, startPosY - 5, 50, 10);  //Уголь    //Черный ка
        rectangle7.setOpacity(0);

        if (pipe) {
            rectangle6.setOpacity(1);
            rectangle6.setFill(dopColor);
        }
        if (coal) {
            rectangle7.setOpacity(1);
        }
        return new Pane(super.drawBaseLocomotive(), rectangle6, rectangle7);
    }
}
