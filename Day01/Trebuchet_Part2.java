package Day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Trebuchet_Part2 {
  
    static String reverseString(String line) {
        StringBuilder originalLine = new StringBuilder(line);
        return originalLine.reverse().toString();
    }
    
    static int mapSubstringToNumber(String line, boolean reverse) throws IndexOutOfBoundsException {
        Map<String, Integer> letteredNumbers = new HashMap<>(){{
            put("zero", 0);
            put("one", 1);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
        }};
        
        for (int length = 3; length < 6; length++) {
            if (line.length() < length) continue;
            String letteredSubstring = line.substring(0, length);
            if (reverse) letteredSubstring = reverseString(letteredSubstring);
            boolean isLetteredNumber = letteredNumbers.containsKey(letteredSubstring);
            if (isLetteredNumber) return letteredNumbers.get(letteredSubstring);
        }

        return -1;
    }

    static int findFirstNumericValue(String line, boolean reverse) {
        int[] characters = line.chars().toArray();
        for (int index = 0; index < characters.length; index++) {
            if (Character.isDigit(characters[index])) return Character.getNumericValue(characters[index]);
            
            int numberFromSubstring = mapSubstringToNumber(line.substring(index), reverse);
            if (numberFromSubstring != -1) return numberFromSubstring;
        }

        return -1;
    }

    public static void main(String args[]) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Day01/input.txt"));
        int calibrationSum = 0; 

        while(scanner.hasNextLine()) {
            StringBuilder calibrationLine = new StringBuilder(scanner.nextLine());
            StringBuilder calibration = new StringBuilder();

            calibration.append(findFirstNumericValue(calibrationLine.toString(), false));
            calibration.append(findFirstNumericValue(calibrationLine.reverse().toString(), true));
            calibrationSum += Integer.parseInt(calibration.toString());
        }

        System.out.println("Total " + calibrationSum);
    }
}
