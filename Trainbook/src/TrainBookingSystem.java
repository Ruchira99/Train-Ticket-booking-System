import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TrainBookingSystem extends Application {
    static final int SEAT_NUMBER = 42;  //create a Global constant

    public static void main(String[] args) {
        Application.launch();
    } //call the start method

    @Override
    public void start(Stage primaryStage) throws Exception {
        String[][][] seat = new String[2][SEAT_NUMBER][3]; //create a 3D array with 42*3 capacity(2=trip  3=name , id)
        Scanner scan = new Scanner(System.in);
        System.out.println("\n***Welcome to Train Booking System***");
        System.out.println("---------------------------------------");
        menu:
        while (true) {
            System.out.println("\nEnter \"A\" for add a customer");
            System.out.println("Enter \"V\" for View all Seats");
            System.out.println("Enter \"E\" for view empty seats ");
            System.out.println("Enter \"D\" for Delete customer from seats");
            System.out.println("Enter \"F\" for find a seat by Customer name");
            System.out.println("Enter \"S\" for save data to database");
            System.out.println("Enter \"L\" for get data from the database");
            System.out.println("Enter \"O\" for View seats Order alphabetically by name");
            System.out.println("Enter \"Q\" for quit");
            System.out.println("---------------------------------------------------");
            System.out.print("Please select your option: ");

            String selection = scan.nextLine();
            selection = selection.toUpperCase(); //convert user input to upper case
            switch (selection) {
                case "A":
                    addCustomer(seat);
                    break;
                case "V":
                    viewAllSeats(seat);
                    break;
                case "E":
                    viewEmptySeats(seat);
                    break;
                case "D":
                    deleteCustomerFromSeat(seat);
                    break;
                case "F":
                    findSeatbyCustomerName(seat);
                    ;
                    break;
                case "S":
                    saveToDatabase(seat);
                    ;
                    break;
                case "L":
                    getDataFromDatabase(seat);
                    ;
                    break;
                case "O":
                    seatorderbyAlphabetically(seat);
                    break;
                case "Q":
                    System.out.println("---------------------------------------------------");
                    System.out.println("----------------Enjoy your Trip--------------------");
                    break menu; //quit from the menu
                default: //if no matching cases run
                    System.out.println("Invalid selection ");
                    break;
            }
        }
    }

    static String[][][] addCustomer(String[][][] seat) { //method for add customer
        Stage stage = new Stage();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String name = scan.nextLine();

        System.out.print("Enter your ID : ");
        String id = scan.nextLine();

        int trip = 0;
        while (true) {
            Scanner can = new Scanner(System.in);
            System.out.print("Enter 1 to book from Colombo Fort to Badulla\nEnter 2 to book from Badulla to Colombo Fort\n - ");
            try {
                trip = can.nextInt() - 1;

            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                continue;
            }
            if (trip > 1 || trip < 0) {
                System.out.println("Invalid Input");
                continue;
            }
            break;
        }

        CheckBox btn1 = new CheckBox("Seat 01");CheckBox btn2 = new CheckBox("Seat 02");
        CheckBox btn3 = new CheckBox("Seat 03");CheckBox btn4 = new CheckBox("Seat 04");
        CheckBox btn5 = new CheckBox("Seat 05");CheckBox btn6 = new CheckBox("Seat 06");
        CheckBox btn7 = new CheckBox("Seat 07");CheckBox btn8 = new CheckBox("Seat 08");
        CheckBox btn9 = new CheckBox("Seat 09");CheckBox btn10 = new CheckBox("Seat 10");
        CheckBox btn11 = new CheckBox("Seat 11");CheckBox btn12 = new CheckBox("Seat 12");
        CheckBox btn13 = new CheckBox("Seat 13");CheckBox btn14 = new CheckBox("Seat 14");
        CheckBox btn15 = new CheckBox("Seat 15");CheckBox btn16 = new CheckBox("Seat 16");
        CheckBox btn17 = new CheckBox("Seat 17");CheckBox btn18 = new CheckBox("Seat 18");
        CheckBox btn19 = new CheckBox("Seat 19");CheckBox btn20 = new CheckBox("Seat 20");
        CheckBox btn21 = new CheckBox("Seat 21");CheckBox btn22 = new CheckBox("Seat 22");
        CheckBox btn23 = new CheckBox("Seat 23");CheckBox btn24 = new CheckBox("Seat 24");
        CheckBox btn25 = new CheckBox("Seat 25");CheckBox btn26 = new CheckBox("Seat 26");
        CheckBox btn27 = new CheckBox("Seat 27");CheckBox btn28 = new CheckBox("Seat 28");
        CheckBox btn29 = new CheckBox("Seat 29");CheckBox btn30 = new CheckBox("Seat 30");
        CheckBox btn31 = new CheckBox("Seat 31");CheckBox btn32 = new CheckBox("Seat 32");
        CheckBox btn33 = new CheckBox("Seat 33");CheckBox btn34 = new CheckBox("Seat 34");
        CheckBox btn35 = new CheckBox("Seat 35");CheckBox btn36 = new CheckBox("Seat 36");
        CheckBox btn37 = new CheckBox("Seat 37");CheckBox btn38 = new CheckBox("Seat 38");
        CheckBox btn39 = new CheckBox("Seat 39");CheckBox btn40 = new CheckBox("Seat 40");
        CheckBox btn41 = new CheckBox("Seat 41");CheckBox btn42 = new CheckBox("Seat 42");

        //array with checkboxes
        CheckBox[] boxes = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16,
                btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29, btn30, btn31, btn32, btn33,
                btn34, btn35, btn36, btn37, btn38, btn39, btn40, btn41, btn42};
        GridPane root = new GridPane();

        Button btnConfirm = new Button("Confirm");
        Button btnReset = new Button("Reset");

        //adding checkboxes to the grid
        root.addRow(0, new Text("Welcome  "+ name +"\n \n "));
        root.add(new Text("Train Booking System"), 4, 0, 7, 4);
        root.addRow(4, btn1, new Text("  "), btn2, new Text("  "),
                btn3, new Text("  "), btn4, new Text("  "), btn5, new Text("  "), btn6);
        root.addRow(5, new Text("  "));
        root.addRow(6, btn13, new Text("  "), btn14, new Text("  "), btn15,
                new Text("  "), btn16, new Text("  "), btn17, new Text("  "), btn18);
        root.addRow(7, new Text("  "));
        root.addRow(8, btn19, new Text("  "), btn20, new Text("  "), btn21,
                new Text("  "), btn22, new Text("  "), btn23, new Text("  "), btn24);
        root.addRow(9, new Text(" \n "));
        root.addRow(10, btn25, new Text("  "), btn26, new Text("  "), btn27,
                new Text("  "), btn28, new Text("  "), btn29, new Text("  "), btn30);
        root.addRow(11, new Text("  "));
        root.addRow(12, btn31, new Text("  "), btn32, new Text("  "), btn33,
                new Text("  "), btn34, new Text("  "), btn35, new Text("  "), btn36);
        root.addRow(13, new Text("  "));
        root.addRow(14, btn37, new Text(" "), btn38, new Text(" "), btn39, new Text(" "),
                btn40, new Text("  "), btn41, new Text("  "), btn42);
        root.addRow(15, new Text("\n \n "));
        root.addRow(18, btnConfirm);
        root.addRow(18, new Text(" "), btnReset);


        for (int i=0; i<42; i++){
            int finalTrip =i;
            boxes[i].setOnAction((event) ->{
               boxes[finalTrip].setStyle("-fx-background-color:#80ccff");
               boxes[finalTrip].setDisable(true);
            });

        }

        Integer finalTrip = trip;
        btnConfirm.setOnAction((event)->

        {
            for (int i = 0; i < SEAT_NUMBER; i++) { //collect all select checkboxes
                if (boxes[i].isSelected()) {
                    seat[finalTrip][i][0] = name;
                    seat[finalTrip][i][1] = id;
                }
            }
            stage.close();
        });
        int finalTrip1 = trip;
        btnReset.setOnAction((event)->

        {
            for (int i = 0; i < SEAT_NUMBER; i++) {
                boxes[i].setSelected(false);
                boxes[i].setStyle("-fx-background-color:white");
                boxes[i].setDisable(false);
            }
            for (int i = 0; i < SEAT_NUMBER; i++) {
                if (!(seat[finalTrip1][i][0] == null)) {
                    boxes[i].setDisable(true);
                    boxes[i].setStyle("-fx-background-color:red");
                }
            }
        });
        for(int i = 0;
            i<SEAT_NUMBER;i++)
        {
            if (seat[trip][i][0] != null) {
                boxes[i].setDisable(true);
                boxes[i].setStyle("-fx-background-color:red");
            }
        }

        root.setAlignment(Pos.CENTER); //all set to center
        Scene scene = new Scene(root, 900, 460);

        stage.setTitle("Train Booking System");
        stage.setScene(scene);
        stage.showAndWait(); //pause the rest of code untill GUI close
        return seat;
    }

    public static void viewAllSeats(String[][][] seat){ //method for view all seats
        int trip = 0;
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter 1 to book from Colombo Fort to Badulla\nEnter 2 to book from Badulla to Colombo Fort\n - ");
            try {
                trip = scan.nextInt() - 1;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                continue;
            }
            if (trip > 1 || trip < 0) {
                System.out.println("Invalid Input");
                continue;
            }
            break;
        }
        Stage stage = new Stage();
        CheckBox btn1 = new CheckBox("Seat 01");CheckBox btn2 = new CheckBox("Seat 02");
        CheckBox btn3 = new CheckBox("Seat 03");CheckBox btn4 = new CheckBox("Seat 04");
        CheckBox btn5 = new CheckBox("Seat 05");CheckBox btn6 = new CheckBox("Seat 06");
        CheckBox btn7 = new CheckBox("Seat 07");CheckBox btn8 = new CheckBox("Seat 08");
        CheckBox btn9 = new CheckBox("Seat 09");CheckBox btn10 = new CheckBox("Seat 10");
        CheckBox btn11 = new CheckBox("Seat 11");CheckBox btn12 = new CheckBox("Seat 12");
        CheckBox btn13 = new CheckBox("Seat 13");CheckBox btn14 = new CheckBox("Seat 14");
        CheckBox btn15 = new CheckBox("Seat 15");CheckBox btn16 = new CheckBox("Seat 16");
        CheckBox btn17 = new CheckBox("Seat 17");CheckBox btn18 = new CheckBox("Seat 18");
        CheckBox btn19 = new CheckBox("Seat 19");CheckBox btn20 = new CheckBox("Seat 20");
        CheckBox btn21 = new CheckBox("Seat 21");CheckBox btn22 = new CheckBox("Seat 22");
        CheckBox btn23 = new CheckBox("Seat 23");CheckBox btn24 = new CheckBox("Seat 24");
        CheckBox btn25 = new CheckBox("Seat 25");CheckBox btn26 = new CheckBox("Seat 26");
        CheckBox btn27 = new CheckBox("Seat 27");CheckBox btn28 = new CheckBox("Seat 28");
        CheckBox btn29 = new CheckBox("Seat 29");CheckBox btn30 = new CheckBox("Seat 30");
        CheckBox btn31 = new CheckBox("Seat 31");CheckBox btn32 = new CheckBox("Seat 32");
        CheckBox btn33 = new CheckBox("Seat 33");CheckBox btn34 = new CheckBox("Seat 34");
        CheckBox btn35 = new CheckBox("Seat 35");CheckBox btn36 = new CheckBox("Seat 36");
        CheckBox btn37 = new CheckBox("Seat 37");CheckBox btn38 = new CheckBox("Seat 38");
        CheckBox btn39 = new CheckBox("Seat 39");CheckBox btn40 = new CheckBox("Seat 40");
        CheckBox btn41 = new CheckBox("Seat 41");CheckBox btn42 = new CheckBox("Seat 42");

        CheckBox[] boxes = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14,
                btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28,
                btn29, btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39, btn40, btn41, btn42};

        for(int i=0; i<SEAT_NUMBER;i++){    //get checkbox from array and set color to red if selected
            if(seat[trip][i][0]!=null){
                boxes[i].setStyle("-fx-background-color:#dd0000");
                boxes[i].setSelected(true);
            }
            boxes[i].setMouseTransparent(true);
        }

        GridPane root = new GridPane();
        Label lbn = new Label("Welcome to Train Booking System" );
        lbn.setStyle("-fx-font: 24 arial;");
        root.addRow(1, new Text("\n \n \n\n "));
        root.add(lbn, 2, 0, 11, 4);
        root.addRow(4, btn1, new Text("  "), btn2, new Text("  "), btn3,
                new Text("  "), btn4, new Text("  "), btn5, new Text("  "), btn6);
        root.addRow(5, new Text("  "));
        root.addRow(6, btn13, new Text("  "), btn14, new Text("  "), btn15,
                new Text("  "), btn16, new Text("  "), btn17, new Text("  "), btn18);
        root.addRow(7, new Text("  "));
        root.addRow(8, btn19, new Text("  "), btn20, new Text("  "), btn21,
                new Text("  "), btn22, new Text("  "), btn23, new Text("  "), btn24);
        root.addRow(9, new Text(" \n "));
        root.addRow(10, btn25, new Text("  "), btn26, new Text("  "), btn27,
                new Text("  "), btn28, new Text("  "), btn29, new Text("  "), btn30);
        root.addRow(11, new Text("  "));
        root.addRow(12, btn31, new Text("  "), btn32, new Text("  "), btn33,
                new Text("  "), btn34, new Text("  "), btn35, new Text("  "), btn36);
        root.addRow(13, new Text("  "));
        root.addRow(14, btn37, new Text(" "), btn38, new Text(" "), btn39, new Text(" "),
                btn40, new Text("  "), btn41, new Text("  "), btn42);
        root.addRow(15, new Text("\n \n "));

        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 900, 460);
        stage.setTitle("Train Booking System");
        stage.setScene(scene);
        stage.showAndWait();
    }

    public static void viewEmptySeats(String[][][] seat){ //view for empty seats
        int trip = 0;
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter 1 to book from Colombo Fort to Badulla\nEnter 2 to book from Badulla to Colombo Fort\n - ");
            try {
                trip = scan.nextInt() - 1;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                continue;
            }
            if (trip > 1 || trip < 0) {
                System.out.println("Invalid Input");
                continue;
            }
            break;
        }
        Stage stage = new Stage();
        CheckBox btn1 = new CheckBox("Seat 01");CheckBox btn2 = new CheckBox("Seat 02");
        CheckBox btn3 = new CheckBox("Seat 03");CheckBox btn4 = new CheckBox("Seat 04");
        CheckBox btn5 = new CheckBox("Seat 05");CheckBox btn6 = new CheckBox("Seat 06");
        CheckBox btn7 = new CheckBox("Seat 07");CheckBox btn8 = new CheckBox("Seat 08");
        CheckBox btn9 = new CheckBox("Seat 09");CheckBox btn10 = new CheckBox("Seat 10");
        CheckBox btn11 = new CheckBox("Seat 11");CheckBox btn12 = new CheckBox("Seat 12");
        CheckBox btn13 = new CheckBox("Seat 13");CheckBox btn14 = new CheckBox("Seat 14");
        CheckBox btn15 = new CheckBox("Seat 15");CheckBox btn16 = new CheckBox("Seat 16");
        CheckBox btn17 = new CheckBox("Seat 17");CheckBox btn18 = new CheckBox("Seat 18");
        CheckBox btn19 = new CheckBox("Seat 19");CheckBox btn20 = new CheckBox("Seat 20");
        CheckBox btn21 = new CheckBox("Seat 21");CheckBox btn22 = new CheckBox("Seat 22");
        CheckBox btn23 = new CheckBox("Seat 23");CheckBox btn24 = new CheckBox("Seat 24");
        CheckBox btn25 = new CheckBox("Seat 25");CheckBox btn26 = new CheckBox("Seat 26");
        CheckBox btn27 = new CheckBox("Seat 27");CheckBox btn28 = new CheckBox("Seat 28");
        CheckBox btn29 = new CheckBox("Seat 29");CheckBox btn30 = new CheckBox("Seat 30");
        CheckBox btn31 = new CheckBox("Seat 31");CheckBox btn32 = new CheckBox("Seat 32");
        CheckBox btn33 = new CheckBox("Seat 33");CheckBox btn34 = new CheckBox("Seat 34");
        CheckBox btn35 = new CheckBox("Seat 35");CheckBox btn36 = new CheckBox("Seat 36");
        CheckBox btn37 = new CheckBox("Seat 37");CheckBox btn38 = new CheckBox("Seat 38");
        CheckBox btn39 = new CheckBox("Seat 39");CheckBox btn40 = new CheckBox("Seat 40");
        CheckBox btn41 = new CheckBox("Seat 41");CheckBox btn42 = new CheckBox("Seat 42");

        CheckBox[] boxes = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13,
                btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27,
                btn28, btn29, btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39, btn40, btn41, btn42};

        for(int i=0; i<SEAT_NUMBER;i++){
            if(seat[trip][i][0]!=null){
                boxes[i].setStyle("-fx-background-color:#dd0000");
                boxes[i].setVisible(false);
                boxes[i].setMouseTransparent(true); //cant' click
            }else boxes[i].setMouseTransparent(true);
        }

        GridPane root = new GridPane();
        Label lbn = new Label("Welcome to Train Booking System" );

        lbn.setStyle("-fx-font: 24 arial;");

        root.addRow(0, new Text("\n \n "));
        root.add(lbn, 2, 0, 11, 4);
        root.addRow(4, btn1, new Text("  "), btn2, new Text("  "),
                btn3, new Text("  "), btn4, new Text("  "), btn5, new Text("  "), btn6);
        root.addRow(5, new Text("  "));
        root.addRow(6, btn13, new Text("  "), btn14, new Text("  "), btn15,
                new Text("  "), btn16, new Text("  "), btn17, new Text("  "), btn18);
        root.addRow(7, new Text("  "));
        root.addRow(8, btn19, new Text("  "), btn20, new Text("  "), btn21,
                new Text("  "), btn22, new Text("  "), btn23, new Text("  "), btn24);
        root.addRow(9, new Text(" \n "));
        root.addRow(10, btn25, new Text("  "), btn26, new Text("  "), btn27,
                new Text("  "), btn28, new Text("  "), btn29, new Text("  "), btn30);
        root.addRow(11, new Text("  "));
        root.addRow(12, btn31, new Text("  "), btn32, new Text("  "), btn33,
                new Text("  "), btn34, new Text("  "), btn35, new Text("  "), btn36);
        root.addRow(13, new Text("  "));
        root.addRow(14, btn37, new Text(" "), btn38, new Text(" "), btn39, new Text(" "),
                btn40, new Text("  "), btn41, new Text("  "), btn42);
        root.addRow(15, new Text("\n \n "));

        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 900, 460);
        stage.setTitle("Train Booking System");
        stage.setScene(scene);
        stage.showAndWait();
    }

    public static String[][][] deleteCustomerFromSeat(String[][][] seat){
        ArrayList<Integer> booked = new ArrayList<Integer>(); // Create an ArrayList object
        int trip;
        while (true) {
            Scanner delete = new Scanner(System.in);
            System.out.print("\nEnter 1 to delete from Colombo Fort to Badulla\nEnter 2 to delete from Badulla to Colombo Fort\n - ");
            try {
                trip = delete.nextInt() - 1;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                continue;
            }
            if (trip > 1 || trip < 0) {
                System.out.println("Invalid Input");
                continue;
            }
            break;
        }
        for (int i =0; i<SEAT_NUMBER;i++){
            if(seat[trip][i][0]!=null){ //get records from array which has a value
                booked.add(i+1);
            }
        }

        if(booked.size()==0){
            System.out.println("No records to delete");
            return seat;
        }
        int deleteMe=0;
        while (true) {
            System.out.println(Arrays.toString(booked.toArray()));
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter seat number to delete - ");
            try {
                deleteMe = (sc.nextInt() -1);
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                continue;
            }
            break;
        }
        if (booked.contains(deleteMe+1)){ //check array list
            seat[trip][deleteMe][0]=null; //name=null
            System.out.println("Record deleted");
        }else{
            System.out.println("Seat is not Booked to delete");
        }
        return seat;
    }

    public static void findSeatbyCustomerName(String[][][] seat){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name to search - ");
        String name = sc.nextLine();
        ArrayList<Integer> booked = new ArrayList<Integer>(); // Create an ArrayList object
        for (int i =0; i<SEAT_NUMBER;i++){
            if(name.equalsIgnoreCase(seat[0][i][0])){ //1 trip
                booked.add(i+1); //get data from record
            }if(name.equalsIgnoreCase(seat[1][i][0])){ //2 trip
                booked.add(i+1);
            }
        }
        if(booked.size()==0){ //checK records
            System.out.println("No records found");
        }else{
            System.out.println(name+" booked "+Arrays.toString(booked.toArray())+" seat/s");
        }
    }

    public static void seatorderbyAlphabetically(String[][][] seat){
        ArrayList<String> booked = new ArrayList<String>(); // Create an ArrayList object
        for (int i =0; i<SEAT_NUMBER;i++){
            if(seat[0][i][0]!=null){   //create string with seat numbers
                booked.add(seat[0][i][0]+" - "+Integer.toString(i));
            }if(seat[1][i][0]!=null){   //create string with seat numbers
                booked.add(seat[1][i][0]+" - "+Integer.toString(i));
            }
        }
        if(booked.size()==0){
            System.out.println("No records found  ");
            return;
        }
        Boolean flag = Boolean.TRUE; //if it is in order not create to order , in not order then create to order
        String temp = new String("");
        while(flag){
            for (int i=0;i<booked.size();i++){
                for (int k=0;k<booked.size();k++){
                    flag=false;
                    if(booked.get(i).compareToIgnoreCase(booked.get(k))<0){
                        temp = booked.get(i);
                        booked.set(i,booked.get(k));
                        booked.set(k,temp);
                        flag=true;
                    }
                }
            }
        }
        for (int i=0;i<booked.size();i++){
            System.out.println(booked.get(i));
        }
    }

    public static  void saveToDatabase(String[][][] seat){
        // Creating a Mongo client
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        // Accessing the database
        MongoDatabase database = mongoClient.getDatabase("TrainBooking");
        MongoCollection<Document> collection = database.getCollection("BookingRecords"); //get a collection
        System.out.println("Connected to the database successfully");
        BasicDBObject document = new BasicDBObject();
        collection.deleteMany(document); //delete all records in collection
        for(int i=0;i<SEAT_NUMBER;i++){
            if (seat[0][i][0]!=null){
                Document data = new Document("title", "BookingRecord") //create new document for upload
                        .append("seatNumber", i+1)
                        .append("name", seat[0][i][0])
                        .append("nic", seat[0][i][1])
                        .append("trip", 0);
                collection.insertOne(data); //export one record
            }if (seat[1][i][0]!=null){
                Document data = new Document("title", "BookingRecord") //create new document for upload
                        .append("seatNumber", i+1)
                        .append("name", seat[1][i][0])
                        .append("nic", seat[1][i][1])
                        .append("trip", 1);
                collection.insertOne(data); //export one record
            }
        }
        System.out.println(" Data Imported ");
    }

    private static String[][][] getDataFromDatabase(String[][][] seat){
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        // Accessing the database
        MongoDatabase database = mongoClient.getDatabase("TrainBooking");
        MongoCollection<Document> collection = database.getCollection("BookingRecords"); //get a collection
        System.out.println("Connected to the database successfully");
        FindIterable<Document> data = collection.find();
        for(Document temp :data){
            int trip=temp.getInteger("trip");
            seat[trip][temp.getInteger("seatNumber")-1][0]=temp.getString("name");
            seat[trip][temp.getInteger("seatNumber")-1][1]=temp.getString("nic");
        }
        System.out.println("Data imported");
        return seat;
    }
}