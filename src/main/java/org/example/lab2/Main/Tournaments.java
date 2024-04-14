package org.example.lab2.Main;

import lombok.Getter;
import lombok.Setter;
import org.example.lab2.entities.Team;
import org.example.lab2.entities.Tournament;
import org.example.lab2.persistence.TournamentsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Getter @Setter
@Model
public class Tournaments {
    
    @Inject
    private TournamentsDAO tournamentsDAO;
    
    private Tournament tournamentToCreate = new Tournament();
    
    private Team teamToAdd = new Team();
    
    private List<Tournament> allTournaments;
    @PostConstruct
    public void init(){
        loadAllTournaments();
    }
    
    
    @Transactional
    public String createTournament(){
        this.tournamentsDAO.persist(tournamentToCreate);
        return FacesContext.getCurrentInstance().getViewRoot().getViewId() + "?faces-redirect=true";
    }
    
    private void loadAllTournaments(){
        this.allTournaments = tournamentsDAO.loadAll();
    }
}