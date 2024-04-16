package org.example.lab2.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@NamedQueries({
        @NamedQuery(name = "Team.findAll", query = "select t from Team as t")
})
@Table(name = "TEAM")
@Getter @Setter
public class Team {
    
    public Team(){
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    private String name;
    @Basic
    private Integer numberOfMembers = 0;
    @Basic
    private Integer score = 0;
    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private int version;
    
    @OneToMany(mappedBy = "team")
    private List<Player> players;
    
    @ManyToMany
    private List<Tournament> tournaments;
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
}
