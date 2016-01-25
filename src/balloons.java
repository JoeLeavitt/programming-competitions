/**
 * Created by JL on 1/22/16.
 */

import java.lang.reflect.Array;
import java.util.*;

public class balloons {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int balloonsA = stdin.nextInt();
        int balloonsB = stdin.nextInt();

        ArrayList<Data> set = new ArrayList<Data>();

        while (n != 0 || balloonsA != 0 || balloonsB != 0) {
            for (int i = 0; i < n; i++) {
                int numBalloons = stdin.nextInt();
                int distA = stdin.nextInt();
                int distB = stdin.nextInt();

                set.add(new Data(numBalloons, distA, distB));
            }

            Collections.sort(set);

            //for(Data data : set) {
             //   System.out.println(data.numBalloons + " " + data.distanceA + " " + data.distanceB);
            //}

            int minimumDistance = solve(set, balloonsA, balloonsB);
            System.out.println(minimumDistance);
            set.clear();

            n = stdin.nextInt();
            balloonsA = stdin.nextInt();
            balloonsB = stdin.nextInt();
        }
    }

    public static int solve(ArrayList<Data> data, int A, int B) {

        int distance = 0;

        data.toArray();

        for (int i=0; i<data.size(); i++) {
            int ballA = 0;

            if (data.get(i).distanceA < data.get(i).distanceB)
                ballA = Math.min(A, data.get(i).numBalloons);
            else
                ballA = data.get(i).numBalloons - Math.min(B, data.get(i).numBalloons);

            int ballB = data.get(i).numBalloons - ballA;

            distance = distance + ballA * data.get(i).distanceA + ballB * data.get(i).distanceB;
            A -= ballA;
            B -= ballB;
        }

        return distance;
    }
}
class Data implements Comparable<Data> {
    int numBalloons;
    int distanceA;
    int distanceB;

    public Data(int distanceA, int distanceB, int numBalloons) {
        this.numBalloons = distanceA;
        this.distanceA = distanceB;
        this.distanceB = numBalloons;
    }

    @Override
    public int compareTo(Data next) {
        return (Math.abs(next.distanceA - next.distanceB) -
                Math.abs(distanceA - distanceB));
    }
}
