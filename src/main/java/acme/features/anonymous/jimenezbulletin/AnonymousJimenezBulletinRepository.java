
package acme.features.anonymous.jimenezbulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.JimenezBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousJimenezBulletinRepository extends AbstractRepository {

	@Query("select b from JimenezBulletin b")
	Collection<JimenezBulletin> findAllJimenezBulletin();

	@Query("select b from JimenezBulletin b where b.name = ?1")
	Collection<JimenezBulletin> findByName(String name);

	@Query("select b from JimenezBulletin b where b.surname = ?1")
	Collection<JimenezBulletin> findBySurname(String surname);

	@Query("select b from JimenezBulletin b where b.nif = ?1")
	Collection<JimenezBulletin> findByNif(String nif);
}
