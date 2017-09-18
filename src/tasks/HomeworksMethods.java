package tasks;

import java.util.HashMap;
import java.util.Map;

public class HomeworksMethods {

    static public int[][] transponator(int[][] matrix) {

        int[][] transponatedMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                transponatedMatrix[j][i] = matrix[i][j];
            }
        }
        return transponatedMatrix;
    }

    static public int numberCounter(String str) {
        int count = 1;
        int preCount = 0;
        char[] arrayOfChars = str.toCharArray();
        for (int i = 0; i < arrayOfChars.length; i++) {
            if (arrayOfChars[i] >= 48 && arrayOfChars[i] <= 57) {
                while (arrayOfChars[i] >= 48 && arrayOfChars[i] <= 57) {
                    i++;
                    count++;
                }
                if (preCount < count) preCount = count;

            }
            count = 0;
        }

        return preCount;
    }

    static public void firstAndLastLetterAreTheSame(String str) {
        str = str.toLowerCase();
        String[] arrayOfWords = str.split(",");

        for (String word : arrayOfWords
                ) {
            char[] arr = word.toCharArray();
            if (arr[0] == arr[arr.length - 1]) System.out.println(arr);
        }
    }

    static public String lastOfSpace(String str) {
        String newString = new String();
        int different = 0;
        String[] everySrting = str.split("/");
        for (String stroka : everySrting
                ) {
            if (stroka.length() != 60) {
                different = 60 - stroka.length();
                stroka = adder(stroka, different);
                newString += stroka + "." + '\n';
            }
        }
        return newString;
    }

    private static String adder(String str, int different) {
        String fullString = new String();
        int n = 1;
        String[] oops = str.split("[a-z,A-Z]+" + "");
        String[] poops = str.split(" ");

        while (different > 0) {
            oops[n] += " ";
            if (n < oops.length - 1) {
                n++;
            } else {
                n = 1;
            }
            different--;
        }
        for (int i = 1; i < oops.length; i++) {
            fullString += poops[i - 1] + oops[i];
        }
        fullString += poops[poops.length - 1];
        return fullString;
    }

    static public int romanceNumbers(String str) {
        Map<Character, Integer> romanceNumber = new HashMap<>();
        romanceNumber.put('I', 1);
        romanceNumber.put('V', 5);
        romanceNumber.put('X', 10);
        romanceNumber.put('L', 50);
        romanceNumber.put('C', 100);
        romanceNumber.put('D', 500);
        romanceNumber.put('M', 1000);
        int count = 0;
        str = str.toUpperCase();
        char[] arrayOfNumbers = str.toCharArray();
        for (int i = 0; i < arrayOfNumbers.length ; i++) {
            if ((i + 1) != arrayOfNumbers.length && romanceNumber.get(arrayOfNumbers[i + 1]) > romanceNumber.get(arrayOfNumbers[i]) ) {
                    count += romanceNumber.get(arrayOfNumbers[i + 1]) - romanceNumber.get(arrayOfNumbers[i]);
                    i++;
            }else {

                count += romanceNumber.get(arrayOfNumbers[i]);

            }

        }

        return count;
    }
}
