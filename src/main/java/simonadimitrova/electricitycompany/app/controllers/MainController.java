package simonadimitrova.electricitycompany.app.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import simonadimitrova.electricitycompany.model.dao.EmployeeDAO;

import java.math.BigDecimal;

public class MainController {
    @FXML
    private void onExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void onAbout(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Copyright (c) Simona Dimitrova").showAndWait();
    }

    private BigDecimal calculateIncome() {
        return new BigDecimal(1000); // TODO
    }

    @FXML
    private void onIncome(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Income: " + calculateIncome()).showAndWait();
    }

    private BigDecimal calculateExpenses() {
        BigDecimal salaries = EmployeeDAO.sumSalaries();
        BigDecimal facilities = new BigDecimal(0); // TODO
        return salaries.add(facilities);
    }

    @FXML
    private void onExpenses(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Expenses: " + calculateExpenses()).showAndWait();
    }

    @FXML
    private void onProfit(ActionEvent event) {
        BigDecimal profit = calculateIncome().subtract(calculateExpenses());
        new Alert(Alert.AlertType.INFORMATION, "Profit: " + profit).showAndWait();
    }

    @FXML
    private void onNetRevenue(ActionEvent event) {
        // 10% corporate tax
        BigDecimal netRevenue = (calculateIncome().multiply(new BigDecimal(0.9))).subtract(calculateExpenses());
        new Alert(
                Alert.AlertType.INFORMATION,
                "Net Revenue (with taxation): " + netRevenue).showAndWait();
    }
}
