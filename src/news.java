/**
 * Created by JL on 1/29/16.
 */

import java.util.*;

public class news {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int testCases = stdin.nextInt();

        for (int i = 0; i < testCases; i++) {
            int employees = stdin.nextInt();

            ArrayList[] tree = new ArrayList[employees];

            for (int j = 0; j < employees; j++) {
                tree[j] = new ArrayList<Integer>();
            }

            for (int j = 1; j < employees; j++) {
                int parent = stdin.nextInt();

                tree[parent].add(j);
            }

            int solution = solve(tree, 0);

            System.out.println(solution);
        }
    }

    public static int solve(ArrayList[] tree, int index) {
        ArrayList<Integer> values = new ArrayList<>();
        int minTime = 0;

        for(int i = 0; i < tree[index].size(); i++) {
           values.add(solve(tree, (Integer) tree[index].get(i)));
        }

        Collections.sort(values, Collections.reverseOrder());

        for (int i = 0; i < values.size(); i++) {
            int curr = values.get(i);

            if (curr + i + 1 > minTime) {
                minTime = curr + i + 1;
            }
        }

        return minTime;
    }
}