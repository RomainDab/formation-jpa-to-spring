package sopra.formation.dao;

import java.util.List;

import sopra.formation.model.Stagiaire;

public interface UtilisateurDaoCustom {
	
	List<Stagiaire> findByNomPrenom(String nom, String prenom);

}
