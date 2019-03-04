import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    //cde
    //abc
    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        int count = 0;
        List<Character> evaluatedChars = new ArrayList<Character>();

        for(int i = 0; i < s1.length(); i++){
            char searchedChar = s1.charAt(i);

            if(evaluatedChars.contains(searchedChar)) continue;

            int s1Ocorrences = countOccurences(s1, searchedChar, 0);
            int s2Ocorrences = countOccurences(s2, searchedChar, 0);

            if(s1Ocorrences != s2Ocorrences) {
                count += Math.abs(s1Ocorrences - s2Ocorrences);
            }
            evaluatedChars.add(searchedChar);
        }

        for(int i = 0; i< s2.length(); i++){
            char searchedChar = s2.charAt(i);

            if(evaluatedChars.contains(searchedChar)) continue;

            int s1Ocorrences = countOccurences(s1, searchedChar, 0);
            int s2Ocorrences = countOccurences(s2, searchedChar, 0);

            if(s1Ocorrences != s2Ocorrences) {
                count += Math.abs(s1Ocorrences - s2Ocorrences);
            }
            evaluatedChars.add(searchedChar);
        }

        return count;
    }

    static int countOccurences(String text, char searchedChar, int index ){

        if(index >= text.length()){
            return 0;
        }

        int count = text.charAt(index) == searchedChar ? 1 : 0;

        return count + countOccurences(text, searchedChar, index +1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
