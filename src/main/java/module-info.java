module com.travelpackageapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires mysql.connector.java; // Ensure correct module name here

    exports com.travelpackageapp;
    exports com.travelpackageapp.views;
    exports com.travelpackageapp.models;
}
