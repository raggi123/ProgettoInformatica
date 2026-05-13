package it.edu.iisgubbio.esercizio;

public class Contatto {
	
	String nome;
	String cognome;
	String numeroTelefono;
	
	public Contatto(String riga) {
		String[] pezzi = riga.split(",");
		this.nome = pezzi[0];
		this.cognome = pezzi[1];
		this.numeroTelefono = pezzi[2];
		
	}

	@Override
	public String toString() {
		return "Contatto [nome=" + nome + ", cognome=" + cognome + ", numeroTelefono=" + numeroTelefono + "]";
	}
	
	

}
