/**
 * Created by JL on 1/29/16.
 */

import java.util.*;

public class monkey {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int testCases = Integer.parseInt(stdin.nextLine().trim());

        for(int i = 1; i <= testCases; i++) {
            String str = stdin.nextLine();

            int answer = solve(str);

            System.out.println(i + " " + answer);
        }
    }

    public static int solve(String str) {
        int count = 0;
        int max = 0;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '[') {
                count++;
                if(count > max) {
                    max = count;
                }
            }
            else if(str.charAt(i) == ']') {
                count--;
            }

            if(count > 25) {
                continue;
            }
        }
        return 1 << max;
    }
}
