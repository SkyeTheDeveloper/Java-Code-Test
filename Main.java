import java.util.Scanner;

public class Main {
    
    public static String[] menuOptions;
    public static int menuIndex = 0;
    public static boolean menuActive = true;
    
    public static void main(String[] args) {
        mainMenu();
    }
    
    public static void mainMenu() {
        menuOptions = new String[] { "Start Game", "Settings", "Credits", "Exit Game" };
        Scanner input = new Scanner(System.in);
        while (menuActive) {
            displayMenu();
            char key = input.next().charAt(0);
            if (key == 'w') {
                menuIndex--;
                if (menuIndex < 0) {
                    menuIndex = 0;
                }
            } else if (key == 's') {
                menuIndex++;
                if (menuIndex > 3) {
                    menuIndex = 3;
                }
            } else if (key == 'e') {
                menuActive = false;
                handleInput(menuIndex);
            }
        }
    }
    
    static void displayMenu() {
        SkyesUtils.clear();
        System.out.println("       █████                                    \n      ░░███                                     \n       ░███   ██████   █████ █████  ██████      \n       ░███  ░░░░░███ ░░███ ░░███  ░░░░░███     \n       ░███   ███████  ░███  ░███   ███████     \n ███   ░███  ███░░███  ░░███ ███   ███░░███     \n░░████████  ░░████████  ░░█████   ░░████████    \n ░░░░░░░░    ░░░░░░░░    ░░░░░     ░░░░░░░░     \n\n   █████████                                    \n  ███░░░░░███                                   \n ███     ░░░   ██████   █████████████    ██████ \n░███          ░░░░░███ ░░███░░███░░███  ███░░███\n░███    █████  ███████  ░███ ░███ ░███ ░███████ \n░░███  ░░███  ███░░███  ░███ ░███ ░███ ░███░░░  \n ░░█████████ ░░████████ █████░███ █████░░██████ \n  ░░░░░░░░░   ░░░░░░░░ ░░░░░ ░░░ ░░░░░  ░░░░░░  ");
        for (String option : menuOptions) {
            String prefix = "";
            String suffix = "";
            if (option == menuOptions[menuIndex]) {
                prefix = "> ";
                suffix = " <";
            }
            System.out.println(prefix + option + suffix);
        }
    }
    
    static void handleInput(int selection) {
        switch (selection) {
            case 0 -> { Game.initialize(); }
            case 1 -> { settings(); }
            case 2 -> { credits(); }
            case 3 -> { exitGame(); }
        }
    }
    
    static void settings() {
        SkyesUtils.disp("There are no settings right now", false);
        mainMenu();
    }
    
    static void credits() {
        SkyesUtils.disp("There are no credits right now.", false);
    }
    
    static void exitGame() {
        SkyesUtils.disp("Thanks for playing!", false);
    }
}