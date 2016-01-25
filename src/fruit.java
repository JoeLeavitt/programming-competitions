/**
 * Created by JL on 1/22/16.
 */

import java.util.*;

public class fruit {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);

      int testCases = stdin.nextInt();

      for(int i = 0; i < testCases; i++) {
         int length = stdin.nextInt();
         int[] nums = new int[length];
         int j = 0, remainder = 0;

         for(j = 0; j < length; j++) {
            nums[j] = stdin.nextInt();
         }

         j = 0;
         int minFruits = 0;
         while (j <= 1000) {
            minFruits = checkMatch(j, nums);

            if(minFruits != -1){
               break;
            }

            j++;
         }

         remainder = getRemainder(minFruits, nums);
         System.out.println(minFruits + " " + remainder);
      }
   }

   public static int checkMatch(int currentMatch, int numbers[]) {
      int remainder = 0;

      for(int i = 0; i < numbers.length; i++) {
         if (currentMatch + remainder < numbers[i])
            return  -1;

         if (currentMatch + remainder >= numbers[i]) {
            remainder = currentMatch + remainder - numbers[i];
         }
      }

      return currentMatch;
   }

   public static int getRemainder(int minFruits, int numbers[]) {
      int remainder = minFruits - numbers[0];
      int maxRemainder = minFruits - numbers[0];

      for(int i = 1; i < numbers.length; i++) {
         remainder = remainder + minFruits - numbers[i];

         if(remainder > maxRemainder)
            maxRemainder = remainder;
      }

      return maxRemainder;
   }
}
