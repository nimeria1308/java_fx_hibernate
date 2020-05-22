package simonadimitrova.electricitycompany.app.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.BigDecimalStringConverter;
import simonadimitrova.electricitycompany.model.dao.EmployeeDAO;
import simonadimitrova.electricitycompany.model.entities.Employee;

import javax.persistence.Table;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.math.BigDecimal;

public class EmployeesController {
    @FXML
    private TableView<Employee> table;

    @FXML
    private TableColumn<Employee, Long> idColumn;

    @FXML
    private TableColumn<Employee, String> nameColumn;

    @FXML
    private TableColumn<Employee, BigDecimal> salaryColumn;

    @FXML
    private void initialize() {
        loadTable();
    }

    private void loadTable() {
        ObservableList<Employee> employees = FXCollections.observableArrayList(EmployeeDAO.getAll());
        idColumn.setCellValueFactory(new PropertyValueFactory<Employee, Long>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        salaryColumn.setCellValueFactory(new PropertyValueFactory<Employee, BigDecimal>("salary"));
        salaryColumn.setCellFactory(TextFieldTableCell.<Employee, BigDecimal>forTableColumn(new BigDecimalStringConverter()));
        table.setItems(employees);
    }

    @FXML
    private void onEditName(TableColumn.CellEditEvent<Employee, String> event) {
        TableView.TableViewSelectionModel<Employee> selectionModel = table.getSelectionModel();
        Employee employee = selectionModel.getSelectedItem();
        String oldName = employee.getName();
        employee.setName(event.getNewValue());
        try {
            EmployeeDAO.saveOrUpdate(employee);
        } catch (ConstraintViolationException ex) {
            String message = "";
            for (ConstraintViolation v: ex.getConstraintViolations()) {
                message += v.getMessage();
                message += '\n';
            }

            new Alert(Alert.AlertType.ERROR, message).showAndWait();
            employee.setName(oldName);
            table.getItems().set(selectionModel.getSelectedIndex(), employee);
        }
    }

    @FXML
    private void onNew(ActionEvent event) {
        NewEmployeeController.NewDialog dialog = new NewEmployeeController.NewDialog();
        dialog.showAndWait();
        Employee employee = dialog.getResult();
        if (employee != null) {
            table.getItems().add(employee);
        }
    }

    @FXML
    private void onDelete(ActionEvent event) {
        TableView.TableViewSelectionModel<Employee> selectionModel = table.getSelectionModel();
        Employee employee = selectionModel.getSelectedItem();
        if (employee != null) {
            EmployeeDAO.delete(employee);
            table.getItems().remove(employee);
        }
    }

    @FXML
    private void onEditSalary(TableColumn.CellEditEvent<Employee, BigDecimal> event) {
        TableView.TableViewSelectionModel<Employee> selectionModel = table.getSelectionModel();
        Employee employee = selectionModel.getSelectedItem();
        BigDecimal oldSalary = employee.getSalary();
        employee.setSalary(event.getNewValue());
        try {
            EmployeeDAO.saveOrUpdate(employee);
        } catch (ConstraintViolationException ex) {
            String message = "";
            for (ConstraintViolation v: ex.getConstraintViolations()) {
                message += v.getMessage();
                message += '\n';
            }

            new Alert(Alert.AlertType.ERROR, message).showAndWait();
            employee.setSalary(oldSalary);
            table.getItems().set(selectionModel.getSelectedIndex(), employee);
        }
    }
}
