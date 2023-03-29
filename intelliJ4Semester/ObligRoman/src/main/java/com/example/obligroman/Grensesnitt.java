package com.example.obligroman;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Grensesnitt extends Application {
    //DEFINERER MENYEN:
    MenuBar navbar = new MenuBar();
    Button tilbake = new Button("Tilbake");
    Menu filMeny = new Menu("Filmeny");
    Menu redigerMeny = new Menu("Rediger");
    MenuItem lagreItem = new MenuItem("Lagre");
    MenuItem leseItem = new MenuItem("Lese");
    MenuItem nyVareItem = new MenuItem("Ny vare");
    MenuItem finnVareItem = new MenuItem("Finn vare");
    MenuItem lagFakturaItem = new MenuItem("Lag faktura");
    MenuItem kontaktItem = new MenuItem("Kontakt med kunde");

    //DEFINERER SCENER:
    private Scene primaerscene, leseScene, lagreScene, nyVareScene, finnVareScene, lagFakturaScene, kontaktScene;
    private Stage primaerStage;
    @Override
    public void start(Stage primaerStage) throws IOException {
        this.primaerStage = primaerStage;
        BorderPane root = new BorderPane();
        Label infotekst = new Label("Velkommen til hjemmesiden til Oblig 2");
        //Lager menyene:
        filMeny.getItems().addAll(lagreItem, leseItem);
        redigerMeny.getItems().addAll(nyVareItem, finnVareItem, lagFakturaItem, kontaktItem);
        //Legger ItemMenyene til navbaren:
        navbar.getMenus().add(filMeny);
        navbar.getMenus().add(redigerMeny);
        //Angir positionen til navbaren:
        root.setTop(navbar);
        root.setCenter(infotekst);
        //Angir hva som skal skje når man trykker på menyene:
        lagreItem.setOnAction(e -> behandlerLagreItem());
        leseItem.setOnAction(e -> behandlerLeseItem());
        nyVareItem.setOnAction(e -> behandlerNyVareItem());
        finnVareItem.setOnAction(e -> behandlerFinnVareItem());
        lagFakturaItem.setOnAction(e -> behandlerLagFakturaItem());
        kontaktItem.setOnAction(e -> behandlerKontaktItem());
        //Angir primærscenen:
        primaerscene = new Scene(root, 320, 240);
        primaerStage.setTitle("Homepage");
        primaerStage.setScene(primaerscene);
        primaerStage.show();
        //Avslutt knappen:
        Button avslutt = new Button("Avslutt");
        avslutt.setOnAction(e -> System.exit(0));
        root.setBottom(avslutt);
        BorderPane.setAlignment(avslutt, Pos.BOTTOM_RIGHT);
    }

    public void behandlerLagreItem() {
        Label lagreLabel = new Label("Lagre");
        tilbake = new Button("Tilbake");
        tilbake.setOnAction(e -> primaerStage.setScene(primaerscene));
        BorderPane lagreP = new BorderPane();
        lagreP.setCenter(lagreLabel);
        lagreP.setBottom(tilbake);
        BorderPane.setAlignment(tilbake, Pos.BOTTOM_RIGHT);
        lagreScene = new Scene(lagreP, 320, 240);
        primaerStage.setScene(lagreScene);

    }

    public void behandlerLeseItem() {
        Label leseLabel = new Label("Lese");
        tilbake = new Button("Tilbake");
        tilbake.setOnAction(e -> primaerStage.setScene(primaerscene));
        BorderPane leseP = new BorderPane();
        leseP.setCenter(leseLabel);
        leseP.setBottom(tilbake);
        BorderPane.setAlignment(tilbake, Pos.BOTTOM_RIGHT);
        leseScene = new Scene(leseP, 320, 240);
        primaerStage.setScene(leseScene);
    }

    public void behandlerNyVareItem() {
        Label nyVareLabel = new Label("Ny vare");
        tilbake = new Button("Tilbake");
        tilbake.setOnAction(e -> primaerStage.setScene(primaerscene));
        BorderPane nyVareP = new BorderPane();
        nyVareP.setCenter(nyVareLabel);
        nyVareP.setBottom(tilbake);
        BorderPane.setAlignment(tilbake, Pos.BOTTOM_RIGHT);
        nyVareScene = new Scene(nyVareP, 320, 240);
        primaerStage.setScene(nyVareScene);
    }

    public void behandlerFinnVareItem() {
        Label finnVareLabel = new Label("Finn vare");
        tilbake = new Button("Tilbake");
        tilbake.setOnAction(e -> primaerStage.setScene(primaerscene));
        BorderPane finnVareP = new BorderPane();
        finnVareP.setCenter(finnVareLabel);
        finnVareP.setBottom(tilbake);
        BorderPane.setAlignment(tilbake, Pos.BOTTOM_RIGHT);
        finnVareScene = new Scene(finnVareP, 320, 240);
        primaerStage.setScene(finnVareScene);
    }

    public void behandlerLagFakturaItem() {
        Label lagFakturaLabel = new Label("Lag faktura");
        tilbake = new Button("Tilbake");
        tilbake.setOnAction(e -> primaerStage.setScene(primaerscene));
        BorderPane lagFakturaP = new BorderPane();
        lagFakturaP.setCenter(lagFakturaLabel);
        lagFakturaP.setBottom(tilbake);
        BorderPane.setAlignment(tilbake, Pos.BOTTOM_RIGHT);
        lagFakturaScene = new Scene(lagFakturaP, 320, 240);
        primaerStage.setScene(lagFakturaScene);
    }

    public void behandlerKontaktItem() {
        Label kontaktLabel = new Label("Kontakt med kunde");
        tilbake = new Button("Tilbake");
        tilbake.setOnAction(e -> primaerStage.setScene(primaerscene));
        BorderPane kontaktP = new BorderPane();
        kontaktP.setCenter(kontaktLabel);
        kontaktP.setBottom(tilbake);
        BorderPane.setAlignment(tilbake, Pos.BOTTOM_RIGHT);
        kontaktScene = new Scene(kontaktP, 320, 240);
        primaerStage.setScene(kontaktScene);
    }

    public static void main(String[] args) {
        launch();
    }
}