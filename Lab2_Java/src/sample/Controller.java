package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.net.URL;

import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    Pane drawPanel;
    @FXML
    ColorPicker buttonSelectColor;
    @FXML
    ColorPicker buttonSelectDopColor;
    @FXML
    TextField textBoxMaxSpeed;
    @FXML
    TextField textBoxMaxCountPassenger;
    @FXML
    TextField textBoxWeight;
    @FXML
    CheckBox checkBoxPipe;
    @FXML
    CheckBox checkBoxCoal;

    Color color;
    Color dopColor;
    int maxSpeed;
    int maxCountPass;
    int weight;

    private ITransport inter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        color = Color.GREY;
        dopColor = Color.YELLOW;
        maxSpeed = 150;
        maxCountPass = 4;
        weight = 1500;
    }
    

    public void buttonSelectColor_Click_1(ActionEvent actionEvent) {
    }


    public void buttonSelectDopColor_Click_1(ActionEvent actionEvent) {
    }

    public void btnSetBaseLocomotive_Click(ActionEvent actionEvent) {
        try{
            maxSpeed=Integer.parseInt(textBoxMaxSpeed.getText());
            maxCountPass=Integer.parseInt(textBoxMaxCountPassenger.getText());
            weight=Integer.parseInt(textBoxWeight.getText());

            Rectangle rectangle = new Rectangle(700, 270, javafx.scene.paint.Paint.valueOf("White"));
            drawPanel.getChildren().add(rectangle);

            Locomotive locomotive = new Locomotive(maxSpeed, maxCountPass, weight, color);
            inter = locomotive;
            drawPanel.getChildren().addAll(locomotive.drawBaseLocomotive());

        }catch (Exception e){

        }
    }

    public void button_SetTepl_Click(ActionEvent actionEvent) {
     try {
         maxSpeed=Integer.parseInt(textBoxMaxSpeed.getText());
         maxCountPass=Integer.parseInt(textBoxMaxCountPassenger.getText());
         weight=Integer.parseInt(textBoxWeight.getText());
         Rectangle rectangle = new Rectangle(700, 270, javafx.scene.paint.Paint.valueOf("White"));
         drawPanel.getChildren().add(rectangle);

         CartLocomotive cartLocomotive = new CartLocomotive(maxSpeed, maxCountPass, weight, color, checkBoxPipe.isSelected(), checkBoxCoal.isSelected(), dopColor);
         inter = cartLocomotive;
         drawPanel.getChildren().addAll(cartLocomotive.drawBaseLocomotive());

     }catch (Exception e){

     }
    }

    public void moveButton_Click(ActionEvent actionEvent) {
        Rectangle rectangle = new Rectangle(700,270, javafx.scene.paint.Paint.valueOf("White"));
        drawPanel.getChildren().add(rectangle);

            inter.moveLocomotive();
            CartLocomotive cartLocomotive = new CartLocomotive(maxSpeed, maxCountPass, weight, color, checkBoxPipe.isSelected(), checkBoxCoal.isSelected(), dopColor);

            drawPanel.getChildren().addAll(cartLocomotive.drawBaseLocomotive());

    }
}
