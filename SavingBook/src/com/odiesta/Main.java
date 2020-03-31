package com.odiesta;

import com.odiesta.datamodel.Saving;
import com.odiesta.datamodel.SavingData;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Saving Book");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        SavingData.getDatabase().load();
        if (SavingData.getDatabase().getSavingList().size() > 0) {
            ObservableList<Saving> savings = SavingData.getDatabase().getSavingList();
            Saving.counter = savings.get(savings.size()-1).getTotalSaving();
        }
        System.out.println("Database loaded");
    }

    @Override
    public void stop() throws Exception {
        SavingData.getDatabase().save();
        System.out.println("Database saved");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
