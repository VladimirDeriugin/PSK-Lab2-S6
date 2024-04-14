package org.example.lab2.Main;

import lombok.Getter;
import lombok.Setter;
import org.example.lab2.entities.Team;
import org.example.lab2.entities.Tournament;
import org.example.lab2.persistence.TeamsDAO;
import org.example.lab2.persistence.TournamentsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Model
@Getter @Setter
public class TournamentDescription {
    
    @Inject
    private TournamentsDAO tournamentsDAO;
    
    @Inject
    private TeamsDAO teamsDAO;
    
    private Tournament tournament;
    
    private List<Team> teamsToAdd;
    
    
    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("id");
        if (id != null) {
            this.tournament = this.tournamentsDAO.findOne(Integer.parseInt(id));
        }
    }
    
    public List<Team> getNonParticipatingTeams() {
        if (this.tournament == null) {
            return new ArrayList<>();
        }
        List<Team> allTeams = this.teamsDAO.loadAll();
        return allTeams.stream()
                .filter(team -> !this.tournament.getTeams().contains(team))
                .collect(Collectors.toList());
    }
    
    public void addTeamsToTournament() {
        if (this.tournament != null) {
            this.tournament.getTeams().addAll(this.teamsToAdd);
            this.tournamentsDAO.update(this.tournament);
        }
    }
}