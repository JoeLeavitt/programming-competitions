/**
 * Created by JL on 1/15/16.
 */

import java.util.*;

public class passwords {

    public static void main(String[] args)
    {
        Scanner scanf = new Scanner(System.in);

        int testCases = scanf.nextInt();
        String[][] allCases = new String[testCases][];
        int[] ranks = new int[testCases];
        int[] passwordLengths = new int[testCases];

        for(int i = 0; i < testCases; i++)
        {
            int numwords = scanf.nextInt();
            passwordLengths[i] = numwords;
            String[] wordAr = new String[numwords];
            allCases[i] = wordAr;

            for(int j = 0; j < numwords; j++)
            {
                wordAr[j] = scanf.next();
            }

            int rank = scanf.nextInt();

            ranks[i] = rank;
        }

        for(int i = 0; i < testCases; i++)
        {
            solve(0, 0, allCases[i], ranks[i], new int[passwordLengths[i]]);
        }
    }

    public static int solve(int p, int k, String[] sets, int rank, int[] used)
    {
        if(p == sets.length)
        {
            if(k + 1 == rank)
            {
                for(int i = 0; i < used.length; i++)
                {
                    System.out.print(sets[i].charAt(used[i]));
                }
                System.out.println();
            }
            return k + 1;
        }

        for(int j = 0; j < sets[p].length(); j++)
        {
            used[p] = j;
            k = solve(p + 1, k, sets, rank, used);
            if(k == rank)
                break;
        }

        return k;
    }
}
