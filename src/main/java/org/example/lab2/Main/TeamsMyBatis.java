package org.example.lab2.Main;

import lombok.Getter;
import lombok.Setter;
import org.example.lab2.mybatis.dao.TeamMapper;
import org.example.lab2.mybatis.model.Team;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
@Getter @Setter
public class TeamsMyBatis {
    @Inject
    private TeamMapper teamMapper;

    private List<Team> allTeams;

    private Team teamToCreate = new Team();

    @PostConstruct
    public void init() {
        this.loadAllTeams();
    }

    private void loadAllTeams() {
        this.allTeams = teamMapper.selectAll();
    }

    @Transactional
    public String createTeam() {
        teamMapper.insert(teamToCreate);
        return "/myBatis/teams?faces-redirect=true";
    }
}
