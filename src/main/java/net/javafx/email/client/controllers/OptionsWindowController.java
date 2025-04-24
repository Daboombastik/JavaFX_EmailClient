package net.javafx.email.client.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import net.javafx.email.client.models.Font;
import net.javafx.email.client.models.Theme;
import net.javafx.email.client.services.ViewService;
import net.javafx.email.client.services.EmailService;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionsWindowController extends BaseController implements Initializable {

    public AnchorPane baseNode;
    public Button btnApply;
    public Button btnCancel;
    public Slider fontPicker;
    public ChoiceBox<Theme> themePicker;

    public OptionsWindowController(ViewService viewService, EmailService emailService) {
        super(viewService, emailService);
    }

    public void applyBtnAction(ActionEvent event) {
        getViewService().setTheme(this.themePicker.getValue());
        getViewService().setFont(Font.values()[(int) this.fontPicker.getValue()]);
        getViewService().update();
        closeWindow(this.baseNode);
    }

    public void cancelButtonAction(ActionEvent event) {
        closeWindow(this.baseNode);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTheme();
        setFont();
    }

    private void setTheme() {
        this.themePicker.setItems(FXCollections.observableArrayList(Theme.values()));
        this.themePicker.setValue(getViewService().getTheme());
    }

    private void setFont() {
        this.fontPicker.setMin(0);
        this.fontPicker.setMax(Font.values().length - 1);
        this.fontPicker.setValue(getViewService().getFont().ordinal());
        this.fontPicker.setMinorTickCount(0);
        this.fontPicker.setMajorTickUnit(1);
        this.fontPicker.setBlockIncrement(1);
        this.fontPicker.setSnapToTicks(true);
        this.fontPicker.setShowTickMarks(true);
        this.fontPicker.setShowTickLabels(true);
        this.fontPicker.setLabelFormatter(new LabelConverter());
        this.fontPicker.valueProperty().addListener((obs, oldVal, newVal) -> this.fontPicker.setValue(newVal.intValue()));
    }

    private static class LabelConverter extends StringConverter<Double> {

        @Override
        public String toString(Double tickLabel) {
            int i = tickLabel.intValue();
            return Font.values()[i].name();
        }

        @Override
        public Double fromString(String s) {
            return null;
        }
    }
}