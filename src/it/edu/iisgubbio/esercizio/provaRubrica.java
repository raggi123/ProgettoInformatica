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
	TextField tfRicerca =new TextField();

	public void start(Stage finestra) throws Exception {
		Label lNome =new Label("nome");
		Label lCognome =new Label("cognome");
		Label lNumero =new Label("numero");
		Button bAggiungi=new Button("aggiungi");
		Button bRimuovi=new Button("rimuovi");
		Label lRicerca =new Label("ricerca");

		GridPane griglia = new GridPane();

		griglia.add(lNome, 0, 0);
		griglia.add(tfNome, 1, 0);
		griglia.add(lCognome, 0, 1);
		griglia.add(tfCognome, 1, 1);
		griglia.add(lNumero, 0, 2);
		griglia.add(tfNumero, 1, 2);
		griglia.add(bAggiungi, 0, 3);
		griglia.add(bRimuovi, 1, 3);
		griglia.add(lRicerca, 0, 4);
		griglia.add(tfRicerca, 1, 4);
		griglia.add(lista, 0, 5);


		griglia.setVgap(20);
		griglia.setHgap(10);
		griglia.setPadding(new Insets(30,30,30,30));

		Scene scena = new Scene(griglia);

		finestra.setTitle("RUBRICA TELEFONICA");
		finestra.setScene(scena);
		finestra.show();

		FileReader flussoCaratteri;
		try {
			flussoCaratteri = new FileReader("/Users/raggi/Desktop/rubrica.csv");
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
		bRimuovi.setOnAction(e -> rimuovi());
		tfRicerca.setOnAction(e -> ricerca());

		for(int i=0 ; i<dati.size(); i++ ) {
			lista.getItems().add(dati.get(i).nome+" "+dati.get(i).cognome+" "+dati.get(i).numeroTelefono);

		}

	}


	public void aggiungi() {
		String nome=tfNome.getText();
		String cognome=tfCognome.getText();
		String numero=tfNumero.getText();

		FileWriter flussoCaratteri;


		try {
			flussoCaratteri = new FileWriter("/Users/raggi/Desktop/rubrica.csv", true);
			flussoCaratteri.write("\n"+nome+";"+cognome+";"+numero);
			flussoCaratteri.close();
			lista.getItems().add(nome+" "+cognome+" "+numero);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void rimuovi() {
		
		
	}
	
	public void ricerca() {
	    
	    lista.getItems().clear(); 
	    String nomeRicercato = tfRicerca.getText();
	    boolean trovato = false;
	    
	    	
	    //devo mettere che se il tf della ricerca è 0 rimette tutti i contatti
	    //da fare
	    
	    
	    for(int i = 0; i < dati.size(); i++) {
	        
	        if(nomeRicercato.equalsIgnoreCase(dati.get(i).nome)) {
	            trovato = true;
	        } else {
	            trovato = false;
	        }
	        if(trovato==true) {
	            Contatto contatto = dati.get(i);
	            lista.getItems().add(contatto.nome + " " + contatto.cognome + " " + contatto.numeroTelefono);
	        } 
	    }
	}
	
	
	



	public static void main(String[] args) {
		launch(args);
	}

}