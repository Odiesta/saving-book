module SavingBook {

    requires java.sql;

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.media;
    requires javafx.graphics;

    requires kotlin.stdlib;
    requires sqlite.jdbc;

    opens com.odiesta;
    opens com.odiesta.datamodel;

}