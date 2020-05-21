package fr.uvsq21506437.Annuaire;

import java.time.LocalDate;
import java.util.HashMap;

import fr.uvsq21506437.AnnuaireSerealizer.Personnel;
import junit.framework.TestCase;

public class PersonnelTest extends TestCase{
	
	public void testPersonnel() {
		HashMap<String, String > telephones = new HashMap<String, String>();
    	telephones.put("alaoshade", "0708050999");
    	telephones.put("afolabiaweni", "0708440921");
        Personnel personnel = new Personnel.Builder("ALAO AFOLABI", "Shadé").addFonction("étuidante").Birth(LocalDate.of(1996, 8, 03)).Tel(telephones).build();
        
        personnel.affiche();
		
        
        
        
	}

}
