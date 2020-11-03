package com.teedjay;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LevelTest {

    @Test
    public void verifyTileMap() {

        Level level = new Level();
        
        //System.out.println(level.tilemap);
        assertEquals(32, level.width);
        assertEquals(18, level.height);

        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < level.height; y++) {
            for (int x = 0; x < level.width; x++) {
                sb.append(level.getTileAt(x, y));
            }
            sb.append("\n");
        }

        //System.out.println(sb.toString());
        assertEquals(level.tilemap, sb.toString());

        // verify some map specific details
        assertEquals(3, level.superDots);
        assertEquals(388, level.dotsInTotal);
        assertEquals(4, level.ghosts);
        assertEquals(4, level.tunnels);
        assertEquals(1, level.fruits);
        assertEquals(1, level.pacmans);

    }

}