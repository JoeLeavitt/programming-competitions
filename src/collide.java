/**
 * Created by JL on 2/19/16.
 */

import java.util.*;

public class collide {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int system = stdin.nextInt();
        int systemNum = 1;

        while(system != 0) {
            long total = 0;
            boolean firstPass = true;
            boolean flag = false;

            for(int i = 0; i < system; i++) {
                int currPlanet = 0;

                if(flag == true){
                    int blank = stdin.nextInt();
                    continue;
                }

                if (firstPass == true) {
                    currPlanet = stdin.nextInt();
                    long placeHolder = 1;
                    total = LCM(placeHolder, currPlanet);
                    firstPass = false;
                }
                else if(firstPass == false) {
                    currPlanet = stdin.nextInt();
                    total = LCM(total, currPlanet);
                }

                if(total >= 2147483647.1) flag = true;
            }

            if(total <= 2147483647) {
                System.out.println(systemNum + ": THE WORLD ENDS IN " + total + " DAYS");
            }
            else if(total > 2147483647) {
                System.out.println(systemNum + ": NOT TO WORRY");
            }

            systemNum++;
            system = stdin.nextInt();
        }
    }

    public static long GCD(long a, long b) {
        return b == 0 ? a : GCD(b, a % b);
    }

    public static long LCM(long a, long b) {
        return a * (b/GCD(a, b));
    }
}
