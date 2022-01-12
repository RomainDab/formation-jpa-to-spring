package sopra.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Cours;
import sopra.formation.model.Filiere;

public interface ICoursDao extends JpaRepository<Cours, Long> {

	@Query("select c FROM Cours c JOIN c.filiere cf JOIN c.matiere cm WHERE c.filiere.id = :filiere AND c.duree != cm.duree")
	List<Cours> findByDifferenceDuree(@Param("filiere") Long filiere_id);

}
