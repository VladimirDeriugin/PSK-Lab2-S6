package org.example.lab2.async;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

@ApplicationScoped
@Specializes
public class FastRandomScore extends RandomScore{
    
    @Inject
    private ScoreService scoreService;
    @Override
    public int randomizeScore() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return scoreService.randomizeScore();
    }
}
