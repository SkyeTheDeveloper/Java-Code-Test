import java.util.Scanner;

public class Game {
    
    public static String player = "λ";
    public static String[][] map;
    public static int[] position;
    public static int worldNumber = 0;
    public static boolean active = true;
    
    public static void initialize() {
        Maps maps = new Maps();
        map = maps.map0;
        position = new int[] { 3, 3 };
        map[position[0]][position[1]] = player;
        gameLoop();
    }
    
    static void gameLoop() {
        Scanner input = new Scanner(System.in);
        while (active) {
            renderMap();
            char key = input.next().charAt(0);
            if (key == 'w') {
                movement(0, -1);
            } else if (key == 's') {
                movement(0, 1);
            } else if (key == 'a') {
                movement(-1, 0);
            } else if (key == 'd') {
                movement(1, 0);
            } else if (key == 'e') {
                nextMap(input);
            }
        }
    }
    
    static void movement(int deltaX, int deltaY) {
        int x = position[0];
        int y = position[1];
        int targetX = x + deltaX;
        int targetY = y + deltaY;
        String targetTile = map[targetY][targetX];
        if (targetTile == " ") {
            map[y][x] = " ";
            position[0] += deltaX;
            position[1] += deltaY;
            map[targetY][targetX] = player;
        }
    }
    
    static void renderMap() {
        SkyesUtils.clear();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static void nextMap(Scanner input) {
        worldNumber++;
        switch (worldNumber) {
            case 1 -> {
                SkyesUtils.disp("You Win!", false);
                active = false;
                input.close();
            }
            default -> {
                initialize();
            }
        }
    }
}