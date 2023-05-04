package com.example.summative3;

import javafx.application.Application;
import javafx.stage.Stage;

public class bookInfo extends Application {

    private String name;
    private double price;
    public bookInfo (String bookName, double Price){
        name = bookName;
        price = Price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
