package sample;

import javafx.scene.Node;

public abstract class Vehicle implements ITransport {

    protected float startPosX;
    protected float startPosY;
    protected int countPassengers;

    public int MaxCountPassengers;

    public int MaxCapacityGenerator;

    public int MaxSpeed;

    public javafx.scene.paint.Color ColorBody;

    public double Weight;
    private int pas;
    private int speed;
    private int generator;
    private double weight;

    public void setMaxCountPassengers(int pas) {
        this.pas = pas;
    }

    public int getMaxCountPassengers() {
        return pas;
    }

    public void setMaxSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxSpeed() {
        return speed;
    }

    public void setMaxCapacityGenerator(int generator) {
        this.generator = generator;
    }

    public int getMaxCapacityGenerator() {
        return generator;
    }


    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public abstract void moveCar();

    public abstract Node drawLocomotive();

    public void setPosition(int x, int y) {
        startPosX = x;
        startPosY = y;
    }

    public void loadPassenger(int count) {
        if (countPassengers + count < pas) {
            countPassengers += count;
        }
    }

    public int getPassenger() {
        int count = countPassengers;
        countPassengers = 0;
        return count;
    }
}
