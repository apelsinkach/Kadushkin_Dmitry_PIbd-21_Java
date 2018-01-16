package sample;

import javafx.scene.Node;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Depo {
    List<ClassArray<ITransport>> parkingStages;
    public LinkedList<javafx.scene.Node> list = new LinkedList<Node>();
    int placceSizeWidth = 210;
    int placeSizeHeight = 80;
    int countPlaces = 4;
    int currentLevel;
    private ITransport inter;

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int GetCurrentLevel() {
        return currentLevel;
    }

    public Depo() {
        parkingStages = new ArrayList<ClassArray<ITransport>>();
        for (int i = 0; i < 6; i++) {
            parkingStages.add(new ClassArray<ITransport>(6, null));
        }
        currentLevel = 0;
    }

    public void LevelUp() {
        if (currentLevel + 1 < parkingStages.size()) {
            currentLevel++;
        }
    }

    public void LevelDown() {
        if (currentLevel > 0) {
            currentLevel--;
        }
    }

    public int PutCarInParking(ITransport train) {
        return parkingStages.get(currentLevel).OpAddition(parkingStages.get(currentLevel), train);
    }

    public ITransport GetCarInParking(int statement) {
        return parkingStages.get(currentLevel).opSubtraction(parkingStages.get(currentLevel), statement);
    }

    public LinkedList<Node> Draw() {
        list = new LinkedList<>();
        DrawMarking();
        for (int i = 0; i < countPlaces; i++) {
            ITransport train = parkingStages.get(currentLevel).getTrain(i);
            if (train != null) {
                train.setPosition(5 + i / 5 * placceSizeWidth + 5, i % 5 * placeSizeHeight + 30);
//                train.drawCar();
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
