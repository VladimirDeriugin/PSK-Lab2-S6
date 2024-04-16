package org.example.lab2.async;

import javax.enterprise.inject.Alternative;
import java.util.Random;

@Alternative
public class LowScore implements ScoreService {
    @Override
    public int randomizeScore() {
        return new Random().nextInt(50);
    }
}
