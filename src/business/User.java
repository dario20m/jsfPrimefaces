package business;

import java.sql.Date;


public class User {

	private int id;
	private String nome;
	private String cognome;
	private Date datanascita;

	public User(int id, String nome, String cognome, Date date) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.datanascita = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDatanascita() {
		return datanascita;
	}

	public void setDatanascita(Date datanascita) {
		this.datanascita = datanascita;
	}

}
