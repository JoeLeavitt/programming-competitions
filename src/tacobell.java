/**
 * Created by JL on 1/14/16.
 */

import java.util.*;

public class tacobell {

    public static void main(String[] args)
    {
        Scanner scanf = new Scanner(System.in);

        int testCases = scanf.nextInt();

        for(int i = 0; i < testCases; i++)
        {
            int items = scanf.nextInt();
            int runs = scanf.nextInt();

            String[] menuItems = new String[items];

            for(int j = 0; j < items; j++) {
                menuItems[j] = scanf.next();
            }

            Arrays.sort(menuItems, Collections.reverseOrder());
            combinations(0, runs, 0, new String[runs], menuItems);
            System.out.println();
        }
    }

    public static void combinations(int p, int k, int size, String[] subset, String[] set)
    {
        if(set.length - p < k - size) return;
        if(size == k)
        {
            for(int i = subset.length -1; i >= 0; i--)
            {
                System.out.print(subset[i] + " ");
            }

            System.out.println();
            return;
        }

        combinations(p + 1, k, size, subset, set);
        subset[size] = set[p];
        combinations(p + 1, k, size + 1, subset, set);
    }
}
