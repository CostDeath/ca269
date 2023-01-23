// package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VowelAge {

    public static int countChars(String s, String c) {
        int count = 0;
        // Check if char is in string
        while(s.contains(c)) {
            // If so, remove it and increment the count
            s = s.replaceFirst(c, "-");
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // Take in input
        String name = in.readLine();
        int age = Integer.parseInt(in.readLine());

        // Count vowels
        String checker = name.toLowerCase();
        String[] vowels = {"a", "e", "i", "o", "u"};
        int vowelCount = 0;
        for (String vowel : vowels) {
            vowelCount += countChars(checker, vowel);
        }

        // Check if adult
        String identity;
        if(age < 18) {
            identity = "a minor";
        }
        else {
            identity = "an adult";
        }

        // Output
        System.out.println("Hello " + name + ", you have " + vowelCount + " vowels, and you are " + identity);
    }
}
