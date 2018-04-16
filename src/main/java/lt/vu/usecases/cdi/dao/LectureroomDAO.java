package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Computer;
import lt.vu.entities.Lectureroom;
import lt.vu.entities.University;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class LectureroomDAO {
    @Inject
    @PersistenceContext(unitName = "RoomsPU")
    private EntityManager em;

    public void create(Lectureroom lectureroom) {
        em.persist(lectureroom);
    }
    public void updateAndFlush(Lectureroom lectureroom) {
        em.merge(lectureroom);
        em.flush();
    }

    public List<Lectureroom> getAllLecturerooms() {
        return em.createNamedQuery("Lectureroom.findAll", Lectureroom.class).getResultList();
    }

    public Lectureroom findById(Integer id) {
        return em.find(Lectureroom.class, id);
    }
}
