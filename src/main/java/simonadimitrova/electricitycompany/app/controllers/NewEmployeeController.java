package simonadimitrova.electricitycompany.app.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import simonadimitrova.electricitycompany.model.dao.EmployeeDAO;
import simonadimitrova.electricitycompany.model.entities.Employee;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.math.BigDecimal;

public class NewEmployeeController {

    @FXML
    private TextField name;

    @FXML
    private TextField salary;

    private Employee createEmployee() {
        String name = this.name.getText();
        BigDecimal salary = new BigDecimal(0);
        try {
            salary = new BigDecimal(this.salary.getText());
        } catch (NumberFormatException ex) { }

        Employee employee = new Employee(name, salary);

        // now try adding it to the DB
        EmployeeDAO.saveOrUpdate(employee);

        return employee;
    }

    public static class NewDialog extends Dialog<Employee> {
        private NewEmployeeController controller;

        public NewDialog() {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/new_employee.fxml"));
                Parent root = loader.load();
                controller = loader.getController();
                getDialogPane().setContent(root);
                getDialogPane().getButtonTypes().addAll(
                        new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE),
                        new ButtonType("OK", ButtonBar.ButtonData.OK_DONE));

                setResultConverter(button -> {
                    if (button.getButtonData().isCancelButton()) {
                        return null;
                    }

                    try {
                        return controller.createEmployee();
                    } catch (ConstraintViolationException ex) {
                        String message = "";
                        for (ConstraintViolation v : ex.getConstraintViolations()) {
                            message += v.getMessage();
                            message += '\n';
                        }

                        new Alert(Alert.AlertType.ERROR, message).showAndWait();
                        throw ex;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
