package fr.uvsq21506437.AnnuaireSerealizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class SerializerPersonnel extends DAO<Groupe> implements Groupe, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	ArrayList<Groupe> liste = new ArrayList<Groupe>();

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

	@Override
	public void affiche() {
	}

	@Override
	public String Service() {
		return null;
	}

	@Override
	public String getNom() {
		return "";
	}

}
