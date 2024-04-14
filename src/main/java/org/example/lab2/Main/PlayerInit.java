package org.example.lab2.Main;


import lombok.Getter;
import lombok.Setter;
import org.example.lab2.entities.Player;
import org.example.lab2.persistence.PlayersDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class PlayerInit implements Serializable {

    private Player player;

    @Inject
    private PlayersDAO playersDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdatePlayerDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer playerId = Integer.parseInt(requestParameters.get("playerId"));
        this.player = playersDAO.findOne(playerId);
    }
}
