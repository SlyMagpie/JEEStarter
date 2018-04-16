package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.johnzon.mapper.JohnzonIgnore;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LECTUREROOM")
@NamedQueries({
        @NamedQuery(name = "Lectureroom.findAll", query = "SELECT l FROM Lectureroom l"),
        @NamedQuery(name = "Lectureroom.findById", query = "SELECT l FROM Lectureroom l WHERE l.id = :id")
})
@Getter
@Setter
@EqualsAndHashCode(of = "title")
@ToString(of = {"id", "title"})
public class Lectureroom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Size(min = 5,max = 50)
    @Column(name = "TITLE")
    private String title;

    /*Multiple cables can go into one room, just like multiple rooms
    can have the same cable running through them */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CABLECONNECTION", joinColumns = {
            @JoinColumn(name = "ROOMID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "CABLEID", referencedColumnName = "ID")})
    @JohnzonIgnore
    private List<Cable> cableList = new ArrayList<>(); //cia viskas gerai

    //A lecture room contains multiple computers
    @OneToMany(mappedBy = "lectureroom")
    private List<Computer> computerList = new ArrayList<>();
}
