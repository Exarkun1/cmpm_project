package com.propcool.cmpm_project.controllers;

import com.propcool.cmpm_project.components.TextFieldBox;
import com.propcool.cmpm_project.manage.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.*;
/**
 * Контроллер главной страницы
 * */
public class MainController implements Initializable {
    @FXML
    private AnchorPane mainPanel;
    @FXML
    private BorderPane outgoingPanel;
    @FXML
    private BorderPane outgoingPanelSettings;
    @FXML
    private Accordion accordionSettings;

    @FXML
    private AnchorPane paneForGraphs;

    @FXML
    private VBox paneForText;
    @FXML
    private Button creatFieldButton;

    @FXML
    private TextField nameNotebookField;
    @FXML
    private VBox paneForNotebooks;
    @FXML
    private ChoiceBox<String> systemChoice;
    /**
     * Сдвиг координат
     * */
    @FXML
    void mouseDragged(MouseEvent event) {
        mainManager.shift(event.getX(), event.getY());
    }
    /**
     * Клик по экрану
     * */
    @FXML
    void mousePressed(MouseEvent event) {
        mainManager.setMouse(event.getX(), event.getY());
    }
    /**
     * Масштабирование
     * */
    @FXML
    void scroll(ScrollEvent event) {
        mainManager.scale(event.getDeltaY(), event.getX(), event.getY());
    }
    /**
     * Открытие окна ввода
     * */
    @FXML
    void openTextFields(MouseEvent event) {
        mainManager.openTextFields();
    }
    /**
     * Открытие окна настроек
     * */
    @FXML
    void openSettings(MouseEvent event) {
        mainManager.openSettings();
    }
    /**
     * Добавление текстового поля для записи функций
     * */
    @FXML
    public void addTextField(ActionEvent event){
        mainManager.addTextField();
    }
    /**
     * Запись тетради
     * */
    @FXML
    void recordNotebook(ActionEvent event) {
        mainManager.recordNotebook(nameNotebookField.getText());
    }
    /**
     * Сохранение тетради
     * */
    @FXML
    void saveNotebook(ActionEvent event) {
        mainManager.saveNotebook();
    }
    /**
     * Загрузка тетради
     * */
    @FXML
    void loadNotebook(ActionEvent event) {
        mainManager.loadNotebook();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainManager = new MainManager(
                mainPanel, paneForGraphs, outgoingPanel,
                paneForText, creatFieldButton,
                outgoingPanelSettings, paneForNotebooks
        );

        outgoingPanel.setPrefHeight(mainManager.getHeight());
        outgoingPanel.setPrefWidth(400);
        outgoingPanel.setLayoutX(-400);

        outgoingPanelSettings.setPrefHeight(mainManager.getHeight());
        outgoingPanelSettings.setPrefWidth(400);
        outgoingPanelSettings.setLayoutX(-400);

        accordionSettings.setPrefHeight(mainManager.getHeight());
        accordionSettings.setPrefWidth(400);

        paneForGraphs.setPrefHeight(mainManager.getHeight());
        paneForGraphs.setPrefWidth(mainManager.getHeight());

        paneForNotebooks.setSpacing(10);

        creatFieldButton.setPrefWidth(400);

        systemChoice.getItems().addAll("cartesian", "polar");
        systemChoice.setOnAction(actionEvent -> {
            mainManager.changingCoordinateSystem(systemChoice.getValue());
        });
    }
    private MainManager mainManager;
}
