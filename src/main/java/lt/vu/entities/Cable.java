package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CABLE")
@NamedQueries({
        @NamedQuery(name = "Cable.findAll", query = "SELECT c FROM Cable c"),
        @NamedQuery(name = "Cable.findById", query = "SELECT c FROM Cable c WHERE c.id = :id")
})
@Getter
@Setter
@EqualsAndHashCode(of = "connectiontype")
@ToString(of = {"id", "connectiontype"})
public class Cable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Size(min = 5, max = 50)
    @Column(name = "CONNECTIONTYPE")
    private String connectiontype;

    //A cable can connect to multiple rooms
    @ManyToMany(mappedBy = "cableList")
    private List<Lectureroom> lectureroomList = new ArrayList<>();
}
