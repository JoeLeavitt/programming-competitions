/**
 * Created by JL on 1/22/16.
 */

import java.util.*;

public class conference {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int testCases = stdin.nextInt();

        for(int i = 0; i < testCases; i++) {
            int conferences = stdin.nextInt();

            ArrayList<Pair> pairs = new ArrayList<Pair>();

            for(int j = 0; j < conferences; j++) {
                int start = stdin.nextInt();
                int length = stdin.nextInt();

                pairs.add(new Pair(start,length));
            }
            Collections.sort(pairs);

            int total = 0;
            int maxProfit = calculate(pairs, total);

            System.out.println(maxProfit);
        }

    }

    private static int calculate(ArrayList<Pair> pairs, int total) {
        int totalDays = 30;
        int[] flag = new int[pairs.size()];
        boolean checker = true;

        for (int i = 0; i < flag.length; i++) {
            flag[i] = -1;
        }

        for (int i = 0; i < pairs.size(); i++) {
            int startingPower = 29 - pairs.get(i).start;
            int iterations = pairs.get(i).length;
            int daysUsed = pairs.get(i).length;

            checker = true;

            for (int j = 0; j < flag.length; j++) {
                if (pairs.get(i).start < flag[j]) {
                    checker = false;
                }
            }

            if (checker == false) continue;

            for (int j = 0; j < iterations; j++) {
                total += Math.pow(2, startingPower);
                startingPower--;
            }

            flag[i] = pairs.get(i).start + pairs.get(i).length;

            totalDays = totalDays - daysUsed;

            if (totalDays <= 0) break;
    }

        return total;
    }
}

class Pair implements Comparable<Pair> {
    int start;
    int length;

    public Pair(int start, int length) {
        this.start = start;
        this.length = length;
    }

    @Override
    public int compareTo(Pair next) {
        if(start < next.start)
            return -1;
        else if(next.start > start)
            return 1;
        else
            return 0;
    }
}
