/**
 * Created by JL on 1/14/16.
 */

import java.util.*;

public class anya
{
    public static void main(String args[])
    {
        Scanner scanf = new Scanner(System.in);

        int testCases = Integer.parseInt(scanf.nextLine().trim());

        for(int i = 0; i < testCases; i++)
        {
            StringTokenizer sentence = new StringTokenizer(scanf.nextLine());
            StringBuilder finalString = new StringBuilder();

            int count = 0;
            while(sentence.hasMoreElements())
            {
                String word = sentence.nextToken();

                finalString.append(word);

                if(checkPalindrome(word) == true)
                    count++;
            }

            String total = finalString.toString();

            if(count >= 2 || checkPalindrome(total) == true)
                System.out.println("Ay");
            else
                System.out.println("Nap");

            finalString.setLength(0);
        }
    }

    public static boolean checkPalindrome(String word)
    {
        char[] letters = word.toCharArray();
        int length = word.length();
        int right = word.length() - 1;

        for(int i = 0; i < length/2; i++)
        {
            if(letters[i] != letters[right])
                return false;
            else
                right--;
        }

        return true;
    }
}
