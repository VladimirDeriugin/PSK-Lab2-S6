package org.example.lab2.persistence;

import lombok.Setter;
import org.example.lab2.entities.Tournament;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Setter
@ApplicationScoped
public class TournamentsDAO {
    @Inject
    private EntityManager em;
    
    public List<Tournament> loadAll() {
        return em.createNamedQuery("Tournament.findAll", Tournament.class).getResultList();
    }
    
    public void persist(Tournament tournament){
        this.em.persist(tournament);
    }
    
    public Tournament findOne(Integer id) {
        return em.find(Tournament.class, id);
    }
    
    public void update(Tournament Tournament) {
        this.em.merge(Tournament);
    }
}
