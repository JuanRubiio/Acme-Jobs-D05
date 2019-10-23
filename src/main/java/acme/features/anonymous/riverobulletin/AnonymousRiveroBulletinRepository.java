
package acme.features.anonymous.riverobulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletin.RiveroBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousRiveroBulletinRepository extends AbstractRepository {

	@Query("select b from RiveroBulletin b")
	Collection<RiveroBulletin> findAllBulletin();

	@Query("select b from RiveroBulletin b where b.name = ?1")
	Collection<RiveroBulletin> findByName(String name);

	@Query("select b from RiveroBulletin b where b.surname = ?1")
	Collection<RiveroBulletin> findBySurname(String surname);

	@Query("select b from RiveroBulletin b where b.nif = ?1")
	Collection<RiveroBulletin> findByNif(String nif);
}
