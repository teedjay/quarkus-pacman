package com.teedjay;

public class Level {

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

}
