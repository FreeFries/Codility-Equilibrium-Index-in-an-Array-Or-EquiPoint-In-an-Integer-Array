package codility.demo.HighestPowerOfTwo;

import java.util.*;

/**
 * @author Created by APereira JavaDeveloper,Croydon, UK on 05/02/17.
 */
class Solution {

    private static TreeMap<Integer,Integer> powerOf2Table = new TreeMap<Integer,Integer>() ;

    private enum TreeMapHolder
    {
        ; // todo Understand this - allowd us to have an empty final holder
        private TreeMapHolder()
        {

        }
    }

    // early initialization
    static
    {
        if (Solution.powerOf2Table.isEmpty()) {
            Solution.makeTable();
        }
        else
        {
            System.out.println("Table already built");
        }
    }

    private int TraverseTreeMapBackwards_v1(int N)
    {
        Set<Integer> keysOnly = Solution.powerOf2Table.keySet() ;
        List test = new ArrayList<Integer>(keysOnly);

        int closestValue = Solution.powerOf2Table.floorKey(N);
        int posClosestIdx = test.indexOf(closestValue);
        boolean foundPowerOf2ThatDivides = false ;
        System.out.println(test.get(posClosestIdx));
        for (; posClosestIdx >= 0; posClosestIdx--) {

            int value = (Integer) test.get(posClosestIdx);
            System.out.println(value);
            if (N % value == 0)
            {

                System.out.println( "2 ^ " + Solution.powerOf2Table.get(N) );
                foundPowerOf2ThatDivides = true ;
                return Solution.powerOf2Table.get(N) ;
            }
            else
            {
                // continue checking
            }

        }
        if (!foundPowerOf2ThatDivides)
        {
            System.out.println("Unable to find Power Of 2 that divides " + N + " rtning -1");
            return -1 ;
        }

        System.out.println("Should not return -2 - faulty logic !!!");
        return -2 ;
    }

    private int TraverseTreeMapBackwards_v2(int N) {

        boolean foundPowerOf2ThatDivides = false;
        List test =  new ArrayList<Integer>(Solution.powerOf2Table.keySet())       ;
        int closestValue;
        int posClosestIdx;
        closestValue = Solution.powerOf2Table.floorKey(N);
        posClosestIdx = test.indexOf(closestValue);
        System.out.println("Closest Value to traverse backwards is " + test.get(posClosestIdx));

        ListIterator<Integer> listIterator = test.listIterator(posClosestIdx); // places the iterator at the correct position for it to iterate todo very imp. took days
        while (listIterator.hasPrevious()) //for ( ; listIterator.hasPrevious(); listIterator.previousIndex()  ) {
        {
            String tmp = " <= value of listIterator.previousIndex()=" + listIterator.previousIndex();
            int val = (int)listIterator.previous();
            System.out.println("Solution.TraverseTreeMapBackwards_v2 " + val + tmp );
            if (N % val == 0)
            {
                System.out.println( "2 ^ " + Solution.powerOf2Table.get(val) + " divides " + N );
                foundPowerOf2ThatDivides = true ;
                return val ;
            }
            else
            {
                // continue checking
            }
        }
        if (!foundPowerOf2ThatDivides)
        {
            System.out.println("Unable to find Power Of 2 that divides " + N + " rtning -1");
            return -1 ;
        }

        System.out.println("Should not return -2 - faulty logic !!!");
        return -2 ;
    }


    public static int solution(int N)
    {
        Solution x = new Solution();
        int origN = N ;

        if (N >= 1 && N <= 1000_000_000) {

            System.out.println("testing " + N);
            return x.TraverseTreeMapBackwards_v2(N);

        }
        else
        {
            System.out.println( "N=" + N + " has to be in the range of N >= 1 && N <= 1000_000_000");
            return -1 ;
        }

    }

