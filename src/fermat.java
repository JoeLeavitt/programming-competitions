/**
 * Created by JL on 2/19/16.
 */

import java.util.*;

public class fermat {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int lower = stdin.nextInt();
        int upper = stdin.nextInt();

        boolean[] isPrimeList = primeSieve(1000000);

        while(lower != -1 || upper != -1) {
            int lb = Math.max(0, lower);
            int ub = Math.max(0, upper);

            int totalPrimes = 0;
            int sumSqPrimes = 0;

            for(int i = lb; i <= ub; i++) {
                if(isPrimeList[i] == true) {
                    totalPrimes++;

                    if(i % 4 == 1 || i == 2) {
                        sumSqPrimes++;
                    }
                }
            }

            System.out.println(lower + " " + upper + " " + totalPrimes + " " + sumSqPrimes);
            lower = stdin.nextInt();
            upper = stdin.nextInt();
        }
    }

    public static boolean[] primeSieve(int N) {
        boolean[] isPrimeList = new boolean[N + 1];
        Arrays.fill(isPrimeList, true);

        isPrimeList[0] = false;
        isPrimeList[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrimeList[i]) {
                for (int j = i; i * j <= N; j++) {
                    isPrimeList[i * j] = false;
                }
            }
        }

        return isPrimeList;
    }
}
