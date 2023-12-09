package Day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.OptionalInt;
import java.util.Scanner;

public class Trebuchet_Part1 {

    static int findFirstNumericValue(String line) {
        OptionalInt numericValue = line.chars().filter(character -> Character.isDigit(character)).findFirst();
        return Character.getNumericValue(numericValue.getAsInt());
    }

    public static void main(String args[]) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Day01/input.txt"));
        int calibrationSum = 0; 

        while(scanner.hasNextLine()) {
            StringBuilder calibrationLine = new StringBuilder(scanner.nextLine());
            StringBuilder calibration = new StringBuilder();

            calibration.append(findFirstNumericValue(calibrationLine.toString()));
            calibration.append(findFirstNumericValue(calibrationLine.reverse().toString()));
            
            calibrationSum += Integer.parseInt(calibration.toString());
        }

        System.out.println("Total " + calibrationSum);
    }
}
