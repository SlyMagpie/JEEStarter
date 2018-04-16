package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Cable;
import lt.vu.entities.Computer;
import lt.vu.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ComputerDAO {
    @Inject
    @PersistenceContext(unitName = "RoomsPU")
    private EntityManager em;

    public void create(Computer computer) {
        em.persist(computer);
    }

    public List<Computer> getAllComputers() {
        return em.createNamedQuery("Computer.findAll", Computer.class).getResultList();
    }
}
