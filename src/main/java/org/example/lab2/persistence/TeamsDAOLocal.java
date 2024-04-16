package org.example.lab2.persistence;

import org.example.lab2.entities.Team;

import javax.persistence.EntityManager;
import java.util.List;

public interface TeamsDAOLocal {
    List<Team> loadAll();
    void persist(Team team);
    Team findOne(Integer id);
    void update(Team team);
}
