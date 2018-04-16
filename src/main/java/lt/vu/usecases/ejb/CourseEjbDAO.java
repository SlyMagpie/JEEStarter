package lt.vu.usecases.ejb;

import lt.vu.entities.Course;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.SynchronizationType;

@Stateless
public class CourseEjbDAO {
    @PersistenceContext(unitName = "StudentsPU", synchronization = SynchronizationType.UNSYNCHRONIZED)
    private EntityManager em;

    public void create(Course course) {
        em.persist(course);
    }
}
