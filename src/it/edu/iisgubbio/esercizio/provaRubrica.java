package it.edu.iisgubbio.esercizio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;

public class provaRubrica extends Application{

	ArrayList<Contatto> dati=new ArrayList<>();
	ListView <String>lista=new ListView<>();
	TextField tfNome =new TextField();
	TextField tfCognome =new TextField();
	TextField tfNumero =new TextField();

	public void start(Stage finestra) throws Exception {
		Label lNome =new Label("nome");
		Label lCognome =new Label("cognome");
		Label lNumero =new Label("numero");
		Button bAggiungi=new Button("aggiungi");

		GridPane griglia = new GridPane();

		griglia.add(lNome, 0, 0);
		griglia.add(tfNome, 1, 0);
		griglia.add(lCognome, 0, 1);
		griglia.add(tfCognome, 1, 1);
		griglia.add(lNumero, 0, 2);
		griglia.add(tfNumero, 1, 2);
		griglia.add(bAggiungi, 0, 3);
		griglia.add(lista, 0, 4);


		griglia.setVgap(20);
		griglia.setHgap(10);
		griglia.setPadding(new Insets(30,30,30,30));

		Scene scena = new Scene(griglia);

		finestra.setTitle("Magazzino");
		finestra.setScene(scena);
		finestra.show();

		FileReader flussoCaratteri;
		try {
			flussoCaratteri = new FileReader("ProgettoInformatica/src/it/edu/iisgubbio/esercizio/rubrica.csv");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
			String rigaLetta;


			do {
				rigaLetta = lettoreDiRighe.readLine();
				if(rigaLetta!=null) {

					dati.add(new Contatto(rigaLetta));

				}

			}while(rigaLetta!=null);

			lettoreDiRighe.close();
			flussoCaratteri.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bAggiungi.setOnAction(e -> aggiungi());

	}

	public void aggiungi() {
		String codice=tfNome.getText();
		String descrizione=tfCognome.getText();
		String taglia=tfNumero.getText();
		
		
		
		FileWriter flussoCaratteri;
		
		
		try {
			flussoCaratteri = new FileWriter("ProgettoInformatica/src/it/edu/iisgubbio/esercizio/rubrica.csv", true);
			flussoCaratteri.write(codice+";"+descrizione+";"+taglia+"\n");
			flussoCaratteri.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	public static void main(String[] args) {
		launch(args);
	}

}