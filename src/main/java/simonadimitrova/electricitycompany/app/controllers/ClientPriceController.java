package simonadimitrova.electricitycompany.app.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import simonadimitrova.electricitycompany.model.dao.ClientPriceDAO;
import simonadimitrova.electricitycompany.model.entities.Client;
import simonadimitrova.electricitycompany.model.entities.ClientPrice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;

public class ClientPriceController {
    @FXML
    private TextField pricePrivate;

    @FXML
    private TextField priceCompany;

    private void changedPrice(Client.Type type, TextField field) {
        ClientPrice price = ClientPriceDAO.get(type);
        BigDecimal oldPrice = price.getValue();
        try {
            BigDecimal newPrice = new BigDecimal(field.getText());
            price.setValue(newPrice);
            ClientPriceDAO.saveOrUpdate(price);
        } catch (NumberFormatException nfe) {
            new Alert(Alert.AlertType.ERROR, "bad format").showAndWait();
            field.setText(oldPrice.toString());
            throw nfe;
        } catch (ConstraintViolationException ex) {
            String message = "";
            for (ConstraintViolation v : ex.getConstraintViolations()) {
                message += v.getMessage();
                message += '\n';
            }
            field.setText(oldPrice.toString());

            new Alert(Alert.AlertType.ERROR, message).showAndWait();
            throw ex;
        }
    }

    @FXML
    private void initialize() {
        ClientPrice priv = ClientPriceDAO.get(Client.Type.PRIVATE);
        pricePrivate.setText(priv.getValue().toString());
        pricePrivate.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    // out of focus, try setting it
                    changedPrice(Client.Type.PRIVATE, pricePrivate);
                }
            }
        });

        ClientPrice cmp = ClientPriceDAO.get(Client.Type.COMPANY);
        priceCompany.setText(cmp.getValue().toString());
        priceCompany.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    // out of focus, try setting it
                    changedPrice(Client.Type.COMPANY, priceCompany);
                }
            }
        });
    }
}
