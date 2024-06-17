package com.travelpackageapp;

import com.travelpackageapp.views.AdminLoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.travelpackageapp.views.MainPageView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        MainPageView mainPageView = new MainPageView(primaryStage);
        Scene scene = new Scene(mainPageView.getView(), 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("VacationBook Main Page");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
