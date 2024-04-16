package org.example.lab2.rest;

import lombok.Getter;
import lombok.Setter;
import org.example.lab2.entities.Player;
import org.example.lab2.persistence.PlayersDAO;
import org.example.lab2.rest.contracts.PlayerDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Setter
@Getter
@ApplicationScoped
@Path("/players")
public class PlayersController {
    
    @Inject
    private PlayersDAO playersDAO;
    
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Player player = playersDAO.findOne(id);
        if (player == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setFullName(player.getFullName());
        playerDTO.setTeam(player.getTeam().getName());
        
        return Response.ok(playerDTO).build();
    }
    
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Integer playerId, PlayerDTO playerData) {
        try {
            Player existingPlayer = playersDAO.findOne(playerId);
            if (existingPlayer == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingPlayer.setFullName(playerData.getFullName());
            playersDAO.update(existingPlayer);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
    
    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(PlayerDTO playerData) {
        Player newPlayer = new Player();
        newPlayer.setFullName(playerData.getFullName());
        newPlayer.setTeam(playersDAO.findTeamByName(playerData.getTeam()));
        playersDAO.persist(newPlayer);
        return Response.ok().build();
    }
    
    @Path("/{id}")
    @DELETE
    @Transactional
    public Response delete(@PathParam("id") final Integer playerId) {
        Player existingPlayer = playersDAO.findOne(playerId);
        if (existingPlayer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        playersDAO.delete(existingPlayer);
        return Response.ok().build();
    }
}

