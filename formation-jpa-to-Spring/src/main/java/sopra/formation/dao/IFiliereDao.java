package sopra.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Filiere;

public interface IFiliereDao extends JpaRepository<Filiere, Long> {

		@Query("select f FROM Filiere f JOIN f.salle fs WHERE fs.adresse.ville = :ville")
		List<Filiere> findByVille(@Param("ville") String ville);
}
