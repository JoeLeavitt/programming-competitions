/**
 * Created by JL on 1/15/16.
 */

import java.util.*;

public class upwards {

    public static void main(String[] args)
    {
        Scanner scanf = new Scanner(System.in);

        int testCases = scanf.nextInt();

        for(int i = 0; i < testCases; i++)
        {
            String word = scanf.next();
            HashSet<Character> set = new HashSet<Character>();
            boolean flag = true;

            for(int j = 0; j < word.length(); j++)
            {
                if(set.contains(word.charAt(j))){
                    System.out.println("NO");
                    flag = false;
                    break;
                }
                else
                    set.add(word.charAt(j));

                if(j != word.length() -1) {
                    if ((int) word.charAt(j) > (int) word.charAt(j + 1)) {
                        System.out.println("NO");
                        flag = false;
                        break;
                    }
                }
            }

            set.clear();
            if(flag == true)
                System.out.println("YES");

        }
    }
}
