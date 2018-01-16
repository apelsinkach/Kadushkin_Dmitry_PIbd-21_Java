package sample;


import javafx.scene.Node;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.LinkedList;

public class Depo {
    ClassArray<ITransport> parkingStages;
    public LinkedList<javafx.scene.Node> list = new LinkedList<Node>();
    int placceSizeWidth = 210;
    int placeSizeHeight = 80;
    int countPlaces = 4;
    int currentLevel;

    public int getCurrentLevel() {
        return currentLevel;
    }

    public Depo() {
        parkingStages = new ClassArray<ITransport>(countPlaces, null);
    }

    public int PutCarInParking(ITransport train) {
        return parkingStages.OpAddition(parkingStages, train);
    }

    public ITransport GetCarInParking(int statement) {
        return ClassArray.opSubtraction(parkingStages, statement);
    }

    public LinkedList<Node> Draw() {
        list = new LinkedList<>();
        DrawMarking();
        for (int i = 0; i < countPlaces; i++) {
            ITransport train = parkingStages.getObject(i);
            if (train != null) {
                train.setPosition(5 + i / 5 * placceSizeWidth + 5, i % 5 * placeSizeHeight + 30);
                list.add(train.drawLocomotive());
            }
        }
        return list;
    }

    private void DrawMarking() {
        Text text = new Text(100, 100, "L" + (currentLevel + 1));
        list.add(text);
        list.add(new Rectangle(0, 0, (countPlaces / 5) * placceSizeWidth, 480));
        for (int i = 0; i < countPlaces; i++) {
            for (int j = 0; j < 6; ++j) {
                list.add(new Line(i * placceSizeWidth, j * placeSizeHeight, i * placceSizeWidth + 110, j * placeSizeHeight));
            }
            list.add(new Line(i * placceSizeWidth, 0, i * placceSizeWidth, 400));
        }
    }
}
