package simonadimitrova.electricitycompany.app.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import simonadimitrova.electricitycompany.model.dao.EmployeeDAO;
import simonadimitrova.electricitycompany.model.entities.Employee;

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
        ObservableList<Employee> employees = FXCollections.observableArrayList(EmployeeDAO.getAll());
        idColumn.setCellValueFactory(new PropertyValueFactory<Employee, Long>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<Employee, BigDecimal>("salary"));
        table.setItems(employees);
    }
}
