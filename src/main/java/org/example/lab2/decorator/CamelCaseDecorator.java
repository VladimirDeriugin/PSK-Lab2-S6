package org.example.lab2.decorator;

import org.example.lab2.entities.Team;
import org.example.lab2.persistence.TeamsDAOLocal;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.util.List;

@Decorator
public abstract class CamelCaseDecorator implements TeamsDAOLocal {

    @Inject
    @Delegate
    TeamsDAOLocal teamsDAO;
    
    @Override
    public void persist(Team team){
        String name = team.getName();
        String modifiedName = name.substring(0, 1).toUpperCase() + name.substring(1);
        team.setName(modifiedName);
        teamsDAO.persist(team);
    }
    
    @Override
    public List<Team> loadAll(){
        List<Team> teams = teamsDAO.loadAll();
        for (Team team : teams) {
            String name = team.getName();
            String modifiedName = name.substring(0, 1).toUpperCase() + name.substring(1);
            team.setName(modifiedName);
        }
        return teams;
    }
}
