package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class Controller {
    @FXML
    public Button takeMeatBtn;
    public Button takeLemonBtn;
    public Button takeSpicesBtn;
    public Button takeOilBtn;
    public Button washMeatBtn;
    public Button washLemonBtn;
    public Button cutMeatBtn;
    public Button cutLemonBtn;
    public Button burnCoalBtn;
    public Button roastMeatBtn;
    public Button addSpicesAndLemonBtn;
    public Button addOilBtn;
    public Button addMeatBtn;
    public Button outMeatBtn;
    public RadioButton openedWaterTapRadio;
    public RadioButton closedWaterTapRadio;

    private Meat meat = new Meat();

    private Lemon lemon = new Lemon();

    private Spices spices;

    private WaterTap tap = new WaterTap();

    private Grille grille = new Grille();

    private Pot pot = new Pot();

    private Oil oil = new Oil();

    private Knife knife = new Knife();

    private Coal coal = new Coal();


    public void takeMeatAction(ActionEvent actionEvent) {
        meat = new Meat();
        takeMeatBtn.setDisable(true);
        if (openedWaterTapRadio.isSelected()) {
            washMeatBtn.setDisable(false);
        }
    }

    public void takeLemonAction(ActionEvent actionEvent) {

        lemon = new Lemon();
        takeLemonBtn.setDisable(true);
        if (openedWaterTapRadio.isSelected()) {
            washLemonBtn.setDisable(false);
        }
    }

    public void takeOilAction(ActionEvent actionEvent) {
        oil = new Oil();
        takeOilBtn.setDisable(true);
        addOilBtn.setDisable(false);
    }

    public void takeSpicesAction(ActionEvent actionEvent) {
        if (spices == null) spices = new Spices();
        spices.setCount(100);
        takeSpicesBtn.setDisable(true);
        if (isReadyToMarinade()) {
            addSpicesAndLemonBtn.setDisable(false);
        }
    }

    public void washMeatAction(ActionEvent actionEvent) {
        tap.WashingMeat(meat);
        if (meat.getDirty() == 0) {
            cutMeatBtn.setDisable(false);
        }
        washMeatBtn.setDisable(true);
    }

    public void openedWaterTapAction(ActionEvent actionEvent) {
        closedWaterTapRadio.setSelected(false);
        if (openedWaterTapRadio.isSelected()) {
            if (takeMeatBtn.isDisabled()) {
                washMeatBtn.setDisable(false);
            }
            if (takeLemonBtn.isDisabled()) {
                washLemonBtn.setDisable(false);
            }
            tap.State = true;
        }
    }

    public void closedWaterTapAction(ActionEvent actionEvent) {
        openedWaterTapRadio.setSelected(false);
        if (closedWaterTapRadio.isSelected()) {
            if (!takeMeatBtn.isDisabled()) {
                washMeatBtn.setDisable(true);
            }
            if (!takeLemonBtn.isDisabled()) {
                washLemonBtn.setDisable(true);
            }
            tap.State = false;
        }
    }

    public void washLemonAction(ActionEvent actionEvent) {
        tap.WashingLemon(lemon);
        if (lemon.getDirty() == 0) {
            cutLemonBtn.setDisable(false);
        }
        washLemonBtn.setDisable(true);
    }

    public void cutMeatAction(ActionEvent actionEvent) {
        if (meat.getDirty() == 0) {
            knife.CuttingMeat(meat);
        }
        cutMeatBtn.setDisable(true);
        if (pot.isMarinadeReady()) {
            addMeatBtn.setDisable(false);
        }
    }

    public void cutLemonAction(ActionEvent actionEvent) {
        knife.CuttingLemon(lemon);
        cutLemonBtn.setDisable(true);
        if (isReadyToMarinade()) {
            addSpicesAndLemonBtn.setDisable(false);
        }
    }

    public void burnCoalAction(ActionEvent actionEvent) {
        burnCoalBtn.setDisable(false);
        if (coal != null) {
            grille.setCoal(coal);
        } else {
            Alert alert3 = new Alert(Alert.AlertType.ERROR, "Нет угля!");
            alert3.show();
            coal = new Coal();
            coal.Weight = 2000;
        }
        grille.getCoal().setBurning(true);
        while (!grille.CoalReady()) {
            grille.CookCoal();
        }
        if (meat == null || !meat.isHas_marinade()) {
            Alert alert4 = new Alert(Alert.AlertType.INFORMATION, "Теперь приготовьте мясо!");
            alert4.show();
            ;
        } else {
            roastMeatBtn.setDisable(false);
        }
    }

    public void roastMeatAction(ActionEvent actionEvent) {
        roastMeatBtn.setDisable(true);
        grille.setMeat(meat);
        meat = null;
        while (!grille.isReady()) {
            grille.Cook();
        }
        meat = grille.getMeat();
        if (meat.isHas_ready()) {
            Alert alert5 = new Alert(Alert.AlertType.INFORMATION, "Шашлык готов!");
            alert5.show();
        }
    }

    public void addSpicesAndLemonAction(ActionEvent actionEvent) {
        addSpicesAndLemonBtn.setDisable(true);
        pot.CreateMarinade(spices, lemon);
        spices = null;
        lemon = null;
        if (meat.getHas_cleaned() == 10) {
            addMeatBtn.setDisable(false);
        }
    }

    public void addOilAction(ActionEvent actionEvent) {
        pot.AddOil(oil);
        addOilBtn.setDisable(true);
    }

    public void addMeatAction(ActionEvent actionEvent) {

        pot.addMeat(meat);
        meat = null;
        outMeatBtn.setDisable(false);
        addMeatBtn.setDisable(true);
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION, "Мясо замариновалось!");
        alert1.show();
    }

    public void outMeatAction(ActionEvent actionEvent) {
        meat = pot.GetMeat();
        if (!grille.CoalReady()) {
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION, "Теперь нужны угли!");
            alert2.show();
        } else roastMeatBtn.setDisable(false);
        outMeatBtn.setDisable(true);
        if (grille.CoalReady()) {
            roastMeatBtn.setDisable(false);
        }
    }

    private boolean isReadyToMarinade() {
        if (lemon == null) {
            return false;
        } else if (lemon.getHas_cleaned() != 10) {
            return false;
        }

        if (oil == null) {
            return false;
        }

        if (spices == null) {
            return false;
        }

        return true;
    }

}
