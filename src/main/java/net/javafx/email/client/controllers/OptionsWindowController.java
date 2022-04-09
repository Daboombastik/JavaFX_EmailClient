package net.javafx.email.client.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import net.javafx.email.client.constants.Controllers;
import net.javafx.email.client.constants.Fonts;
import net.javafx.email.client.constants.Themes;
import net.javafx.email.client.factory.ViewFactory;
import net.javafx.email.client.manager.EmailManager;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionsWindowController extends BaseController implements Initializable {

    public Button btnApply;
    public Button btnCancel;
    public Slider fontPicker;
    public ChoiceBox<Themes> themePicker;

    public OptionsWindowController(Controllers name, EmailManager emailManager, ViewFactory viewFactory) {
        super(name, emailManager, viewFactory);
    }

    public void applyBtnAction(ActionEvent event) {
        getViewFactory().setTheme(this.themePicker.getValue());
        getViewFactory().setFont(Fonts.values()[(int) this.fontPicker.getValue()]);
        closeWindow();
    }


    public void cancelButtonAction(ActionEvent event) {
        closeWindow();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTheme();
        setFont();
    }

    private void closeWindow() {
        Stage stage = (Stage) this.btnCancel.getScene().getWindow();
        getViewFactory().closeStage(stage);
    }

    private void setTheme() {
        this.themePicker.setItems(FXCollections.observableArrayList(Themes.values()));
        this.themePicker.setValue(getViewFactory().getTheme());
    }

    private void setFont() {
        this.fontPicker.setMin(0);
        this.fontPicker.setMax(Fonts.values().length - 1);
        this.fontPicker.setValue(getViewFactory().getFont().ordinal());
        this.fontPicker.setMinorTickCount(0);
        this.fontPicker.setMajorTickUnit(1);
        this.fontPicker.setBlockIncrement(1);
        this.fontPicker.setSnapToTicks(true);
        this.fontPicker.setShowTickMarks(true);
        this.fontPicker.setShowTickLabels(true);
        this.fontPicker.setLabelFormatter(new LabelConverter());
        this.fontPicker.valueProperty().addListener((obs, oldVal, newVal) -> {
            this.fontPicker.setValue(newVal.intValue());
        });
    }

    private static class LabelConverter extends StringConverter<Double> {

        @Override
        public String toString(Double tickLabel) {
            int i = tickLabel.intValue();
            return Fonts.values()[i].name();
        }

        @Override
        public Double fromString(String s) {
            return null;
        }
    }

}