    public static int solution_old(int N) {
        Solution x = new Solution();
        int origN = N ;

        if (N >= 1 && N <= 1000_000_000) {

            System.out.println("testing " + N);

            int closestValue = x.powerOf2Table.floorKey(N); // get to the closest and traverse upwards


            int chkRemainder = N % closestValue ;
            if (chkRemainder == 0)
            {
                System.out.println("you have found your answer - no need to go up the table - testing ");
            }
            else
            {
                // traverse further down the table
                boolean found = true ;
                while (found)
                {
                    int test = closestValue /2 ;
                    System.out.println("testing " + test);
                    Integer closestValueTest = x.powerOf2Table.floorKey(test);
                    if (closestValueTest == null)
                    {
                        System.out.println(test + " not found");
                        found = false ;
                        break ;

                    }
                    else
                    {
                        chkRemainder = origN % closestValueTest ;
                        if (chkRemainder == 0)
                        {
                            System.out.println("remainder is zero for " + origN + "/" + closestValueTest);
                            closestValue = closestValueTest ;
                            found = false ;
                            break ;
                        }
                        else {

                            origN = test;
                            System.out.println("continue testing with " + origN);
                        }
                    }


                }
            }

            int highestPowerOf2 = x.powerOf2Table.get(closestValue).intValue(); // actually autoboxing would have worked but I like to know what I am handling if I can

            System.out.println("N=" + N + " matches closest PowersOf2 which is " + closestValue + " this computes as 2 ^ " + highestPowerOf2 + " K=" + highestPowerOf2);

            return highestPowerOf2;
        }
        else
        {
            System.out.println( "N=" + N + " has to be in the range of N >= 1 && N <= 1000_000_000");
            return -1 ;
        }

    }

    /**
     * Table is built big enough to take care of N = 1 to 1000 million
     */
    private static void makeTable()
    {
        boolean breakFlag = false ;
        //max integer       2_147_483_647
        //for (int i = 0; i < 1_000_000_000; i++) {
        for (int i = 0; i < 32; i++) {
            if (breakFlag == true)
            {
                System.out.println("Build 2 power table stopped");
                break ;
            }
            int endN = i + 1 ;
            long valueTmp = 1 ;
            for ( int j = 0  ; j < endN ; j++)
            {
                if (j == 0) {
                    //valueTmp = 1; this is done already in initialization of this value
                }
                else
                {
                    valueTmp = valueTmp * 2  ;
                }
            }

            long key =  i ;

            if ( valueTmp <= Integer.MAX_VALUE)
            {
                powerOf2Table.put((int)valueTmp, (int)key);
                System.out.println(valueTmp + " is 2 ^ " + key);
            }
            else
            {
                System.out.println("2 ^" + i + " Exceeds 2_147_483_647 === WARNING NOTED because value of key now takes into consideration N is an input integer range [1 ... 1,000,000,000] stops building Table");
                breakFlag = true ;

            }


        }
    }

    public static void main(String ... args) throws Exception
    {
        Solution.solution(1);
        Solution.solution(2);
        Solution.solution(3);
        Solution.solution(24);
        Solution.solution(16);
        Solution.solution(4095);
        Solution.solution(4096);
        Solution.solution(536870910);
        Solution.solution(536870912);
        Solution.solution(536870914);

/*
        Solution.solution(0);
        Solution.solution(1);
        Solution.solution(4095);
        Solution.solution(4096);
        Solution.solution(4097);
        Solution.solution(1000_000_000);
        Solution.solution(1000_000_001);

*/


        /*
        Solution x = new Solution() ;
        try {
            x.makeTable();

            System.out.println(x.powerOf2Table.floorKey(1));
            System.out.println(x.powerOf2Table.floorKey(4095));
            System.out.println(x.powerOf2Table.floorKey(4096));
            System.out.println(x.powerOf2Table.floorKey(4097));
            System.out.println(x.powerOf2Table.floorKey(1000_000_000));
        }
        catch(Exception ee)
        {
            ee.printStackTrace();

        }
        */






    }
}
