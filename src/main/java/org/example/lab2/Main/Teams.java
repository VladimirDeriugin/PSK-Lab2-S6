package org.example.lab2.Main;

import lombok.Getter;
import lombok.Setter;
import org.example.lab2.alternative.GreetingService;
import org.example.lab2.entities.Tournament;
import org.example.lab2.persistence.TeamsDAO;
import org.example.lab2.entities.Team;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
@Getter @Setter
public class Teams {
    @Inject
    private TeamsDAO teamsDAO;
    
    @Inject
    private GreetingService greetingService;
    
    private Team teamToCreate = new Team();
    
    
    private List<Team> allTeams;
    private List<Team> loadedTeams;
    
    @PostConstruct
    public void init(){
        loadAllTeams();
    }
    
    @Transactional
    public void createTeam(){
        try
        {
            System.out.println(teamToCreate);
            this.teamsDAO.persist(teamToCreate);
            teamToCreate = new Team();
            loadAllTeams();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Transactional
    public void removeTournamentFromTeam(Tournament tournament, Team team) {
        team.getTournaments().remove(tournament);
        teamsDAO.update(team);
    }
    
    private void loadAllTeams(){
        this.allTeams = teamsDAO.loadAll();
    }
}
