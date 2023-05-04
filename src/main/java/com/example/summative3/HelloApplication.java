package com.example.summative3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Summative 3");

        Label shoppingCartTittle = new Label("Book Store:");

        BorderPane borderPane = new BorderPane();


        ListView<String>bookName = new ListView<String>();
        bookName.setPrefSize(100,100);
        File file = new File("BookPrices.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));


        String line;

        ArrayList<bookInfo>bookInfo = new ArrayList<bookInfo>();

        while ( (line = bufferedReader.readLine()) !=null) {
            //the hasNextInt() function will keep reading the file until it can't read a value that can be read as an int
            //While we can read integers in the file, do the following
            String arr[];
            arr = line.split(",");

            String tempValue = "";
            for (int i = 0 ; i < arr.length; i++){

                tempValue += arr[i];

            }
            bookName.getItems().add(tempValue);

            String tempBookName = arr[0];
            double tempBookPrice = Double.parseDouble(arr[1]);
            bookInfo.add( new bookInfo(tempBookName,tempBookPrice));

        }




             ListView<String>shoppingCart = new ListView<String>();
        shoppingCart.setPrefSize(100,100);


        bookName.getSelectionModel().selectedIndexProperty().addListener(event ->{

            String  selectedItems = bookName.getSelectionModel().getSelectedItem();
            shoppingCart.getItems().add(selectedItems);

        });



        Button clearCart = new Button("Clear");
        Button removeItem = new Button("Remove");
        Button checkOut =  new Button("Checkout");

        clearCart.setOnAction(event -> {
            shoppingCart.getItems().clear();

        });

        removeItem.setOnAction(event -> {
            String selectedItem = shoppingCart.getSelectionModel().getSelectedItem();
            shoppingCart.getItems().remove(selectedItem);
        });

        checkOut.setOnAction(event -> {
            double price;

            for (int i = 0; i < shoppingCart.getItems().size(); i++){

                if(shoppingCart.getItems().get(i) == bookName.getItems().get(0)){


                }
            }
        });

        Label subTotalTitle = new Label("subtotal");
        Label subTotal = new Label();
        Label totalTitle = new Label("total");
        Label total = new Label();

        HBox tittleBox = new HBox(shoppingCartTittle);
        tittleBox.setAlignment(Pos.CENTER);
        borderPane.setTop(tittleBox);

        VBox listViewBox = new VBox(bookName,shoppingCart);
        borderPane.setBottom(listViewBox);

        VBox buttonBox = new VBox(clearCart,removeItem,checkOut);
        buttonBox.setSpacing(10);
        borderPane.setLeft(buttonBox);

        VBox totalBox = new VBox(subTotalTitle,subTotal,totalTitle,total);
        totalBox.setSpacing(10);
        borderPane.setRight(totalBox);

        Scene scene = new Scene(borderPane, 300, 300);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

    }
