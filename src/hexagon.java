/**
 * Created by JL on 1/15/16.
 */

import java.util.*;

public class hexagon
{
    public static int totalBlocks = 7;
    public static int outerBlocks = 6;

    public static void main(String[] args)
    {
        Scanner scanf = new Scanner(System.in);
        int testCases = scanf.nextInt();

        for (int currCase = 1; currCase < testCases + 1; currCase++) {

            int[][] shapeAsMatrix = new int[totalBlocks][outerBlocks];

            for (int i = 0; i < totalBlocks; i++)
            {
                for (int j = 0; j < outerBlocks; j++)
                {
                    shapeAsMatrix[i][j] = scanf.nextInt();
                }
            }

            int[] permuteSet = new int[totalBlocks];
            boolean[] usedSet = new boolean[totalBlocks];

            // permute -> solve with rotations
            int[] solutionSet = permutate(shapeAsMatrix, usedSet, permuteSet, 0);

            if (solutionSet == null)
                System.out.println("Case " + currCase + ": No solution");
            else
            {
                System.out.print("Case " + currCase + ":");

                for (int i = 0; i < totalBlocks; i++)
                    System.out.print(" " + solutionSet[i]);

                System.out.println();
            }
        }
    }

    public static int[] permutate(int[][] shapeAsMatrix, boolean[] usedSet, int[] permuteSet, int k)
    {
        if (k == totalBlocks)
        {
            if (solve(shapeAsMatrix, permuteSet))
                return permuteSet;
            else
                return null;
        }

        for (int i = 0; i < totalBlocks; i++)
        {
            if (usedSet[i] == false)
            {
                usedSet[i] = true;
                permuteSet[k] = i;
                int[] temp = permutate(shapeAsMatrix, usedSet, permuteSet, k+1);

                if (temp != null)
                    return temp;

                usedSet[i] = false;
            }
        }

        return null;
    }

    public static boolean solve(int[][] shapeAsMatrix, int[] permuteSet)
    {
        int[][] split = new int[totalBlocks][];

        for (int i = 0; i < totalBlocks; i++)
            split[i] = shapeAsMatrix[permuteSet[i]];

        rotateBlock(split[0], 0, 1);

        for (int i = 1; i < totalBlocks; i++)
            rotateBlock(split[i], (i + 2) % outerBlocks, split[0][i - 1]);

        for (int i = 1; i < totalBlocks; i++)
        {
            int next = i+1;

            if (next >= totalBlocks) next = 1;

            if (split[i][(i + 1) % outerBlocks] != split[next][(i + 4) % outerBlocks])
                return false;
        }

        return true;
    }

    public static void rotateBlock(int[] block, int matchCheck, int splitVal)
    {
        while (block[matchCheck] != splitVal)
        {
            int place = block[0];

            for(int i = 1; i < outerBlocks; i++)
                block[i - 1] = block[i];

            block[outerBlocks - 1] = place;
        }
    }
}