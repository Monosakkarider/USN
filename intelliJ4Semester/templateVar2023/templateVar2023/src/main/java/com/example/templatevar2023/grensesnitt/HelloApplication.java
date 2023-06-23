package com.example.templatevar2023.grensesnitt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    //DEFINERER MENYEN:

    //Oppretter menylinjen:
    MenuBar menylinje = new MenuBar();

    //Oppretter overskrifter i menylinja:
    Menu Meny1 = new Menu("Meny 1");
    Menu Meny2 = new Menu("Meny 2");

    //Oppretter valgItems for hver Meny i menylinja:

    MenuItem valg1 = new MenuItem("Valg 1");
    MenuItem valg2 = new MenuItem("Valg 2");
    MenuItem valg3 = new MenuItem("Valg 3");
    MenuItem valg4 = new MenuItem("Valg 4");

    //Oppretter universale knapper:
    Button lagreKnapp = new Button("Lagre");
    Button tilbakeKnapp = new Button("Tilbake");

    //DEFINERER STAGE OG SCENER:
    private Stage primaryStage;
    private Scene primaryScene, valg1Scene, valg2Scene, valg3Scene, valg4Scene;


    @Override
    public void start(Stage primaryStage) throws IOException {

        try {
            //SETTER STAGE TIL primaryStage:
            this.primaryStage = primaryStage;
            BorderPane root = new BorderPane();
            Label velkomsttekst = new Label("Velkommen til hovedvinduet");

            //Lager menyene:
            Meny1.getItems().addAll(valg1,valg2);
            Meny2.getItems().addAll(valg3,valg4);

            //Legger menyene til menylinja:
            menylinje.getMenus().addAll(Meny1,Meny2);

            //Angir hvor menylinja skal være:
            root.setTop(menylinje);
            root.setCenter(velkomsttekst);

            //Angir hva som skal skje når bruker trykker på menyvalgene:
            valg1.setOnAction(e -> behandlerValg1());
            valg2.setOnAction(e -> behandlerValg2());
            valg3.setOnAction(e -> behandlerValg3());
            valg4.setOnAction(e -> behandlerValg4());

            //Angir primærscene:
            primaryScene = new Scene(root, 640, 480);
            primaryStage.setTitle("Hovedvindu");
            primaryStage.setScene(primaryScene);
            primaryStage.show();

            //Oppretter og bruker avsluttknapp:
            Button avsluttKnapp = new Button("Avslutt");
            avsluttKnapp.setOnAction(e -> System.exit(0));
            root.setBottom(avsluttKnapp);
            BorderPane.setAlignment(avsluttKnapp, Pos.BOTTOM_RIGHT);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //OPPRETTER FUNKSJONER TIL MENYVALGENE:
    //Valg 1:
    public void behandlerValg1() {
        Label valg1Tekst = new Label("Du har valgt valg 1");
        Label input1 = new Label("Skriv inn noe:");
        Label input2 = new Label("Skriv inn noe annet:");
        TextField input1Felt = new TextField();
        TextField input2Felt = new TextField();
        HBox row1 = new HBox(10, input1, input1Felt);
        HBox row2 = new HBox(10, input2, input2Felt);
        row1.setAlignment(Pos.CENTER);
        row2.setAlignment(Pos.CENTER);
        VBox layout = new VBox(10, valg1Tekst, row1, row2, lagreKnapp);
        layout.setAlignment(Pos.CENTER);
        tilbakeKnapp = new Button("Tilbake");
        tilbakeKnapp.setOnAction(e -> primaryStage.setScene(primaryScene));
        BorderPane rootValg1 = new BorderPane();
        rootValg1.setTop(valg1Tekst);
        rootValg1.setCenter(layout);
        rootValg1.setBottom(tilbakeKnapp);
        BorderPane.setAlignment(tilbakeKnapp, Pos.BOTTOM_RIGHT);
        valg1Scene = new Scene(rootValg1, 640, 480);
        primaryStage.setScene(valg1Scene);
    }

    //Valg 2:

    public void behandlerValg2() {
        Label valg2Tekst = new Label("Du har valgt valg 2");
        Label input1 = new Label("Skriv inn noe:");
        Label input2 = new Label("Skriv inn noe annet:");
        TextField input1Felt = new TextField();
        TextField input2Felt = new TextField();
        HBox row1 = new HBox(10, input1, input1Felt);
        HBox row2 = new HBox(10, input2, input2Felt);
        row1.setAlignment(Pos.CENTER);
        row2.setAlignment(Pos.CENTER);
        VBox layout = new VBox(10, valg2Tekst, row1, row2, lagreKnapp);
        layout.setAlignment(Pos.CENTER);
        tilbakeKnapp = new Button("Tilbake");
        tilbakeKnapp.setOnAction(e -> primaryStage.setScene(primaryScene));
        BorderPane rootValg2 = new BorderPane();
        rootValg2.setTop(valg2Tekst);
        rootValg2.setCenter(layout);
        rootValg2.setBottom(tilbakeKnapp);
        BorderPane.setAlignment(tilbakeKnapp, Pos.BOTTOM_RIGHT);
        valg2Scene = new Scene(rootValg2, 640, 480);
        primaryStage.setScene(valg2Scene);
    }

    //Valg 3:

    public void behandlerValg3() {

        Label velkommenMIT1 = new Label("Du har valgt Valg 3");

        TableView tabell = new TableView();
        TableColumn id = new TableColumn("ID");
        TableColumn fornavn = new TableColumn("Fornavn");
        TableColumn etternavn = new TableColumn("Etternavn");
        TableColumn email = new TableColumn("Email");
        TableColumn tlf = new TableColumn("Tlf");
        tabell.getColumns().addAll(id, fornavn, etternavn, email, tlf);

        tilbakeKnapp = new Button("tilbake");
        tilbakeKnapp.setOnAction(e -> primaryStage.setScene(primaryScene));

        BorderPane M2I1 = new BorderPane();
        M2I1.setTop(velkommenMIT1);
        M2I1.setCenter(tabell);
        M2I1.setBottom(tilbakeKnapp);

        BorderPane.setAlignment(tabell, Pos.TOP_CENTER);
        BorderPane.setAlignment(tilbakeKnapp, Pos.CENTER_RIGHT);
        valg3Scene = new Scene(M2I1, 640,480 );
        primaryStage.setScene(valg3Scene);
        /*
        Label valg3Tekst = new Label("Du har valgt valg 3");
        Label input1 = new Label("Skriv inn noe:");
        Label input2 = new Label("Skriv inn noe annet:");
        TextField input1Felt = new TextField();
        TextField input2Felt = new TextField();
        HBox row1 = new HBox(10, input1, input1Felt);
        HBox row2 = new HBox(10, input2, input2Felt);
        row1.setAlignment(Pos.CENTER);
        row2.setAlignment(Pos.CENTER);
        VBox layout = new VBox(10, valg3Tekst, row1, row2, lagreKnapp);
        layout.setAlignment(Pos.CENTER);
        tilbakeKnapp = new Button("Tilbake");
        tilbakeKnapp.setOnAction(e -> primaryStage.setScene(primaryScene));
        BorderPane rootValg3 = new BorderPane();
        rootValg3.setTop(valg3Tekst);
        rootValg3.setCenter(layout);
        rootValg3.setBottom(tilbakeKnapp);
        BorderPane.setAlignment(tilbakeKnapp, Pos.BOTTOM_RIGHT);
        valg3Scene = new Scene(rootValg3, 640, 480);
        primaryStage.setScene(valg3Scene);

         */
    }

    //Valg 4:

    public void behandlerValg4() {
        Label valg4Tekst = new Label("Du har valgt valg 4");
        Label input1 = new Label("Skriv inn noe:");
        Label input2 = new Label("Skriv inn noe annet:");
        TextField input1Felt = new TextField();
        TextField input2Felt = new TextField();
        HBox row1 = new HBox(10, input1, input1Felt);
        HBox row2 = new HBox(10, input2, input2Felt);
        row1.setAlignment(Pos.CENTER);
        row2.setAlignment(Pos.CENTER);
        VBox layout = new VBox(10, valg4Tekst, row1, row2, lagreKnapp);
        layout.setAlignment(Pos.CENTER);
        tilbakeKnapp = new Button("Tilbake");
        tilbakeKnapp.setOnAction(e -> primaryStage.setScene(primaryScene));
        BorderPane rootValg4 = new BorderPane();
        rootValg4.setTop(valg4Tekst);
        rootValg4.setCenter(layout);
        rootValg4.setBottom(tilbakeKnapp);
        BorderPane.setAlignment(tilbakeKnapp, Pos.BOTTOM_RIGHT);
        valg4Scene = new Scene(rootValg4, 640, 480);
        primaryStage.setScene(valg4Scene);
    }

    //Oppretter lagrefunksjonen til lagraKnapp:
    public void behandlerLagre() {
        System.out.println("Lagre-knapp trykket");
    }




    public static void main(String[] args) {
        launch();
    }
}