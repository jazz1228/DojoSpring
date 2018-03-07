package co.edu.udea.dojospring.repository;

import co.edu.udea.dojospring.model.Poster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PosterRepository extends SimpleJpaRepository<Poster, Long> {

    public PosterRepository(JpaEntityInformation<Poster, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public PosterRepository(Class<Poster> domainClass, EntityManager em) {
        super(domainClass, em);
    }
}
