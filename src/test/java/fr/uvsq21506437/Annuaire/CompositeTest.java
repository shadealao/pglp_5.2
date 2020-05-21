package fr.uvsq21506437.Annuaire;

import java.time.LocalDate;
import java.util.HashMap;

import fr.uvsq21506437.AnnuaireSerealizer.CompositeGroupe;
import fr.uvsq21506437.AnnuaireSerealizer.Personnel;
import junit.framework.TestCase;

public class CompositeTest extends TestCase {
	
	public void testComposite() {
		HashMap<String, String > telephones = new HashMap<String, String>();
    	telephones.put("alaoshade", "0708050999");
    	telephones.put("afolabiaweni", "0708440921");
        Personnel personnel = new Personnel.Builder("ALAO AFOLABI", "Shadé").addFonction("étuidante").Birth(LocalDate.of(1996, 8, 03)).Tel(telephones).build();
        
        HashMap<String, String > telephones1 = new HashMap<String, String>();
    	telephones.put("alaoshade", "0708050999");
    	telephones.put("afolabiaweni", "0708440921");
        Personnel personnel1 = new Personnel.Builder("CHANTE", "Mie").addFonction("étuidante").Birth(LocalDate.of(1996, 8, 03)).Tel(telephones).build();
        
        
        HashMap<String, String > telephones2 = new HashMap<String, String>();
    	telephones2.put("VideClem", "0715800999");
    	telephones2.put("dinadore", "0708464821");
        Personnel personnel2 = new Personnel.Builder("DURANT", "Julia").addFonction("Commercante").Birth(LocalDate.of(1960, 11, 15)).Tel(telephones2).build();
        
        HashMap<String, String > telephones3 = new HashMap<String, String>();
    	telephones3.put("delatorehelena", "068050949");
    	telephones3.put("MocheMartine", "0701540925");
        Personnel personnel3 = new Personnel.Builder("Yunes", "Rabiu").addFonction("PDG").Birth(LocalDate.of(1978, 4, 21)).Tel(telephones3).build();
        
        
        CompositeGroupe grp = new CompositeGroupe("entreprise");
        CompositeGroupe grp2 = new CompositeGroupe("Collaborateur");
        CompositeGroupe grp3 = new CompositeGroupe("directeur");
        
        grp2.add(personnel);
        grp2.add(personnel1);
        grp2.add(personnel2);
        grp3.add(personnel3);
        
        grp3.add(grp2);
        grp.add(grp3);
        
        //grp.affiche();
        
	}
	
	public void testComposite2() {
		
		HashMap<String, String > telephones = new HashMap<String, String>();
    	telephones.put("alaoshade", "0708050999");
    	telephones.put("afolabiaweni", "0708440921");
        Personnel personnel = new Personnel.Builder("ALAO AFOLABI", "Shadé").addFonction("Etuidant").Birth(LocalDate.of(1996, 8, 03)).Tel(telephones).build();
        
		Personnel p1 = new Personnel.Builder("ALAO", "Valentine").addFonction("Etuidant").Birth(LocalDate.of(1996, 8, 03)).Tel(telephones).build();
        Personnel p2 = new Personnel.Builder("AFOLABI", "Yasminath").addFonction("Directeur").Birth(LocalDate.of(1996, 8, 03)).Tel(telephones).build();
        Personnel p3 = new Personnel.Builder("Dupis Nom", "Salim").addFonction("Manager").Birth(LocalDate.of(1996, 8, 03)).Tel(telephones).build();
        Personnel p4 = new Personnel.Builder("ALAO Nom2", "Awal").addFonction("Manager").Birth(LocalDate.of(1996, 8, 03)).Tel(telephones).build();
        Personnel p5 = new Personnel.Builder("Dupont ", "Shina").addFonction("Encadrant").Birth(LocalDate.of(1996, 8, 03)).Tel(telephones).build();
        
        
        CompositeGroupe groupes = new CompositeGroupe("Enseigne");
        
        CompositeGroupe g1 = new CompositeGroupe("collaborateur");
        CompositeGroupe g2 = new CompositeGroupe("superviseur");
        CompositeGroupe g3 = new CompositeGroupe("cadre");
        
        g1.add(personnel);
        g1.add(p1);
        g2.add(p5);
        g2.add(p3);
        g3.add(p4);
        g3.add(p2);
        
        groupes.add(g1);
        groupes.add(g2);
        groupes.add(g3);
        
        //groupes.affiche();
       // groupes.Parcoursgrp();
        groupes.Parcoursfonction();
	}
	
	public void testParcoursposte() {
		
		
		HashMap<String, String > telephones = new HashMap<String, String>();
    	telephones.put("alaoshade", "0708050999");
    	telephones.put("afolabiaweni", "0708440921");
        Personnel personnel = new Personnel.Builder("ALAO AFOLABI", "Shadé").addFonction("Etuidant").Birth(LocalDate.of(1996, 8, 03)).Tel(telephones).build();
        
		Personnel p1 = new Personnel.Builder("ALAO", "Valentine").addFonction("Etuidant").Birth(LocalDate.of(1996, 8, 03)).Tel(telephones).build();
        Personnel p2 = new Personnel.Builder("AFOLABI", "Yasminath").addFonction("Directeur").Birth(LocalDate.of(1996, 8, 03)).Tel(telephones).build();
        Personnel p3 = new Personnel.Builder("Dupis Nom", "Salim").addFonction("Manager").Birth(LocalDate.of(1996, 8, 03)).Tel(telephones).build();
        Personnel p4 = new Personnel.Builder("ALAO Nom2", "Awal").addFonction("Manager").Birth(LocalDate.of(1996, 8, 03)).Tel(telephones).build();
        Personnel p5 = new Personnel.Builder("Dupont ", "Shina").addFonction("Encadrant").Birth(LocalDate.of(1996, 8, 03)).Tel(telephones).build();
        
        
        CompositeGroupe groupes = new CompositeGroupe("Enseigne");
        
        CompositeGroupe g1 = new CompositeGroupe("collaborateur");
        CompositeGroupe g2 = new CompositeGroupe("superviseur");
        CompositeGroupe g3 = new CompositeGroupe("cadre");
        
        g1.add(personnel);
        g1.add(p1);
        g2.add(p5);
        g2.add(p3);
        g3.add(p4);
        g3.add(p2);
        
        groupes.add(g1);
        groupes.add(g2);
        groupes.add(g3);
        
        groupes.poste();
		
	}
}
