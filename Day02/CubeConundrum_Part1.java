package Day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CubeConundrum_Part1 {

    public static void main(String args[]) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Day02/input.txt"));
        int possibleGamesSum = 0;

        while (scanner.hasNextLine()) {
            String game = scanner.nextLine();

            int gameID = Integer.parseInt(game.split(":")[0].split(" ")[1]);
            String[] gameRounds = game.split(":")[1].split(";");
            Map<String, Boolean> possibleRound = new HashMap<>();
    
            for (int index = 0; index < gameRounds.length; index++) {
                Map<String, Integer> cubes = new HashMap<>() {
                    {
                        put("blue", 0);
                        put("red", 0);
                        put("green", 0);
                    }
                };
                String[] roundData = gameRounds[index].split(",");
                for (String round : roundData) {
                    String[] roundInfo = round.trim().split(" ");
                    cubes.put(roundInfo[1], cubes.get(roundInfo[1]) + Integer.parseInt(roundInfo[0]));
                }

                possibleRound.put("Round" + (index + 1), (cubes.get("red") < 13 && cubes.get("green") < 14 && cubes.get("blue") < 15));
            }

            if (!possibleRound.values().contains(false)) {
                possibleGamesSum += gameID;
            }
        }

        System.out.println("Total " + possibleGamesSum);
    }
}
