package sopra.formation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.formation.dao.IAbsenceDao;
import sopra.formation.dao.ICompetenceDao;
import sopra.formation.dao.ICoursDao;
import sopra.formation.dao.ICursusDao;
import sopra.formation.dao.IFiliereDao;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.dao.ISalleDao;
import sopra.formation.dao.IUtilisateurDao;
import sopra.formation.dao.jpa.AbsenceDaoJpa;
import sopra.formation.dao.jpa.CompetenceDaoJpa;
import sopra.formation.dao.jpa.CoursDaoJpa;
import sopra.formation.dao.jpa.CursusDaoJpa;
import sopra.formation.dao.jpa.FiliereDaoJpa;
import sopra.formation.dao.jpa.MatiereDaoJpa;
import sopra.formation.dao.jpa.SalleDaoJpa;
import sopra.formation.dao.jpa.UtilisateurDaoJpa;

public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("lafactory-jpa");

	private final IAbsenceDao abscenceDao = new AbsenceDaoJpa();
	private final ICompetenceDao competenceDao = new CompetenceDaoJpa();
	private final ICoursDao coursDao = new CoursDaoJpa();
	private final ICursusDao cursusDao = new CursusDaoJpa();
	private final IFiliereDao filiereDao = new FiliereDaoJpa();
	private final IMatiereDao matiereDao = new MatiereDaoJpa();
	private final ISalleDao salleDao = new SalleDaoJpa();
	private final IUtilisateurDao utilisateurDao = new UtilisateurDaoJpa();

	private Application() {
	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IAbsenceDao getAbscenceDao() {
		return abscenceDao;
	}

	public ICompetenceDao getCompetenceDao() {
		return competenceDao;
	}

	public ICoursDao getCoursDao() {
		return coursDao;
	}

	public ICursusDao getCursusDao() {
		return cursusDao;
	}

	public IFiliereDao getFiliereDao() {
		return filiereDao;
	}

	public IMatiereDao getMatiereDao() {
		return matiereDao;
	}

	public ISalleDao getSalleDao() {
		return salleDao;
	}

	public IUtilisateurDao getUtilisateurDao() {
		return utilisateurDao;
	}

}
