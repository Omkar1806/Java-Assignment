package com.assignment;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Shuffle array problem
        int[] originalArray = {1, 2, 3, 4, 5, 6, 7};

        Random random = new Random();

        for (int i = originalArray.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);

            // Swap elements at index i and index
            int temp = originalArray[i];
            originalArray[i] = originalArray[index];
            originalArray[index] = temp;
        }

        for (int value : originalArray) {
            System.out.print(value + " ");
        }
        System.out.println("");

        System.out.println("---------------------------------------------");

        //Roman number problem
        String romanNumeral = "IX"; // Replace with your Roman numeral input
        int result = romanToInteger(romanNumeral);
        System.out.println("The integer equivalent of " + romanNumeral + " is: " + result);

        System.out.println("---------------------------------------------");

        //Pangram problem
        String sentence = "hi my name is omkar kadam"; // Replace with any sentence
        boolean isPangram = isPangram(sentence);

        if (isPangram) {
            System.out.println("The input is a pangram.");
        } else {
            System.out.println("The input is not a pangram.");
        }
    }
    //Pangram class
    public static boolean isPangram(String sentence) {
        boolean[] alphabetCheck = new boolean[26];

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);

            // If the character is a lowercase letter, mark it as encountered
            if ('a' <= ch && ch <= 'z') {
                alphabetCheck[ch - 'a'] = true;
            }
        }

        // Check if all alphabet letters have been encountered
        for (boolean encountered : alphabetCheck) {
            if (!encountered) {
                return false;
            }
        }

        return true;
    }



    //Roman number class
    public static int romanToInteger(String s) {
        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int value = getValue(s.charAt(i));
            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }
            prevValue = value;
        }
        return result;
    }
    public static int getValue(char romanChar) {
        switch (romanChar) {
            case 'I':
                return 1;
                case 'V':
                    return 5;
                    case 'X':
                        return 10;
                        case 'L':
                            return 50;
                            case 'C':
                                return 100;
                                case 'D':
                                    return 500;
                                    case 'M':
                                        return 1000;
                                        default:
                                            return 0;
        }
    }
}

