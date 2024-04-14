package org.example.lab2.persistence;

import org.example.lab2.entities.Player;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class PlayersDAO {
    
    @Inject
    private EntityManager em;
    
    public void persist(Player player){
        this.em.persist(player);
    }
    
    public Player findOne(Integer id){
        return em.find(Player.class, id);
    }
    
    public Player update(Player player){
        return em.merge(player);
    }
    
    @Transactional
    public void delete(Player player) {
        player = em.merge(player);
        em.remove(player);
    }
}
