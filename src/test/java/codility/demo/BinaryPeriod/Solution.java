package codility.demo.BinaryPeriod;

/**
 * Created by APereira JavaDeveloper,Croydon, UK on 06/02/1l7.
 */
class Solution {
    int solution(int n) {
        System.out.print(n + " ");
        int[] d = new int[30];
        int l = 29;
        int p;
        while (n > 0) {

            d[l] = (n % 2);
            System.out.print(d[l]);
            n = n/2;
            l--;
        }
        System.out.println("\nbinary rep created l=" + l);
        for (p = 1; p < 1 + l; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }

    public void convert(int decimal )
    {
        int result = 0;
        int multiplier = 1;

        while(decimal > 0)
        {
            int residue = decimal % 2;
            System.out.print("residue=" + residue + " ");

            decimal     = decimal / 2 ;
            System.out.print("decimal=" + decimal + " ");

            result      = result + residue * multiplier;
            System.out.print("result=" + result + " ");

            multiplier  = multiplier * 10;
            System.out.println("mulitplier=" + multiplier );
        }

        System.out.println (" binary....." + result);
    }

    public static void main(String ... args)
    {
        System.out.println(   new Solution().solution(6) );

        /*new Solution().convert(1,2);
        new Solution().convert(2,2);
        new Solution().convert(3,2);
        new Solution().convert(4,2);
        new Solution().convert(10,2);
*/
/*
        new Solution().convert(4);
        new Solution().convert(5);
        new Solution().convert(6);
        new Solution().convert(7);
*/

/*
        System.out.println(   new Solution().solution(1) );
        System.out.println(   new Solution().solution(2) );
        System.out.println(   new Solution().solution(3) );
        System.out.println(   new Solution().solution(4) );
*/
        /*
        System.out.println(   new Solution().solution(10) );
        System.out.println(   new Solution().solution(146) );
        System.out.println(   new Solution().solution(955) );
        System.out.println(   new Solution().solution(45) );
        */
    }
}