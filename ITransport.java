package sample;

import javafx.scene.Node;

public interface ITransport {
    void moveCar();

    Node drawLocomotive();

    void setPosition(int x, int y);

    void loadPassenger(int count);

    int getPassenger();

}
