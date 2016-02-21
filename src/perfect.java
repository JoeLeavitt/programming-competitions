/**
 * Created by JL on 2/19/16.
 */

import java.util.*;

public class perfect {
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        int testCases = stdin.nextInt();

        for(int i = 0; i < testCases; i++) {
            long number = stdin.nextLong();
            long sum = 0;
            long modBy = 2;

            while(modBy < Math.sqrt(number)) {
                if(number % modBy == 0) {
                    sum += modBy;

                    if(sum > number) break;
                    long quotient = number/modBy;
                    sum +=quotient;
                }
                modBy++;
            }

            sum += 1;

            if(sum < number)
                System.out.println("defective");
            else if(sum > number)
                System.out.println("abundant");
            else if(sum == number)
                System.out.println("perfect");

        }
    }
}
