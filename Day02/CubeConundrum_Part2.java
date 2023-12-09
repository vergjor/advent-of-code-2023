package Day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CubeConundrum_Part2 {

    public static void main(String args[]) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Day02/input.txt"));
        int possibleGamesSum = 0;

        while (scanner.hasNextLine()) {
            String game = scanner.nextLine();
            String[] gameRounds = game.split(":")[1].split(";");
            Map<String, Integer> cubes = new HashMap<>() {
                {
                    put("blue", 0);
                    put("red", 0);
                    put("green", 0);
                }
            };

            for (int index = 0; index < gameRounds.length; index++) {
                String[] roundData = gameRounds[index].split(",");
                for (String round : roundData) {
                    String[] roundInfo = round.trim().split(" ");

                    if (cubes.get(roundInfo[1]) < Integer.parseInt(roundInfo[0])) {
                        cubes.put(roundInfo[1], Integer.parseInt(roundInfo[0]));
                    }
                }
            }

            possibleGamesSum += cubes.get("blue") * cubes.get("red") * cubes.get("green");
        }

        System.out.println("Total " + possibleGamesSum);
    }
}
