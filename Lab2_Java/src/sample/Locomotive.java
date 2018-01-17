package sample;


import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;


public class Locomotive extends Vehicle {

    public Locomotive(int maxSpeed, int maxCountPassengers, double weight, Color color) {
        this.MaxSpeed = maxSpeed;
        this.MaxCountPassengers = maxCountPassengers;
        this.ColorBody = color;
        this.Weight = weight;
        this.countPassengers = 0;

    }


    @Override
    public int getMaxSpeed() {
        return super.MaxSpeed;
    }

    @Override
    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed > 0 && maxSpeed < 150) {
            super.MaxSpeed = maxSpeed;
        } else {
            super.MaxSpeed = 50;
        }
    }
    @Override
    public int getMaxCountPassengers(){
      return super.MaxCountPassengers;
    }

    @Override
    public void setMaxCountPassengers(int maxCountPassengers) {
        if (maxCountPassengers > 0 && maxCountPassengers < 0)
        {
            super.MaxCountPassengers = maxCountPassengers;
        }
        else
        {
            super.MaxCountPassengers = 4;
        }
    }

    @Override
    public double getWeight(){
        return super.Weight;
    }

    @Override
    public void setWeight(double weight) {
        if (weight > 300 && weight < 1000)
        {
            super.Weight = weight;
        }
        else
        {
            super.Weight = 1000;
        }
    }

    @Override
    public void drawLocomotive() {
        drawBaseLocomotive();

    }

    @Override
    public void moveLocomotive() {
        startPosX -= (MaxSpeed *50/(float)Weight)/(countPassengers==0?1:countPassengers);
        drawLocomotive();
    }

    protected Node drawBaseLocomotive(){

        Ellipse ellipse1 = new Ellipse(startPosX+10, startPosY + 30, 15, 15); //красный карандаш
        Ellipse ellipse2 = new Ellipse(startPosX + 25, startPosY+ 30, 15, 15); //красный карандаш
        Ellipse ellipse3 = new Ellipse(startPosX + 60, startPosY + 30, 15, 15); //красный карандаш
        Ellipse ellipse4 = new Ellipse(startPosX + 75, startPosY + 30, 15, 15); //красный карандаш
        ellipse1.setFill(javafx.scene.paint.Paint.valueOf("Red"));
        ellipse2.setFill(javafx.scene.paint.Paint.valueOf("Red"));
        ellipse3.setFill(javafx.scene.paint.Paint.valueOf("Red"));
        ellipse4.setFill(javafx.scene.paint.Paint.valueOf("Red"));

        Rectangle rectangle1=new Rectangle(startPosX-5, startPosY + 20, 10, 10);
        Rectangle rectangle2=new Rectangle(startPosX + 100, startPosY +20, 5, 5);

        Rectangle rectangle3=new Rectangle(startPosX + 80, startPosY + 5, 15, 15);
        Line line1=new Line(startPosX+15, startPosY + 38, startPosX + 40, startPosY + 40);
        Line line2=new Line(startPosX + 65, startPosY + 38, startPosX + 90, startPosY + 40);

        Rectangle rectangle4=new Rectangle(startPosX, startPosY, 100, 30);   //черный карандаш
        rectangle4.setFill(javafx.scene.paint.Paint.valueOf(String.valueOf(ColorBody)));

        Pane pane=new Pane( line1, line2,ellipse1,ellipse2,ellipse3,ellipse4,rectangle1,rectangle2,rectangle3,rectangle4);

        return pane;
    }
}







