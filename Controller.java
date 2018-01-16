package sample;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;

import java.util.ResourceBundle;

public class Controller implements Initializable {
    Color color;
    Color dopColor;
    int maxSpeed;
    int maxCountPass;
    double weight;
    int maxCapacityGenerator;

    Depo depo = new Depo();
    private ITransport inter;

    @FXML
    TextField fieldMaxSpeed;

    @FXML
    TextField fieldMaxPas;

    @FXML
    TextField fieldWeight;

    @FXML
    Button btnLoc;

    @FXML
    Button btnPasLoc;

    @FXML
    Button btnMove;

    @FXML
    CheckBox checkBox1;

    @FXML
    CheckBox checkBox2;

    @FXML
    CheckBox checkBox3;

    @FXML
    Pane drawPanel;

    @FXML
    ColorPicker generalColor;

    @FXML
    ColorPicker doColor;

    @FXML
    TextField countTrain;

    @FXML
    Pane dopDrawPanel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        color = Color.GREEN;
        dopColor = Color.YELLOW;
        maxSpeed = 200;
        maxCountPass = 50;
        weight = 1000;
        drawPanel.getChildren().addAll(depo.Draw());
    }

    public void btnActLoc(ActionEvent actionEvent) {
        generalColor.setOnAction((ActionEvent t) -> {
            color = generalColor.getValue();
        });
        try {
            maxSpeed = Integer.parseInt(fieldMaxSpeed.getText());
            maxCountPass = Integer.parseInt(fieldMaxPas.getText());
            weight = Integer.parseInt(fieldWeight.getText());
            Locomotive locomotive = new Locomotive(maxSpeed, maxCountPass, maxCapacityGenerator, weight, color);
            inter = locomotive;
            drawPanel.getChildren().addAll(locomotive.drawLocomotive());
        } catch (Exception e) {

        }
    }

    public void btnActPasLoc(ActionEvent actionEvent) {

    }

    public void btnActMove(ActionEvent actionEvent) {
        Rectangle rectangle = new javafx.scene.shape.Rectangle(700, 270, javafx.scene.paint.Paint.valueOf("Grey"));
        drawPanel.getChildren().add(rectangle);
        inter.moveCar();
        CartLocomotive cartLocomotive = new CartLocomotive(maxSpeed, maxCountPass, maxCapacityGenerator, weight, color, checkBox1.isSelected(), checkBox2.isSelected(), dopColor);
        drawPanel.getChildren().addAll(cartLocomotive.drawLocomotive());
    }


    public void btnDopColor(ActionEvent actionEvent) {
    }

    public void btnGenColor(ActionEvent actionEvent) {
    }

    public void buttonSelectColor_Click_1(ActionEvent actionEvent) {
    }

    public void buttonSelectDopColor_Click_1(ActionEvent actionEvent) {
    }

    public void putPasTrainBtnAction(ActionEvent actionEvent) {
        CartLocomotive train = new CartLocomotive(100, 4, 240, 1000, color, true, true, dopColor);
        inter = train;
        int place = depo.PutCarInParking(train);
        drawPanel.getChildren().setAll(depo.Draw());
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setContentText("Ваше место: " + place);
    }

    public void putTrainBtnAction(ActionEvent actionEvent) {
        Locomotive locomotive = new Locomotive(100, 4, 240, 1000, color);
        inter = locomotive;
        int place = depo.PutCarInParking(locomotive);
        drawPanel.getChildren().setAll(depo.Draw());
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setContentText("Ваше место: " + place);
    }

    public void takeBtnActionA(ActionEvent actionEvent) {
        drawPanel.getChildren().removeAll();
        if (countTrain.getText() != "") {
            ITransport train = depo.GetCarInParking(Integer.parseInt(countTrain.getText()));
            train.setPosition(5, 50);
            drawPanel.getChildren().setAll(depo.Draw());
            dopDrawPanel.getChildren().addAll(train.drawLocomotive());
        }
    }
}
