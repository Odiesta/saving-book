package com.odiesta;

import com.odiesta.datamodel.Saving;
import com.odiesta.datamodel.SavingData;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TableView<Saving> table;

    @FXML
    private TextField amountSavedField;

    public void initialize() {
        table.setItems(SavingData.getDatabase().getSavingList());
    }

    @FXML
    public void save() {
        if (!amountSavedField.getText().equals("")) {
            if (amountSavedField.getText().matches("\\d+")) {
                long amount = Long.parseLong(amountSavedField.getText());
                SavingData.getDatabase().addSaving(new Saving(amount));
                amountSavedField.clear();
            }
        }
    }

}
