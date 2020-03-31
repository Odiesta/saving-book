package com.odiesta;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import com.odiesta.datamodel.Employee;

public class TableViewExample extends Application {

    private final ObservableList<Employee> employees = FXCollections.observableArrayList(
            new Employee("John", "Hops", "Project Manager"),
            new Employee("Sam", "Wright", "Programmer"),
            new Employee("Alan", "Krowl", "Scrum Master"),
            new Employee("Joe", "Nash", "Tester"),
            new Employee("Scott", "Rikruiezky", "DevOps")
    );

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setPadding(new Insets(15));
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        TableView<Employee> employeeTable = new TableView<>();
        employeeTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        final Label label = new Label("Employee List");
        label.setFont(Font.font("Arial", 20));

        TableColumn<Employee, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Employee, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Employee, String> jobTitleCol = new TableColumn<>("Job Title");
        jobTitleCol.setMinWidth(100);
        jobTitleCol.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));

        employeeTable.setItems(employees);
        employeeTable.getColumns().addAll(firstNameCol, lastNameCol, jobTitleCol);

        root.getChildren().addAll(label, employeeTable);
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();

    }

}
