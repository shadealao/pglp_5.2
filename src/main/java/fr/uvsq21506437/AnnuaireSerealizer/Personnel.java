package fr.uvsq21506437.AnnuaireSerealizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class Personnel extends DAO<Groupe> implements Groupe , Iterable,  Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	ArrayList<Groupe> liste = new ArrayList<Groupe>();
	private final String nom;
	private final String prenom;
	private String fonction;
	private final LocalDate birth;
	private HashMap<String, String > telephones = new HashMap<String, String>();
	
	public HashMap<String, String> getTelephones() {
		return telephones;
	}

	public void setTelephones(HashMap<String, String> telephones) {
		this.telephones = telephones;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	
	public Personnel(String nom, String prenom, String fonction, LocalDate birth, HashMap<String, String> telephones) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.birth = birth;
		this.telephones = telephones;
	}

	public static class  Builder {
		private final String nom;
		private final String prenom;
		private LocalDate birth;
		private HashMap<String, String > telephones = new HashMap<String, String>();
		//private ArrayList <String> fonction = new ArrayList<String>();
		private String fonction;
		
		public Builder(String nom, String prenom) {
			this.nom = nom;
			this.prenom = prenom;
		}
		
		public Builder addFonction(String fonction) {
			this.fonction = fonction;
			return this;
		}
		
		public Builder Birth(LocalDate birth) {
			this.birth = birth;
			return this;
		}
		
		public Builder Tel(HashMap<String, String >  telephones) {
			this.telephones = telephones;
			return this;
		}
		
		public Personnel build() {
			return new Personnel(this);
		}
	}
	
	public Personnel(Builder builder) {
		this.nom = builder.nom;
		this.prenom = builder.prenom;
		this.fonction = builder.fonction;
		this.birth = builder.birth;
		this.telephones = builder.telephones;
	}
	
	public void affiche() {
		String info = "Nom : "+ this.nom +"\tPérnom: "+this.prenom + "\tFonction : "+ this.fonction + "\tAnniversaire : "+ this.birth + "\n";
		String tel = "Contacts : \n";
		if (! telephones.isEmpty()) {
			for ( String key : telephones.keySet() ) {
				tel += "\tnom : "+ key + " N° : "+ telephones.get(key) + "\n";
			}
		}
		info += tel;
		System.out.println(info);
		
	}
	
	public String getFonction() {
		return this.fonction;
	}

	@Override
	public String Service() {
		return this.fonction;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void serealizerobjet(Groupe g) {
		try {
			final FileOutputStream fichier = new FileOutputStream(g.getNom()+".ser");
			oos = new ObjectOutputStream(fichier);
			oos.writeObject(g);
			oos.flush();
		} catch (final java.io.IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.flush();
					oos.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public Groupe readserealizerobjet(String nom) {
		Groupe g = null;
		try {
			final FileInputStream fichier = new FileInputStream(nom+".ser");
			ois = new ObjectInputStream(fichier);
			g = (Groupe) ois.readObject();
			System.out.println("Personne : ");
			g.affiche();
		} catch (final java.io.IOException e) {
			e.printStackTrace();
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}
		return g;
	}

	@Override
	public Groupe create(Groupe obj) {
		liste.add(obj);
		this.serealizerobjet(obj);
		return obj;
	}

	@Override
	public Groupe update(Groupe obj) {
		return obj;
	}

	@Override
	public void delete(Groupe obj) {
		liste.remove(obj);
		final String chemin = System.getProperty("user.dir") + "\\" + obj.getNom() + ".ser";
		ObjectInputStream reader = null;
		File file = new File(chemin);
		file.delete();
	}

	@Override
	public Groupe read(String nom) {
		for (Groupe a : liste) {
			if (a.getNom().equals(nom)) {
				return a;
			}
		}
		Groupe grp = this.readserealizerobjet(nom);
		return grp;
	}

	
	
}

