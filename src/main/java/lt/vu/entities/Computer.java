package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.johnzon.mapper.JohnzonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COMPUTER")
@NamedQueries({
        @NamedQuery(name = "Computer.findAll", query = "SELECT c FROM Computer c"),
        @NamedQuery(name = "Computer.findById", query = "SELECT c FROM Computer c WHERE c.id = :id")
})
@Getter
@Setter
@EqualsAndHashCode(of = "model")
@ToString(of = {"id", "model"})
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Size(min = 3, max = 20)
    @Column(name = "MODEL")
    private String model;

    //Many computers can belong in a single room
    @JoinColumn(name = "ROOMID", referencedColumnName = "ID")
    @ManyToOne
    @JohnzonIgnore
    private Lectureroom lectureroom;
}
