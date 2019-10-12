
package acme.features.anonymous.bulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.entities.Bulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousBulletinRepository extends AbstractRepository {

	@Query("select b from Bulletin b")
	Collection<Bulletin> findAllBulletin();

	@Query("select b from Bulletin b where b.name = ?1")
	Collection<Bulletin> findByName(String name);

	@Query("select b from Bulletin b where b.surname = ?1")
	Collection<Bulletin> findBySurname(String surname);

	@Query("select b from Bulletin b where b.nif = ?1")
	Collection<Bulletin> findByNif(String nif);
}
