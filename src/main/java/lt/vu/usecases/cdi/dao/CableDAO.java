package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Cable;
import lt.vu.entities.Course;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class CableDAO {
    @Inject
    @PersistenceContext(unitName = "RoomsPU")
    private EntityManager em;

    public void create(Cable cable) {
        em.persist(cable);
    }

    public List<Cable> getAllCables() {
        return em.createNamedQuery("Cable.findAll", Cable.class).getResultList();
    }
}
