package sample;

public interface ITransport {

    void moveLocomotive();

    void drawLocomotive();

    void setPosition(int x , int y);

    void loadPassengers(int count);

    int getPassenger();

}
