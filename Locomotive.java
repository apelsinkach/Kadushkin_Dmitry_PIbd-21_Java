package sample;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;


public class Locomotive extends Vehicle {


    protected int a = 10;
    protected int b = 200;

    public Locomotive(int maxSpeed, int maxCountPassenger, int maxCapacityGenerator, double weight, javafx.scene.paint.Color color) {
        this.MaxSpeed = maxSpeed;
        this.MaxCountPassengers = maxCountPassenger;
        this.MaxCapacityGenerator = maxCapacityGenerator;
        this.ColorBody = color;
        this.Weight = weight;
        this.countPassengers = 0;
        this.startPosX = a + (int) (Math.random() * b); // Генерация 1-го числа
        this.startPosY = a + (int) (Math.random() * b);  // Генерация 2-го числа
    }

    @Override
    public int getMaxSpeed() {
        return super.MaxSpeed;
    }

    @Override
    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed > 0 && maxSpeed < 200) {
            super.MaxSpeed = maxSpeed;
        } else {
            super.MaxSpeed = 150;
        }
    }


    @Override
    public double getWeight() {
        return super.Weight;
    }

    @Override
    public void setWeight(double weight) {
        if (weight > 800 && weight < 1300) {
            super.Weight = weight;
        } else {
            super.Weight = 1000;
        }
    }


    public Node drawLocomotive() {
        return drawBaseLocomotive();
    }

    protected Node drawBaseLocomotive() {
        Depo depo = new Depo();

        Ellipse ellipse1 = new Ellipse(startPosX + 10, startPosY + 30, 15, 15); //красный карандаш
        Ellipse ellipse2 = new Ellipse(startPosX + 25, startPosY + 30, 15, 15); //красный карандаш
        Ellipse ellipse3 = new Ellipse(startPosX + 60, startPosY + 30, 15, 15); //красный карандаш
        Ellipse ellipse4 = new Ellipse(startPosX + 75, startPosY + 30, 15, 15); //красный карандаш
        ellipse1.setFill(javafx.scene.paint.Paint.valueOf("Red"));
        ellipse2.setFill(javafx.scene.paint.Paint.valueOf("Red"));
        ellipse3.setFill(javafx.scene.paint.Paint.valueOf("Red"));
        ellipse4.setFill(javafx.scene.paint.Paint.valueOf("Red"));

        Rectangle rectangle1 = new Rectangle(startPosX - 5, startPosY + 20, 10, 10);
        Rectangle rectangle2 = new Rectangle(startPosX + 100, startPosY + 20, 5, 5);

        Rectangle rectangle3 = new Rectangle(startPosX + 80, startPosY + 5, 15, 15);
        Line line1 = new Line(startPosX + 15, startPosY + 38, startPosX + 40, startPosY + 40);
        Line line2 = new Line(startPosX + 65, startPosY + 38, startPosX + 90, startPosY + 40);
        Rectangle rectangle4 = new Rectangle(startPosX, startPosY, 100, 30);   //черный карандаш
        rectangle4.setFill(javafx.scene.paint.Paint.valueOf(String.valueOf(ColorBody)));

        Pane pane = new Pane(line1, line2, ellipse1, ellipse2, ellipse3, ellipse4, rectangle1, rectangle2, rectangle3, rectangle4);
        depo.list.add(pane);
        return pane;
    }

    public void moveCar() {
        startPosX += (MaxSpeed * 50 / (float) Weight) / (countPassengers == 0 ? 1 : countPassengers);
        drawLocomotive();
    }
}
