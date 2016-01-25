/**
 * Created by JL on 1/14/16.
 */

import java.util.*;

public class movie {

    public static int calculate(int tickets, int pizza)
    {
        int total = 0;

        if(tickets >= 10)
            total = 10 * tickets + pizza;
        else
            total = 10 * tickets + (pizza * 2);

        return total;
    }

    public static void main(String args[])
    {
        Scanner stdin = new Scanner(System.in);

        int testCases = stdin.nextInt();

        for(int i = 0; i < testCases; i++)
        {
            int tickets = stdin.nextInt();
            int pizza = stdin.nextInt();

            int total = calculate(tickets, pizza);

            System.out.println(total);
        }

    }
}
