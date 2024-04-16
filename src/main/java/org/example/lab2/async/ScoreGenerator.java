package org.example.lab2.async;

import org.example.lab2.interceptors.LoggedInvocation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

@Named
@ApplicationScoped
public class ScoreGenerator implements Serializable {

    @Inject
    RandomScore randomScore;
    
    private CompletableFuture<Integer> futureScore = null;
    
    @LoggedInvocation
    public String generateScore() {
        futureScore = CompletableFuture.supplyAsync(() -> randomScore.randomizeScore());
        return "/index.xhtml?faces-redirect=true";
    }
    
    public boolean isScoreGenerationRunning() {
        return futureScore != null && !futureScore.isDone();
    }
    
    public String getScoreGenerationStatus() {
        if (futureScore == null) {
            return "null";
        } else if (isScoreGenerationRunning()) {
            return "Score generation in progress";
        }
        try {
            return "Generated score: " + futureScore.get();
        } catch (Exception e) {
            return "Score generation failed";
        }
    }
    

}
