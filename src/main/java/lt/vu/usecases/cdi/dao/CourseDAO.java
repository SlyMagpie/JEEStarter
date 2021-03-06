package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Course;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

@ApplicationScoped
public class CourseDAO {
    @Inject
    @PersistenceContext(unitName = "StudentsPU")
    private EntityManager em;

    public void create(Course course) {
        em.persist(course);
    }

    public List<Course> getAllCourses() {
        return em.createNamedQuery("Course.findAll", Course.class).getResultList();
    }
}
