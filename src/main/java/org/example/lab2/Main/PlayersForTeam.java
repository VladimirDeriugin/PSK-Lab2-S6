package org.example.lab2.Main;

import lombok.Getter;
import lombok.Setter;
import org.example.lab2.entities.Player;
import org.example.lab2.entities.Team;
import org.example.lab2.entities.Tournament;
import org.example.lab2.interceptors.LoggedInvocation;
import org.example.lab2.persistence.PlayersDAO;
import org.example.lab2.persistence.TeamsDAO;
import org.example.lab2.persistence.TournamentsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Model
@Getter @Setter
public class PlayersForTeam implements Serializable {
    @Inject
    private TeamsDAO teamsDAO;
    
    @Inject
    private TournamentsDAO tournamentDAO;
    
    @Inject
    private PlayersDAO playersDAO;
    
    private Team team;
    
    private Player playerToCreate = new Player();
    
    private List<Tournament> selectedTournaments;
    
    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer teamId = Integer.parseInt(requestParameters.get("teamId"));
        this.team = teamsDAO.findOne(teamId);
    }
    
    @Transactional
    @LoggedInvocation
    public void createPlayer() {
        if (team.getNumberOfMembers() >= 6) {
            throw new IllegalStateException("Maximum number of players in a team is 6");
        }

        playerToCreate.setTeam(this.team);
        playersDAO.persist(playerToCreate);

        team.setNumberOfMembers(team.getNumberOfMembers() + 1);
        teamsDAO.update(team);
    }
    
    @Transactional
    public void deletePlayer(Integer playerId) {
        Player playerToDelete = playersDAO.findOne(playerId);
        if (playerToDelete != null) {
            playersDAO.delete(playerToDelete);
            team.setNumberOfMembers(team.getNumberOfMembers() - 1);
            teamsDAO.update(team);
        }
    }
    
    public List<Tournament> getNonParticipatingTournaments() {
        if (this.team == null) {
            return new ArrayList<>();
        }
        List<Tournament> allTournaments = this.tournamentDAO.loadAll();
        return allTournaments.stream()
                .filter(tournament -> !this.team.getTournaments().contains(tournament))
                .collect(Collectors.toList());
    }
    
    @Transactional
    public void assignTournaments() {
        for (Tournament tournament : selectedTournaments) {
            team.getTournaments().add(tournament);
            tournament.getTeams().add(team);
            tournamentDAO.update(tournament);
        }
        teamsDAO.update(team);
    }
}
