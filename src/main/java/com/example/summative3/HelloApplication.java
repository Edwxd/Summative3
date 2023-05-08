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
        bookName.setPrefSize(200,200);
        File file = new File("BookPrices.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));


        Label cart = new Label("Cart:");
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
        shoppingCart.setPrefSize(200,200);


        bookName.getSelectionModel().selectedIndexProperty().addListener(event ->{

            String  selectedItems = bookName.getSelectionModel().getSelectedItem();
            shoppingCart.getItems().add(selectedItems);

        });



        Button clearCart = new Button("Clear");
        Button removeItem = new Button("Remove");
        Button checkOut =  new Button("Checkout");


        Label subTotalTitle = new Label("Subtotal :");
        Label subTotal = new Label();
        Label totalTitle = new Label("Total :");
        Label total = new Label();

        clearCart.setOnAction(event -> {
            shoppingCart.getItems().clear();
            subTotal.setText("");
            total.setText("");

        });

        removeItem.setOnAction(event -> {
            String selectedItem = shoppingCart.getSelectionModel().getSelectedItem();


            if(subTotal.getText() == ""){
                shoppingCart.getItems().remove(selectedItem);



            }else {

                double price = Double.parseDouble(subTotal.getText());

                    if ( selectedItem == bookName.getItems().get(0)) {

                        shoppingCart.getItems().remove(selectedItem);
                        price -= bookInfo.get(0).getPrice();


                    } else if (selectedItem == bookName.getItems().get(1)) {

                        shoppingCart.getItems().remove(selectedItem);
                        price -= bookInfo.get(1).getPrice();


                    } else if (selectedItem == bookName.getItems().get(2)) {

                        shoppingCart.getItems().remove(selectedItem);
                        price -= bookInfo.get(2).getPrice();


                    } else if (selectedItem == bookName.getItems().get(3)) {

                        shoppingCart.getItems().remove(selectedItem);
                        price -= bookInfo.get(3).getPrice();


                    } else if (selectedItem == bookName.getItems().get(4)) {

                        shoppingCart.getItems().remove(selectedItem);
                        price -= bookInfo.get(4).getPrice();


                    } else if (selectedItem == bookName.getItems().get(5)) {

                        shoppingCart.getItems().remove(selectedItem);
                        price -= bookInfo.get(5).getPrice();


                    } else if (selectedItem == bookName.getItems().get(6)) {

                        shoppingCart.getItems().remove(selectedItem);
                        price -= bookInfo.get(6).getPrice();

                    }


                subTotal.setText(String.valueOf(price));

                double tax = price * 0.07;

                total.setText(String.valueOf((price + tax)));
                }



        });

        checkOut.setOnAction(event -> {
            double price = 0;

            for (int i = 0; i < shoppingCart.getItems().size(); i++){

                if(shoppingCart.getItems().get(i) == bookName.getItems().get(0)){

                    price += bookInfo.get(0).getPrice();

                }else if(shoppingCart.getItems().get(i) == bookName.getItems().get(1)){

                    price += bookInfo.get(1).getPrice();

                }else if(shoppingCart.getItems().get(i) == bookName.getItems().get(2)){

                    price += bookInfo.get(2).getPrice();

                }else if(shoppingCart.getItems().get(i) == bookName.getItems().get(3)){

                    price += bookInfo.get(3).getPrice();

                }else if(shoppingCart.getItems().get(i) == bookName.getItems().get(4)){

                    price += bookInfo.get(4).getPrice();

                }else if(shoppingCart.getItems().get(i) == bookName.getItems().get(5)){

                    price += bookInfo.get(5).getPrice();

                }else if(shoppingCart.getItems().get(i) == bookName.getItems().get(6)){

                    price += bookInfo.get(6).getPrice();

                }
            }

            subTotal.setText(String.valueOf(price));

            double tax = price * 0.07;

            total.setText(String.valueOf((price + tax)));



        });





        VBox listViewBox = new VBox(shoppingCartTittle,bookName,cart,shoppingCart);
        borderPane.setRight(listViewBox);
        listViewBox.setSpacing(5);

        VBox buttonBox = new VBox(clearCart,removeItem,checkOut);
        buttonBox.setSpacing(10);
        borderPane.setLeft(buttonBox);

        VBox totalBox = new VBox(subTotalTitle,subTotal,totalTitle,total);
        totalBox.setSpacing(10);
        borderPane.setBottom(totalBox);

        Scene scene = new Scene(borderPane, 300, 300);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

    }
