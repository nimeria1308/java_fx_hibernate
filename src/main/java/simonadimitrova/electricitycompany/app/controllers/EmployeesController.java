package simonadimitrova.electricitycompany.app.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
import java.math.BigDecimal;

public class EmployeesController {
    @FXML
    private TableView table;

    @FXML
    private TableColumn idColumn;

    @FXML
    private TableColumn nameColumn;

    @FXML
    private TableColumn salaryColumn;

    @FXML
    private void initialize() {
        loadTable();
    }

    private void loadTable() {
        ObservableList<Employee> employees = FXCollections.observableArrayList(EmployeeDAO.getAll());
        idColumn.setCellValueFactory(new PropertyValueFactory<Employee, Long>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        salaryColumn.setCellValueFactory(new PropertyValueFactory<Employee, Double>("salary"));
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
