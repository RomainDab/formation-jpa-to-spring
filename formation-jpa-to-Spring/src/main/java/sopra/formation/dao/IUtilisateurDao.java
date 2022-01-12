package sopra.formation.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Formateur;
import sopra.formation.model.Stagiaire;
import sopra.formation.model.Utilisateur;

public interface IUtilisateurDao extends JpaRepository<Utilisateur, Long>, UtilisateurDaoCustom {

	@Query("select f from Formateur f where f.email = :email")
	Formateur findByEmail(@Param("email") String email);
	
	@Query("Select distinct f from Formateur f "
			+ "left join f.absences fa "
			+ "join f.competences fc "
			+ "join fc.matiere fcm "
			+ "where fcm.titre = :nommatiere "
			//+ "and fa.date not between :datedebut and :datefin "
			+ "and not( fa.date >= :datedebut and fa.date <= :datefin )")
	List<Formateur> findByDisponible(@Param("datedebut") LocalDate datedebut, @Param("datefin") LocalDate datefin, @Param("nommatiere") String nommatiere);
	
	
	@Query("select s FROM Stagiaire s JOIN fetch s.cursus")
	List<Stagiaire> findPrechargementCursus();
	
	@Query("select f FROM Formateur f JOIN fetch f.cours fc JOIN fetch fc.matiere")
	List<Formateur> findPrechargementCoursMatiere();
}
