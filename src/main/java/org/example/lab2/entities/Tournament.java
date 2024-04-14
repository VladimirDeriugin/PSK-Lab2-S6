package org.example.lab2.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Getter @Setter
@Entity
@NamedQueries({
        @NamedQuery(name = "Tournament.findAll", query = "select t from Tournament as t")
})
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Basic
    private String name;
    
    @Basic
    private Integer prizePool;
    
    @Basic
    private Integer leagueScore;
    
    @ManyToMany(mappedBy = "tournaments")
    private List<Team> teams;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tournament tournament = (Tournament) o;
        return Objects.equals(id, tournament.id);
    }
    
    @Override
    public int hashCode() {
        
        return Objects.hash(id);
    }
}
