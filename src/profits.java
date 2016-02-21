/**
 * Created by JL on 2/19/16.
 */

import java.util.*;

public class profits {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int count = stdin.nextInt();

        while(count != 0) {
            int[] numbers = new int[count];

            for(int i = 0; i < count; i++) {
                numbers[i] = stdin.nextInt();
            }

            int max = mcss(numbers);

            System.out.println(max);

            count = stdin.nextInt();
        }
    }

    public static int mcss(int[] vals) {
        int max = vals[0], sum=0;

        for (int j=0; j<vals.length; j++) {
            sum += vals[j];

            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

}
