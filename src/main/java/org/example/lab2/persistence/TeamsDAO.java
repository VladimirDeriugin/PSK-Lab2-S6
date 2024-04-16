package org.example.lab2.persistence;

import lombok.Setter;
import org.example.lab2.entities.Team;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Setter
@RequestScoped
public class TeamsDAO {
    @Inject
    private EntityManager em;
    
    public void update(Team team){
        this.em.merge(team);
    }
    public List<Team> loadAll() {
        return em.createNamedQuery("Team.findAll", Team.class).getResultList();
    }
    
    public void persist(Team team){
        this.em.persist(team);
    }
    
    public Team findOne(Integer id) {
        return em.find(Team.class, id);
    }
}
