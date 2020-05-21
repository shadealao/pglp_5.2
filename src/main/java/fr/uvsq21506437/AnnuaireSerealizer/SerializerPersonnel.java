package fr.uvsq21506437.AnnuaireSerealizer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerializerPersonnel implements Groupe {
	ObjectOutputStream oos = null;
	 ObjectInputStream ois = null;

	public void serealizerobjet(Groupe g) {
		try {
			final FileOutputStream fichier = new FileOutputStream("groupe.ser");
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

	public Groupe readserealizerobjet(Groupe g) {
		 try {
		      final FileInputStream fichier = new FileInputStream("groupe.ser");
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
	public void affiche() {
		// TODO Auto-generated method stub

	}

	@Override
	public String Service() {
		// TODO Auto-generated method stub
		return null;
	}

}
