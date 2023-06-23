package grensesnitt;
	
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domeneklasser.Faktura;
import domeneklasser.Fakturalinje;
import domeneklasser.Firmakunde;
import domeneklasser.Kunde;
import domeneklasser.Kundekontakt;
import domeneklasser.Privatkunde;
import domeneklasser.Vare;
import hjelpeklasser.Filbehandling;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Callback;
import kontroll.Kontroll;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
//Jeg testa noe - om jeg glemte å fjerne disse importene.
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Main extends Application {
	String filnavnVare = "varefil.txt";
	String filnavnFirmakunde = "firmakundefil.txt";
	String filnavnPrivatkunde = "privatkundefil.txt";
	String filnavnKunde = "kundefil.txt";
	String filnavnKontakt = "kundekontakt.txt";
	String filnavnLinje = "fakturalinje.txt";
	String filnavnFaktura = "faktura.txt";
	Kontroll kontroll = new Kontroll();

	MenuBar menylinje = new MenuBar();
	Menu kundeMeny = new Menu ("Kunde");
	Menu vareMeny = new Menu("Varer");
	Menu fakturaMeny = new Menu("Faktura");
	Menu kontakterMeny = new Menu("Kontakt");
	//Menu lister = new Menu("Lister");
	//MenuItem finnKunde = new MenuItem("Finn kunde");
	MenuItem privatKunde = new MenuItem("Ny privatkunde");
	MenuItem firmaKunde = new MenuItem("Ny firmakunde");
	MenuItem alleKunder = new MenuItem("Vis alle kunder");
	//MenuItem nyVare = new MenuItem("Ny Vare");
	//MenuItem finnVare = new MenuItem("Finn vare");
	MenuItem alleVarer = new MenuItem("Alle varer");
	MenuItem lagFaktura = new MenuItem("Lag faktura");
	MenuItem utskriftFaktura = new MenuItem("Faktura utskrift");
	MenuItem kundeKontakt = new MenuItem("Kontakter");
	//MenuItem vareList = new MenuItem("Varer");
	private Stage primaryStage;
	private Scene hovedmeny,sceneNyVare,sceneNyFirmakunde,sceneNyPrivatkunde,sceneNyKontakt,sceneNyFakturalinje,sceneFaktura;
	/*sceneNyKundekontakt,sceneAlleVarer*/
	private TableView tabell = new TableView<>();

	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			BorderPane root = new BorderPane();
			//lager meny
			kundeMeny.getItems().addAll(/*finnKunde,*/ privatKunde, firmaKunde, alleKunder);
			vareMeny.getItems().addAll(/*nyVare, finnVare,*/ alleVarer);
			fakturaMeny.getItems().addAll(lagFaktura, utskriftFaktura);
			kontakterMeny.getItems().addAll(kundeKontakt);
			//lister.getItems().addAll(vareList);
			//Legger menyen i linja
			menylinje.getMenus().addAll(kundeMeny, vareMeny, fakturaMeny, kontakterMeny/*, lister*/);
			//Valg til lytter:
			//finnKunde.setOnAction(e -> behandleFinnKunde());
			privatKunde.setOnAction(e -> behandlePrivatkunde());
			firmaKunde.setOnAction(e -> behandleFirmakunde());
			alleKunder.setOnAction(e -> behandleAlleKunder());
			//nyVare.setOnAction(e -> behandleNyVare());
			//finnVare.setOnAction(e -> behandleFinnVare());
			alleVarer.setOnAction(e -> behandleAlleVarer());
			lagFaktura.setOnAction(e -> behandleLagFaktura());
			utskriftFaktura.setOnAction(e -> behandleUtskriftFaktura());
			kundeKontakt.setOnAction(e -> behandleKontakt());
			//vareList.setOnAction(e -> behandleVareListen());
			
			
			//FJERN DENNE!
			//String path = "file:///C:/Users/danie/Pictures/bilde";
			//Image image = new Image(path);
			//ImageView imageView = new ImageView(image);
			//FJERN DENNE!
			
			
			root.setTop(menylinje);
			Label labelScene = new Label ("Velkommen til Daniel sitt program :) \n Dette er vår fantastiske hovedmeny!");
			Button terminer = new Button ("Avslutt program");
			terminer.setOnAction(e -> primaryStage.close());
			root.setCenter(labelScene);
			root.setBottom(terminer);
			BorderPane.setAlignment(terminer, Pos.BOTTOM_CENTER);
			
			//FJERN DENNE!
			//root.setRight(imageView);
			//FJERN DENNE!
			
			hovedmeny = new Scene(root,800,800);
			hovedmeny.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(hovedmeny);
			primaryStage.setTitle("Hovedmeny");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Kunde Start
	private void behandleFinnKunde() {
		Label labelScene = new Label("Finn Kunde");
		Button tilbake = new Button("Tilbake");
		tilbake.setOnAction(e -> primaryStage.setScene(hovedmeny));
		BorderPane rootFinnKunde = new BorderPane();
		rootFinnKunde.setCenter(labelScene);
		rootFinnKunde.setBottom(tilbake);
		BorderPane.setAlignment(tilbake, Pos.BOTTOM_RIGHT);
		Scene sceneFinnKunde = new Scene(rootFinnKunde,400,400);
		primaryStage.setTitle("Finn kunde");
		primaryStage.setScene(sceneFinnKunde);
	}
	
	private void behandlePrivatkunde() {
		BorderPane rootPrivatkunde = new BorderPane();
		Scene scenePrivatkunde = new Scene(rootPrivatkunde,400,400);
		primaryStage.setTitle("Privatkunde");
		tabell = new TableView();
		TableColumn colKundenr = new TableColumn("Kundenr");
		colKundenr.setMinWidth(100);
		colKundenr.setCellValueFactory(new PropertyValueFactory<Privatkunde, String>("kundenummer"));
		TableColumn colKundenavn = new TableColumn("Kundenavn");
		colKundenavn.setMinWidth(100);
		colKundenavn.setCellValueFactory(new PropertyValueFactory<Privatkunde, String>("kundenavn"));
		TableColumn colKundebutikk = new TableColumn("Butikk");
		colKundebutikk.setMinWidth(100);
		colKundebutikk.setCellValueFactory(new PropertyValueFactory<Privatkunde, String>("butikk"));
		nyPrivatkundeScene();
		Button tilbake = new Button("Tilbake");
		Button btnNyPrivatkunde = new Button("Ny privatkunde");
		btnNyPrivatkunde.setOnAction(e -> primaryStage.setScene(sceneNyPrivatkunde));
		tilbake.setOnAction(e -> primaryStage.setScene(hovedmeny));
		tabell.getColumns().addAll(colKundenr,colKundenavn,colKundebutikk);
		ObservableList privatkundeData = FXCollections.observableArrayList(kontroll.lesPrivatkundeData(filnavnPrivatkunde));
		tabell.setItems(privatkundeData);
		rootPrivatkunde.setBottom(tilbake);
		rootPrivatkunde.setTop(btnNyPrivatkunde);
		rootPrivatkunde.setCenter(tabell);
		BorderPane.setAlignment(tilbake,Pos.BOTTOM_RIGHT);
		BorderPane.setAlignment(btnNyPrivatkunde, Pos.TOP_LEFT);
		primaryStage.setScene(scenePrivatkunde);
	}
	
	private void nyPrivatkundeScene() {
		GridPane layout = new GridPane();
		sceneNyPrivatkunde = new Scene(layout,400,300);
		Button registrerPrivatkunde = new Button("Registrer");
		Button tilbake = new Button("Tilbake");
		Label lblKundenr = new Label("Kundenr");
		Label lblKundenavn = new Label("Navn");
		Label lblKundebutikk = new Label("Butikk");
		
		TextField txtKundenr = new TextField();
		TextField txtKundenavn = new TextField();
		TextField txtKundebutikk = new TextField();
		
		layout.add(lblKundenr, 0, 0);
		layout.add(lblKundenavn, 0, 1);
		layout.add(lblKundebutikk, 0, 2);
		layout.add(txtKundenr, 1, 0);
		layout.add(txtKundenavn, 1, 1);
		layout.add(txtKundebutikk, 1, 2);
		layout.add(registrerPrivatkunde, 2, 3);
		layout.add(tilbake, 2, 4);
		
		tilbake.setOnAction(e -> primaryStage.setScene(hovedmeny));
		registrerPrivatkunde.setOnAction(e ->{
			String kundenr = txtKundenr.getText();
			String kundenavn = txtKundenavn.getText();
			String kundebutikk = txtKundebutikk.getText();
			Privatkunde privatkunde = new Privatkunde(kundenr,kundenavn,kundebutikk);
			kontroll.nyPrivatkunde(kundenr, privatkunde);
			//kontroll.nyKunde(kundenr, privatkunde);
			kontroll.skrivDataPrivatkunde(filnavnPrivatkunde);
			//kontroll.skrivDataKunde(filnavnKunde);
	        kontroll.removePrivatkundeDataArray();
	        kontroll.removePrivatkundeDataHash();
	        //kontroll.removeKundeDataArray();
	        //kontroll.removeKundeHash();
	        behandlePrivatkunde();
		});
		primaryStage.setTitle("Ny Privatkunde");
		primaryStage.setScene(sceneNyPrivatkunde);
		
	}
	
	private void behandleFirmakunde() {
		BorderPane rootFirmakunde = new BorderPane();
		Scene sceneFirmakunder = new Scene(rootFirmakunde,400,400);
		primaryStage.setTitle("Firmakunde");
		tabell = new TableView();
		TableColumn colKundenr = new TableColumn("Kundenr");
		colKundenr.setMinWidth(100);
		colKundenr.setCellValueFactory(new PropertyValueFactory<Firmakunde, String>("kundenummer"));
		TableColumn colKundenavn = new TableColumn("Kundenavn");
		colKundenavn.setMinWidth(100);
		colKundenavn.setCellValueFactory(new PropertyValueFactory<Firmakunde, String>("kundenavn"));
		TableColumn colKreditt = new TableColumn("Kredittgrense");
		colKreditt.setMinWidth(100);
		colKreditt.setCellValueFactory(new PropertyValueFactory<Firmakunde, String>("kredittgrense"));
		TableColumn colTlf = new TableColumn("Telefonnummer");
		colTlf.setMinWidth(100);
		colTlf.setCellValueFactory(new PropertyValueFactory<Firmakunde, String>("telefonnummer"));
		nyFirmakundeScene();
		Button tilbake = new Button("Tilbake");
		Button btnNyFirmakunde = new Button("Ny firmakunde");
		btnNyFirmakunde.setOnAction(e -> primaryStage.setScene(sceneNyFirmakunde));
		tilbake.setOnAction(e -> primaryStage.setScene(hovedmeny));
		tabell.getColumns().addAll(colKundenr,colKundenavn,colKreditt,colTlf);
		ObservableList firmakundeData = FXCollections.observableArrayList(kontroll.lesFirmakundeData(filnavnFirmakunde));
		tabell.setItems(firmakundeData);
		System.out.println(firmakundeData);
		rootFirmakunde.setBottom(tilbake);
		rootFirmakunde.setTop(btnNyFirmakunde);
		rootFirmakunde.setCenter(tabell);
		BorderPane.setAlignment(tilbake, Pos.BOTTOM_RIGHT);
		BorderPane.setAlignment(btnNyFirmakunde, Pos.TOP_LEFT);
		primaryStage.setScene(sceneFirmakunder);
	}
	private void nyFirmakundeScene () {
		GridPane layout = new GridPane();
		sceneNyFirmakunde = new Scene(layout,400,300);
		Button registrerFirmakunde = new Button("Registrer");
		Button tilbake = new Button("Tilbake");
		Label lblKundenr = new Label("Kundenr");
		Label lblKundenavn = new Label("Navn");
		Label lblKundekreditt = new Label("Kredittgrense");
		Label lblKundetlf = new Label("Telefonnummer");
		
		TextField txtKundenr = new TextField();
		TextField txtKundenavn = new TextField();
		TextField txtKundekreditt = new TextField();
		TextField txtKundetlf = new TextField();
		
		
		layout.add(lblKundenr, 0, 0);
		layout.add(lblKundenavn, 0, 1);
		layout.add(lblKundekreditt, 0, 2);
		layout.add(lblKundetlf, 0, 3);
		layout.add(txtKundenr, 1, 0);
		layout.add(txtKundenavn, 1, 1);
		layout.add(txtKundekreditt, 1, 2);
		layout.add(txtKundetlf, 1, 3);
		layout.add(registrerFirmakunde, 2, 3);
		layout.add(tilbake, 2, 4);
		
		tilbake.setOnAction(e -> primaryStage.setScene(hovedmeny));
		registrerFirmakunde.setOnAction(e ->{
			String kundenr = txtKundenr.getText();
			String kundenavn = txtKundenavn.getText();
			String kundekreditt = txtKundekreditt.getText();
			String kundetlf = txtKundetlf.getText();
			Firmakunde firmakunde = new Firmakunde(kundenr,kundenavn,kundekreditt,kundetlf);
			kontroll.nyFirmakunde(kundenr, firmakunde);
			//kontroll.nyKunde(kundenr, firmakunde);
			kontroll.skrivDataFirmakunde(filnavnFirmakunde);
			//kontroll.skrivDataKunde(filnavnKunde);
	        kontroll.removeFirmakundeDataArray();
	        kontroll.removeFirmakundeDataHash();
	        //kontroll.removeKundeDataArray();
	        //kontroll.removeKundeHash();
	        behandleFirmakunde();
		});
		primaryStage.setTitle("Ny Firmakunde");
		primaryStage.setScene(sceneNyFirmakunde);

	}
	
	private void behandleAlleKunder() {
		kontroll.removeKundeDataArray();
		kontroll.lesAlleKunder();
		BorderPane rootKunde = new BorderPane();
		Scene sceneKunder = new Scene(rootKunde,600,500);
		primaryStage.setTitle("Alle Kunder");
		tabell = new TableView();
		TableColumn colKundenr = new TableColumn("Kundenr");
		colKundenr.setMinWidth(100);
		colKundenr.setCellValueFactory(new PropertyValueFactory<Kunde, String>("kundenummer"));
		TableColumn colKundenavn = new TableColumn("Kundenavn");
		colKundenavn.setMinWidth(100);
		colKundenavn.setCellValueFactory(new PropertyValueFactory<Kunde, String>("kundenavn"));
		TableColumn colKreditt = new TableColumn("Kredittgrense");
		colKreditt.setMinWidth(100);
		colKreditt.setCellValueFactory(new PropertyValueFactory<Kunde, String>("kredittgrense"));
		TableColumn colTlf = new TableColumn("Telefonnummer");
		colTlf.setMinWidth(100);
		colTlf.setCellValueFactory(new PropertyValueFactory<Kunde, String>("telefonnummer"));
		TableColumn colButikk = new TableColumn("Butikk");
		colButikk.setMinWidth(100);
		colButikk.setCellValueFactory(new PropertyValueFactory<Kunde, String>("butikk"));
		Button tilbake = new Button("Tilbake");
		tilbake.setOnAction(e -> primaryStage.setScene(hovedmeny));
		tabell.getColumns().addAll(colKundenr,colKundenavn,colKreditt,colTlf,colButikk);
		//Fungerer men viser ikke alle kunder, kun firmakunder for nå.
		ObservableList kundeData = FXCollections.observableArrayList(kontroll.getKunde());
		tabell.setItems(kundeData);
		rootKunde.setBottom(tilbake);
		rootKunde.setCenter(tabell);
		BorderPane.setAlignment(tilbake, Pos.BOTTOM_RIGHT);
		primaryStage.setScene(sceneKunder);
		
		
	}
	//Kunde Slutt
	//Vare Start
	public void nyVareScene() {
	    GridPane layout = new GridPane();
	    sceneNyVare = new Scene(layout, 400, 300);
	    Button registrerVare = new Button("Registrer");
	    Button tilbake = new Button("Tilbake");
	    Label lblVarenr = new Label("Varenr: ");
	    Label lblVareNavn = new Label("Varenavn: ");
	    Label lblVarePris = new Label("Pris: ");
	    TextField txtVarenr = new TextField();
	    TextField txtVareNavn = new TextField();
	    TextField txtVarePris = new TextField();

	    layout.add(lblVarenr, 0, 0);
	    layout.add(lblVareNavn, 0, 1);
	    layout.add(lblVarePris, 0, 2);
	    layout.add(txtVarenr, 1, 0);
	    layout.add(txtVareNavn, 1, 1);
	    layout.add(txtVarePris, 1, 2);
	    layout.add(registrerVare, 2, 3);
	    layout.add(tilbake, 2, 4);

	    tilbake.setOnAction(e -> primaryStage.setScene(hovedmeny));
	    registrerVare.setOnAction(e -> {
	        String varenr = txtVarenr.getText();
	        String varenavn = txtVareNavn.getText();
	        String varepris = txtVarePris.getText();

	        Vare vare = new Vare(varenr, varenavn, varepris);
	        kontroll.nyVare(varepris, vare);
	        kontroll.skrivData(filnavnVare);
	        kontroll.removeDataArray();
	        kontroll.removeDataTree();
	        behandleAlleVarer();
	        System.out.println("test");
	    });
	    primaryStage.setTitle("Ny Vare");
	    primaryStage.setScene(sceneNyVare);
	}

	private void behandleVareListen() { //DU MÅ JO WIPE .txt FILA..
		BorderPane rootVareListen = new BorderPane();
		Scene sceneVareListen = new Scene(rootVareListen,400,400);
		Button tilbake = new Button("Tilbake");
		Button slettListen = new Button("!!Denne knappen sletter HELE varelisten!!");
		//slettListen.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		tilbake.setOnAction(e -> primaryStage.setScene(hovedmeny));
		slettListen.setOnAction(e -> kontroll.removeDataArray());
		rootVareListen.setBottom(tilbake);
		rootVareListen.setCenter(slettListen);
		BorderPane.setAlignment(tilbake, Pos.BOTTOM_RIGHT);
		primaryStage.setScene(sceneVareListen);
		
		
	}
	private void behandleAlleVarer() {
		BorderPane rootAlleVarer = new BorderPane();
		Scene sceneAlleVarer = new Scene(rootAlleVarer,400,400);
		primaryStage.setTitle("Alle varer");
		tabell = new TableView();
		TableColumn colVarenr = new TableColumn("Varenr");
		colVarenr.setMinWidth(100);
		colVarenr.setCellValueFactory(new PropertyValueFactory<Vare, String>("varenr"));
		TableColumn colVarenavn = new TableColumn("Varenavn");
		colVarenavn.setMinWidth(100);
		colVarenavn.setCellValueFactory(new PropertyValueFactory<Vare, String>("varenavn"));
		TableColumn colVarepris = new TableColumn("Varepris");
		colVarepris.setMinWidth(100);
		colVarepris.setCellValueFactory(new PropertyValueFactory<Vare, String>("varepris"));
		nyVareScene();
		Button tilbake = new Button("Tilbake");
		Button btnNyVare = new Button("Legg til Vare");
		btnNyVare.setOnAction(e -> primaryStage.setScene(sceneNyVare));
		tilbake.setOnAction(e -> primaryStage.setScene(hovedmeny));
		tabell.getColumns().addAll(colVarenr,colVarenavn,colVarepris);
		ObservableList data = FXCollections.observableArrayList(kontroll.lesData(filnavnVare));
		tabell.setItems(data);
		rootAlleVarer.setBottom(tilbake);
		rootAlleVarer.setTop(btnNyVare);
		rootAlleVarer.setCenter(tabell);
		BorderPane.setAlignment(tilbake, Pos.BOTTOM_RIGHT);
		BorderPane.setAlignment(btnNyVare,Pos.TOP_LEFT);
		btnNyVare.setStyle("-fx-background-color: Green; -fx-text-fill: white;");
		primaryStage.setScene(sceneAlleVarer);
		
	}
	//Vare slutt
	//Faktura start
	private void behandleLagFaktura() {
		kontroll.lesFakturalinje(filnavnLinje);
		kontroll.lesAlleKunder();
		
		GridPane layout = new GridPane();
		Scene sceneFaktura = new Scene(layout,1200,500);
		
		Label lblOrdrenr = new Label("Ordrenr");
		Label lblKundenr = new Label("Kundenr");
		Label lblKundenavn = new Label("Kundenavn");
		Label lblDato = new Label("Dato");
		Label lblForfall = new Label("Forfall");
		TextField txtOrdrenr = new TextField();
		TextField txtKundenr = new TextField();
		TextField txtKundenavn = new TextField();
		TextField txtDato = new TextField();
		TextField txtForfall = new TextField();
		txtKundenavn.setEditable(false);
		txtOrdrenr.setEditable(false);
		tabell = new TableView();
		//Denne koden kommenterer jeg i rapporten.
		TableColumn<Fakturalinje, String> colVarenr = new TableColumn<>("Varenummer");
		colVarenr.setMinWidth(100);
		colVarenr.setCellValueFactory(new Callback<CellDataFeatures<Fakturalinje, String>, ObservableValue<String>>() {
		    @Override
		    public ObservableValue<String> call(CellDataFeatures<Fakturalinje, String> cellData) {
		        return new SimpleStringProperty(cellData.getValue().getVare().getVarenr());
		    }
		});

		TableColumn<Fakturalinje, String> colVarenavn = new TableColumn<>("Varenavn");
		colVarenavn.setMinWidth(100);
		colVarenavn.setCellValueFactory(new Callback<CellDataFeatures<Fakturalinje, String>, ObservableValue<String>>() {
		    @Override
		    public ObservableValue<String> call(CellDataFeatures<Fakturalinje, String> cellData) {
		        return new SimpleStringProperty(cellData.getValue().getVare().getVarenavn());
		    }
		});
	
		TableColumn<Fakturalinje, String> colVarepris = new TableColumn<>("Varepris");
		colVarepris.setMinWidth(100);
		colVarepris.setCellValueFactory(new Callback<CellDataFeatures<Fakturalinje, String>, ObservableValue<String>>() {
		    @Override
		    public ObservableValue<String> call(CellDataFeatures<Fakturalinje, String> cellData) {
		        return new SimpleStringProperty(String.valueOf(cellData.getValue().getVare().getVarepris()));
		    }
		});
		
		//Slutt
		TableColumn colLinjeAntall = new TableColumn("Antall");
		colLinjeAntall.setMinWidth(100);
		colLinjeAntall.setCellValueFactory(new PropertyValueFactory<Fakturalinje, String>("antall"));
		TableColumn colLinjeRabatt = new TableColumn("Rabatt i %");
		colLinjeRabatt.setMinWidth(100);
		colLinjeRabatt.setCellValueFactory(new PropertyValueFactory<Fakturalinje, String>("rabatt"));
		TableColumn colLinjeTotal = new TableColumn("Totalpris");
		colLinjeTotal.setMinWidth(100);
		colLinjeTotal.setCellValueFactory(new PropertyValueFactory<Fakturalinje, String>("totallPris"));
		tabell.getColumns().addAll(colVarenr,colVarenavn,colVarepris,colLinjeAntall,colLinjeRabatt,colLinjeTotal);
		GridPane.setColumnSpan(tabell, 9);
		ObservableList data = FXCollections.observableArrayList(kontroll.lesFakturalinje(filnavnLinje));
		tabell.setItems(data);
		Button tilbake = new Button("Tilbake");
		Button sok = new Button("Søk kundenr");
		Button nyLinje = new Button("Ny fakturalinje");
		Button lagreFaktura = new Button("Lagre faktura");
		txtOrdrenr.setText(String.valueOf(kontroll.lesFaktura(filnavnFaktura).size()+1));
		
		layout.add(lblOrdrenr, 0, 0);
		layout.add(txtOrdrenr, 1, 0);
		layout.add(sok, 4, 0);
		layout.add(lblKundenr, 2, 0);
		layout.add(txtKundenr, 3, 0);
		layout.add(lblKundenavn, 5, 0);
		layout.add(txtKundenavn, 6, 0);
		layout.add(lblDato, 7, 0);
		layout.add(txtDato, 8, 0);
		layout.add(lblForfall, 9, 0);
		layout.add(txtForfall, 10, 0);
		layout.add(tabell, 0, 2);
		layout.add(tilbake, 8, 3);
		layout.add(nyLinje, 1, 3);
		layout.add(lagreFaktura, 10, 1);
		
		
		
		tilbake.setOnAction(e -> {
			Filbehandling.fjernText(filnavnLinje);
			primaryStage.setScene(hovedmeny);
		});
		sok.setOnAction(e -> { 
			Kunde kunde = kontroll.finnKunde(txtKundenr.getText());
			txtKundenavn.setText(kunde.getKundenavn());
			
		    });
		lagreFaktura.setOnAction(e -> {
			kontroll.lesFakturalinje(filnavnLinje);
			ArrayList<Fakturalinje> fakturalinjer = kontroll.getListLinja();
			
			for(int i=0;i<data.size();i++){
			    Fakturalinje fakturalinje = fakturalinjer.get(i);
			    Vare vare = fakturalinje.getVare();
			    String varenr = vare.getVarenr();
			    String varenavn = vare.getVarenavn();
			    String varepris = vare.getVarepris();
			    int linjeAntall = fakturalinje.getAntall();
			    float rabatt = fakturalinje.getRabatt();
			    float totallPris = fakturalinje.getTotallPris();
			    
			    vare = new Vare(varenr,varenavn,varepris);
			    fakturalinje = new Fakturalinje(vare, linjeAntall,rabatt,totallPris);
			    String kundenr = txtKundenr.getText();
			    String kundenavn = txtKundenavn.getText();
			    String fakturanr = txtOrdrenr.getText();
			    String dato = txtDato.getText();
			    String forfall = txtForfall.getText();
			    
			    Kunde kunde = new Kunde(kundenr,kundenavn);
			    int intFakturanr = Integer.parseInt(fakturanr);
			    Faktura faktura = new Faktura(intFakturanr, kunde,dato,forfall,fakturalinje);
			    kontroll.nyFaktura(faktura);
			    kontroll.skrivFakturaData(filnavnFaktura);
			    kontroll.removeFakturaData();
			    Filbehandling.fjernText(filnavnLinje);
			    txtOrdrenr.setText("");
			    txtKundenr.setText("");
			    txtKundenavn.setText("");
			    txtDato.setText("");
			    txtForfall.setText("");
			}
		});
		
		nyLinje.setOnAction(e -> {
			nyFakturalinje();
			
		});
		
		primaryStage.setTitle("Lag Faktura");
		primaryStage.setScene(sceneFaktura);
		
	}
	
	private void nyFakturalinje() {
		kontroll.lesData(filnavnVare);
		GridPane layout = new GridPane();
		Scene sceneNyFakturalinje = new Scene(layout,1100,500);
		Label lblLinjeVarenr = new Label("Varenummer");
		Label lblLinjeVarenavn = new Label("Varenavn");
		Label lblLinjeVarepris = new Label("Pris");
		Label lblLinjeAntall = new Label("Antall");
		Label lblLinjeRabatt = new Label("Rabatt i %");
		TextField txtLinjeVarenr = new TextField();
		TextField txtLinjeVarenavn = new TextField();
		TextField txtLinjeVarepris = new TextField();
		TextField txtLinjeAntall = new TextField();
		TextField txtLinjeRabatt = new TextField();
		txtLinjeVarenavn.setEditable(false);
		txtLinjeVarepris.setEditable(false);
		Button tilbake = new Button("Tilbake");
		Button sok = new Button("Søk Varenummer");
		Button btnNyLinje = new Button("Legg til linje");
		tabell = new TableView();
		GridPane.setColumnSpan(tabell, 6);
		
		primaryStage.setTitle("Fakturalinje");
		
		TableColumn colVarenr = new TableColumn("Varenr");
		colVarenr.setMinWidth(150);
		colVarenr.setCellValueFactory(new PropertyValueFactory<Vare, String>("varenr"));
		TableColumn colVarenavn = new TableColumn("Varenavn");
		colVarenavn.setMinWidth(150);
		colVarenavn.setCellValueFactory(new PropertyValueFactory<Vare, String>("varenavn"));
		TableColumn colVarepris = new TableColumn("Varepris");
		colVarepris.setMinWidth(150);
		colVarepris.setCellValueFactory(new PropertyValueFactory<Vare, String>("varepris"));
		
		
		btnNyLinje.setOnAction(e -> {
	        String varenr = txtLinjeVarenr.getText();
	        String varenavn = txtLinjeVarenavn.getText();
	        String varepris = txtLinjeVarepris.getText();
	        float regnepris = Float.parseFloat(varepris);
	        int intAntall = Integer.parseInt(txtLinjeAntall.getText());
	        float floatRabatt = Float.parseFloat(txtLinjeRabatt.getText());
	        float totalprisUten = regnepris * intAntall;
	        float floatTotRabatt = totalprisUten * floatRabatt/100;
	        float linjeTotalpris = totalprisUten - floatTotRabatt;
	        
	        Fakturalinje fakturalinje = new Fakturalinje(new Vare(varenr,varenavn,varepris), intAntall,floatRabatt,linjeTotalpris);
	        kontroll.nyFakturalinje(fakturalinje);
	        kontroll.skrivDataFakturalinje(filnavnLinje);
	        kontroll.lesFakturalinje(filnavnLinje);
	        txtLinjeVarenr.setText("");
	        txtLinjeVarenavn.setText("");
	        txtLinjeVarepris.setText("");
	        txtLinjeAntall.setText("");
	        txtLinjeRabatt.setText("");
			
			});
		tilbake.setOnAction(e -> {
			kontroll.lesFakturalinje(filnavnLinje);
			behandleLagFaktura();
		});
		
		tabell.getColumns().addAll(colVarenr,colVarenavn,colVarepris);
		ObservableList data = FXCollections.observableArrayList(kontroll.lesData(filnavnVare));
		tabell.setItems(data);
		
		layout.add(sok, 2, 0);
		layout.add(btnNyLinje, 10, 1);
		layout.add(lblLinjeVarenr, 0, 0);
		layout.add(txtLinjeVarenr, 1, 0);
		layout.add(lblLinjeVarenavn, 3, 0);
		layout.add(txtLinjeVarenavn, 4, 0);
		layout.add(lblLinjeVarepris, 5, 0);
		layout.add(txtLinjeVarepris, 6, 0);
		layout.add(lblLinjeAntall, 7, 0);
		layout.add(txtLinjeAntall, 8, 0);
		layout.add(lblLinjeRabatt, 9, 0);
		layout.add(txtLinjeRabatt, 10, 0);
		layout.add(tabell, 2, 2);
		layout.add(tilbake, 10, 3);
		
		
		sok.setOnAction(e -> { 
			Vare vare = kontroll.finnVare(txtLinjeVarenr.getText());
			txtLinjeVarenavn.setText(vare.getVarenr());
			txtLinjeVarepris.setText(vare.getVarepris());
			
		    });
		
		//nyVareScene();
		primaryStage.setScene(sceneNyFakturalinje);
		
	}
	
	private void behandleUtskriftFaktura() {
		Label labelScene = new Label("Utskrift Faktura");
		Button skrivUt = new Button("Skriv ut i konsollet");
		Button tilbake = new Button("Tilbake");
		tilbake.setOnAction(e -> primaryStage.setScene(hovedmeny));
		skrivUt.setOnAction(e -> {
		    kontroll.lesFaktura(filnavnFaktura);
		    for (int i = 0; i < kontroll.lesFaktura(filnavnFaktura).size(); i++) {
		        System.out.println(kontroll.lesFaktura(filnavnFaktura).get(i));
		    }
		});

		BorderPane rootUtskriftFaktura = new BorderPane();
		rootUtskriftFaktura.setCenter(skrivUt);
		rootUtskriftFaktura.setBottom(tilbake);
		BorderPane.setAlignment(tilbake, Pos.BOTTOM_RIGHT);
		Scene sceneUtskriftFaktura = new Scene(rootUtskriftFaktura,400,400);
		primaryStage.setTitle("Utskrift Faktura");
		primaryStage.setScene(sceneUtskriftFaktura);
	}
	//Faktura slutt
	//Kontakt start
	private void behandleKontakt() {
		BorderPane rootKontakt = new BorderPane();
		Scene sceneKontakt = new Scene(rootKontakt,400,400);
		primaryStage.setTitle("Kundekontakt");
		tabell = new TableView();
		TableColumn colKundenr = new TableColumn("Kundenummer");
		colKundenr.setMinWidth(100);
		colKundenr.setCellValueFactory(new PropertyValueFactory<Kundekontakt, String>("kundenummer"));
		TableColumn colDato = new TableColumn("Dato");
		colDato.setMinWidth(100);
		colDato.setCellValueFactory(new PropertyValueFactory<Kundekontakt, String>("dato"));
		TableColumn colMelding = new TableColumn("Melding");
		colMelding.setMinWidth(1000);
		colMelding.setCellValueFactory(new PropertyValueFactory<Kundekontakt, String>("kontakt"));
		Button tilbake = new Button("Tilbake");
		Button nyKontakt = new Button("Ny kundekontakt");
		nyKundekontakt();
		nyKontakt.setOnAction(e -> primaryStage.setScene(sceneNyKontakt));
		tilbake.setOnAction(e -> primaryStage.setScene(hovedmeny));
		tabell.getColumns().addAll(colKundenr,colDato,colMelding);
		ObservableList kundedata = FXCollections.observableArrayList(kontroll.lesKundekontakt(filnavnKontakt));
		tabell.setItems(kundedata);
		rootKontakt.setBottom(tilbake);
		rootKontakt.setTop(nyKontakt);
		rootKontakt.setCenter(tabell);
		BorderPane.setAlignment(tilbake, Pos.BOTTOM_RIGHT);
		BorderPane.setAlignment(nyKontakt, Pos.TOP_LEFT);
		primaryStage.setTitle("Kundekontakter");
		primaryStage.setScene(sceneKontakt);
		
	}
	
	private void nyKundekontakt() {
	    GridPane layout = new GridPane();
	    sceneNyKontakt = new Scene(layout, 400, 300);
	    Button registrerKontakt = new Button("Registrer");
	    Button tilbake = new Button("Tilbake");
	    Label lblKundenr = new Label("Kundenr ");
	    Label lblDato = new Label("Dato ");
	    Label lblKontakt = new Label("Tekst ");
	    TextField txtKundenr = new TextField();
	    TextField txtDato = new TextField();
	    TextField txtKontakt = new TextField();

	    layout.add(lblKundenr, 0, 0);
	    layout.add(lblDato, 0, 1);
	    layout.add(lblKontakt, 0, 2);
	    layout.add(txtKundenr, 1, 0);
	    layout.add(txtDato, 1, 1);
	    layout.add(txtKontakt, 1, 2);
	    layout.add(registrerKontakt, 2, 3);
	    layout.add(tilbake, 2, 4);

	    tilbake.setOnAction(e -> primaryStage.setScene(hovedmeny));
	    registrerKontakt.setOnAction(e -> {
	        String kundenr = txtKundenr.getText();
	        String dato = txtDato.getText();
	        String kontakt = txtKontakt.getText();

	        Kundekontakt kundekontakt = new Kundekontakt(kundenr, dato, kontakt);
	        kontroll.nyKontakt(kundenr, kundekontakt);
	        kontroll.skrivDataKontakt(filnavnKontakt);
	        kontroll.removeKontaktDataArray();
	        kontroll.removeKontaktDataTree();
	        behandleKontakt();
	    });
	    primaryStage.setTitle("Ny Kontakt");
	    primaryStage.setScene(sceneNyKontakt);
	}
		
	//Kontakt slutt
	public static void main(String[] args) {
		launch(args);	
	}
	
}
