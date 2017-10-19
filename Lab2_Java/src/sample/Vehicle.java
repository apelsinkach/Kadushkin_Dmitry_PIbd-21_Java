package sample;

import javafx.scene.paint.Color;

public abstract class Vehicle implements ITransport {

    protected int a=30;
    protected int b=150;

    protected int startPosX =a + (int) (Math.random() * b); // Генерация 1-го числа
    protected int startPosY=a + (int) (Math.random() * b);  // Генерация 2-го числа

    protected int countPassengers;

    public int MaxCountPassengers;

    public int MaxSpeed;

    public Color ColorBody;

    public double Weight;

    public abstract void drawLocomotive();


    public abstract void moveLocomotive();


    public int getPassenger()
    {
        int count = countPassengers;
        countPassengers = 0;
        return count;
    }

    public void loadPassengers(int count)
    {
        if (countPassengers + count < getMaxCountPassengers())
        {
            countPassengers += count;
        }
    }


    public void setPosition(int x, int y)
    {
        startPosX = x;
        startPosY = y;

    }

    protected double getWeight() {
        return Weight;
    }

    protected void setWeight(double weight) {
        Weight = weight;
    }

    protected int getMaxCountPassengers() {
        return MaxCountPassengers;
    }

    protected void setMaxCountPassengers(int maxCountPassengers) {
        MaxCountPassengers = maxCountPassengers;
    }

    protected int getMaxSpeed() {
        return MaxSpeed;
    }

    protected void setMaxSpeed(int maxSpeed) {
        MaxSpeed = maxSpeed;
    }

    protected Color getColorBody() {
        return ColorBody;
    }

    protected void setColorBody(Color colorBody) {
        ColorBody = colorBody;
    }
}
