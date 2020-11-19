package com.teedjay;

public class Level {

    // At the core of Pacman is on a Z80 CPU supported by a 224x288 color video with hardware sprites and a 3-voice wavetable sound generator... a pretty nice setup for 1980!
    // GFX https://www.spriters-resource.com/arcade/pacman/

    // + are round edges (calculated on inbound connections)
    // - are horizontal walls
    // | are vertical walls
    // . is a regular eatable dot
    // * is a regular dot that can also turn into fruits
    // o is a super power dot
    // @ is starting point for pacman
    // A..D are tunnels pairs (connected together)
    // 1..8 starting point for monsters
    // [SPACE] is nothing

    String tilemap = """
    +----------------------+-+-----+
    |......................|B|.....|
    |.+--+.................| |..o..|
    |.|  |.................| |.....|
    |.+--+.........................|
    |...........+-+ +-+............|
    |...........|     |............|
    +---........| 1 2 |.........---+
    |A  ........| 3 4 |.........  A|
    +---........|     |.........---+
    |...........+-----+............|
    |..............*...............|
    |..............................|
    |..............@...............|
    |.....| |......................|
    |..o..| |...................o..|
    |.....|B|......................|
    +-----+-+----------------------+
    """;

    long superDots = tilemap.chars().filter(i -> i == 'o').count();
    long regularDots = tilemap.chars().filter(i -> i == '.').count();
    long dotsInTotal = superDots + regularDots;

    long ghosts = tilemap.chars().filter(i -> "12345678".indexOf(i) > -1).count();
    long tunnels = tilemap.chars().filter(i -> "ABCD".indexOf(i) > -1).count();
    long fruits = tilemap.chars().filter(i -> i == '*').count();
    long pacmans = tilemap.chars().filter(i -> i == '@').count();

    long width = tilemap.lines().findFirst().get().length();
    long height = tilemap.lines().count();

    public char getTileAt(int x, int y) {
        int index = (int) (width + 1) * y + x;
        return tilemap.charAt(index);
    }

    public char calculatedTileAt(int x, int y) {
        char tile = getTileAt(x, y);
        if (tile == '+') {
            boolean wup = false, wright = false, wdown = false, wleft = false;
            if (x > 0) wleft = ('-' == getTileAt(x - 1, y));
            if (x < (width - 1)) wright = ('-' == getTileAt(x + 1, y));
            if (y > 0) wup = ('|' == getTileAt(x, y - 1));
            if (y < (height - 1)) wdown = ('|' == getTileAt(x, y + 1));
            var surroundigs = "" + (wup ? "U" : " ") + (wright ? "R" : " ") + (wdown ? "D" : " ") + (wleft ? "L" : " ");
            //
            if ("UR  ".equals(surroundigs)) tile = '\\';
            if ("U  L".equals(surroundigs)) tile = '/';
            if (" RD ".equals(surroundigs)) tile = '/';
            if ("  DL".equals(surroundigs)) tile = '\\';
        }
        return tile;
    }

}
