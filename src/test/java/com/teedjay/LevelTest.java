package com.teedjay;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LevelTest {

    @Test
    public void verifyTimeMap() {

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

    }

}