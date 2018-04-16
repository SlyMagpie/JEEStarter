package lt.vu.cachepropagation;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.*;
import java.util.Date;

@Named
@Stateful
@RequestScoped
public class Comp1 {
    @PersistenceContext(unitName = "StudentsPU", type = PersistenceContextType.TRANSACTION, synchronization = SynchronizationType.SYNCHRONIZED)
    private EntityManager em;

    @Inject
    private Comp2 comp2;

    public String sayHello() {
        return toString() + " | " + new Date() + " | " + " Cache instance: " + em.getDelegate() +
                " | Second component says: " + comp2.sayHello();
    }

}
