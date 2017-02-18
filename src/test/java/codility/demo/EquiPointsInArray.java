package codility.demo;

import java.util.Date;
import java.util.Random;

/**
 * @author <h2><strong>Created by APereira JavaDeveloper,Croydon, UK on 30/01/17.</strong></h2>
 *
 * This is a demo task put on Codility's website which measures programmers ability to solve fiendishly devious problems that they probably might encounter once in a while but who knows in this age of Machine Learning and AI - these Algo skills are probably more in demand. Apparently this is the easiest task. And, I bet it does not stand up to the O(N) complexity of steps fundamental. Probably, works for smaller arrays but not for 100k size arrays.
 *
<pre>
 A zero-indexed array A consisting of N integers is given. An equilibrium index of this array is any integer P such that 0 ≤ P < N and the sum of elements of lower indices is equal to the sum of elements of higher indices, i.e.

 A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].

 Sum of zero elements is assumed to be equal to 0. This can happen if P = 0 or if P = N−1.

 For example, consider the following array A consisting of N = 8 elements:
 A[0] = -1
 A[1] =  3
 A[2] = -4
 A[3] =  5
 A[4] =  1
 A[5] = -6
 A[6] =  2
 A[7] =  1

 P = 1 is an equilibrium index of this array, because:

 A[0] = −1 = A[2] + A[3] + A[4] + A[5] + A[6] + A[7]

 P = 3 is an equilibrium index of this array, because:

 A[0] + A[1] + A[2] = −2 = A[4] + A[5] + A[6] + A[7]

 P = 7 is also an equilibrium index, because:

 A[0] + A[1] + A[2] + A[3] + A[4] + A[5] + A[6] = 0

 and there are no elements with indices greater than 7.

 P = 8 is not an equilibrium index, because it does not fulfill the condition 0 ≤ P < N.

 Write a function:

 class Solution { public int solution(int[] A); }

 that, given a zero-indexed array A consisting of N integers, returns any of its equilibrium indices. The function should return −1 if no equilibrium index exists.

 For example, given array A shown above, the function may return 1, 3 or 7, as explained above.

 Assume that:

 N is an integer within the range [0..100,000];
 each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

 Complexity:

 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

 Elements of input arrays can be modified.

</pre>

 */
public class EquiPointsInArray {

    private int[] arr ;
    private long[][] equiPtsSums ;

    public static final int LEFT = 0 ;
    public static final int RIGHT = 1 ;

    EquiPointsInArray(int[] arr) {
        this.arr = arr;
        equiPtsSums = new long[this.arr.length][2] ;
    }

    void startProcess_v3()
    {
        long startmillis = new Date().getTime();

        long lhssum = 0 ;
        long rhssum = 0 ;
        System.out.println("==== VERSION 3 Gathering sums starting ....");
        boolean backIndexMeetsI = false ;
        boolean oddSizeArray = ((this.arr.length % 2) > 0);
        for (long i = 0 ; i < this.arr.length ; i++)
        {
            if (i == 0)
            {
                lhssum = 0 ;
                equiPtsSums[(int) i][LEFT] = lhssum ; // on the first elem (0) but since there are no elems to the left sum is zero

                lhssum = lhssum + this.arr[(int) i] ; // keep the sum ready for second elem (1)
            }
            else
            {
                equiPtsSums[(int) i][LEFT] = lhssum ; // fill in the second elem (1)
                lhssum = lhssum + this.arr[(int) i] ; // keep the sum ready for the third elem (2)
                                                      // the sum for the last elem will be discarded

            }
//            System.out.println("leftIndex =" + i + " value = " + this.arr[(int) i] + " running leftsum is " + lhssum);

            long backIndex = ((this.arr.length - 1) - i) ;
            if ( backIndex == (this.arr.length - 1) ) // should be the last element
            {
                rhssum = 0 ;
                equiPtsSums[(int) backIndex][RIGHT] = rhssum ; // you are on the last elem - so the sum to the right of that is nothing aka zero

                rhssum = rhssum + this.arr[(int) backIndex];   // keep this sum ready for when the pointer is on the second-last elem
            }
            else
            {
                equiPtsSums[(int) backIndex][RIGHT] = rhssum ; // fill the RHS sum for the second last elem
                rhssum = rhssum + this.arr[(int) backIndex];   // keep the third -last sum ready
                                                               // the sum for the first elem will be discarded
            }
            //          System.out.println("backIndex =" + backIndex + " value = " + this.arr[(int) backIndex] + " running rightsum is " + rhssum);
            //
            // it is imp. that the backIndex crosses over the frontIndex because when they are just one apart they have not yet written their values this is for EVEN sized array
            if ( ((backIndex == i && oddSizeArray) || ( (backIndex - i == -1) && !oddSizeArray)) && backIndexMeetsI == false)
            {
                if (oddSizeArray)
                {
                    System.out.print("\nOdd Size Array backIndex=" + backIndex + " frontIndex=" + i);
                }
                else
                {
                    System.out.print("\nEven Size Array backIndex=" + backIndex + " frontIndex=" + i ) ;
                }

                backIndexMeetsI = true ;
                System.out.println("Now we can start checking for equality ....");
            }
            if (backIndexMeetsI)
            {
                long lftSumShdHaveBeendone = equiPtsSums[(int) backIndex][LEFT] ;
                long rgtSumShdHaveBeendone = equiPtsSums[(int) backIndex][RIGHT] ;
                System.out.print("\nlhssum = " + lftSumShdHaveBeendone);
                System.out.print("\tinputArray[" + backIndex + "] =\t");
                System.out.print(this.arr[(int) backIndex]);
                System.out.print("\t rhssum = " + rgtSumShdHaveBeendone);

                if (lftSumShdHaveBeendone == rgtSumShdHaveBeendone)
                {
                   if (this.isThisDefinedEquiPoint((int) backIndex)) {
                       System.out.print(" VALID EQUI-POINT");
                   } else {
                       //System.out.print("");
                   }
                }

                long lftSumShdHaveBeendoneI = equiPtsSums[(int) i][LEFT] ;
                long rgtSumShdHaveBeendoneI = equiPtsSums[(int) i][RIGHT] ;
                System.out.print("\nlhssum = " + lftSumShdHaveBeendoneI);
                System.out.print("\tinputArray[" + i + "] =\t");
                System.out.print(this.arr[(int) i]);
                System.out.print("\t rhssum = " + rgtSumShdHaveBeendoneI);

                if (lftSumShdHaveBeendoneI == rgtSumShdHaveBeendoneI)
                {
                    if (this.isThisDefinedEquiPoint((int) backIndex)) {
                        System.out.print(" VALID EQUI-POINT");
                    } else {
                        //System.out.print("");
                    }
                }


            }
        }
        System.out.println("\nGathering sums finished");
        System.out.println("equi-points process finished");
        long endmillis = new Date().getTime() ;
        long timetaken = endmillis - startmillis ;
        System.out.println(timetaken + " ms");


    }

    void startProcess_v2()
    {
        long startmillis = new Date().getTime();

        long lhssum = 0 ;
        long rhssum = 0 ;
        System.out.println("====VERSION 2 Gathering sums starting ....");
        for (long i = 0 ; i < this.arr.length ; i++)
        {
            lhssum = lhssum + this.arr[(int)i] ;
            equiPtsSums[(int) i][LEFT] = lhssum ;
            System.out.println("leftIndex =" + i + " value = " + this.arr[(int) i] + " running leftsum is " + lhssum);

            long backIndex = ((this.arr.length - 1) - i) ;
            rhssum = rhssum + this.arr[(int) backIndex];
            equiPtsSums[(int) backIndex][RIGHT] = rhssum ;
            System.out.println("backIndex =" + backIndex + " value = " + this.arr[(int) backIndex] + " running rightsum is " + rhssum);
        }
        System.out.println("Gathering sums finished");

        System.out.println("finding equi-points sums started ...");
        for (long i = 0 ; i < this.arr.length ; i++) {
            lhssum = equiPtsSums[(int) i][LEFT];
            rhssum = equiPtsSums[(int) i][RIGHT];

            System.out.print("lhssum = " + lhssum);
            System.out.print("\tinputArray[" + i + "] =\t");
            System.out.print(this.arr[(int) i]);
            System.out.print("\t rhssum = " + rhssum);

            if (lhssum == rhssum) {
                System.out.print(" lhssum == rhssum ");
                if (this.isThisDefinedEquiPoint((int) i)) {
                    System.out.print(" VALID EQUI-POINT");
                } else {
                    //System.out.print("");
                }
            }
            System.out.print("\n");
        }
        System.out.println("equi-points process finished");
        long endmillis = new Date().getTime() ;
        long timetaken = endmillis - startmillis ;
        System.out.println(timetaken + " ms");

    }

    void startProcess()
    {
        System.out.println("===== VERSION ZERO");
        long startmillis = new Date().getTime();
        for (long i = 0 ; i < this.arr.length ; i++)
        {
            // lhs sum
            long lhssum = 0 ;
            long j = 0 ;
            for ( ; j < i; j++)
            {
                lhssum = lhssum + this.arr[(int)j] ;

            }

            // rhs sum
            long rhssum = 0 ;
            for (long k = i + 1 ; k < this.arr.length ; k++ )
            {
                rhssum = rhssum + this.arr[(int)k] ;
            }

            System.out.print("lhssum = " + lhssum);
            System.out.print("\tinputArray[" + i + "] =\t");
            System.out.print(this.arr[(int)i]);
            System.out.print("\t rhssum = " + rhssum);

            if (lhssum == rhssum)
            {
                System.out.print(" lhssum == rhssum ");
                if (this.isThisDefinedEquiPoint((int)i))
                {
                    System.out.print(" VALID EQUI-POINT");
                }
                else
                {
                    //System.out.print("");
                }
            }
            System.out.print("\n");
        }
        long endmillis = new Date().getTime() ;
        long timetaken = endmillis - startmillis ;
        System.out.println(timetaken + " ms");
    }

    /**
     * <pre>
     *     0 ≤ Pos < N where N is {@link codility.demo.EquiPointsInArray#arr The Holding int Array for your list of numbers} the length of the array for which we need to find these equi-points, Pos here refers to possible equi-points within the array
     * </pre>
     *
     * <strong>What the original problem description from codility does not make simply clear is that an equi-point value in the array is not involved in the lhs sum or the rhs sum</strong>
     *
     * @param pos
     * @return true or false whether this is a valid equi-point to check
     */
    boolean isThisDefinedEquiPoint(int pos)
    {

        return (pos >= 0) && (pos < this.arr.length) ;
    }

    int[] createTestArray(int size) throws Exception
    {
        int[] tmp = new int[size] ;
        if (size >= 0 && size <= 100000)
        {
            Random randGen = new Random();


            for (int l=0 ; l < size; l++)
            {
                //tmp[l] = randGen.nextInt() ;
                tmp[1] = randGen.nextInt(5);
            }

            return tmp ;

        }
        else
        {
            throw new Exception("Size of array is defined as N is an integer within the range [0..100,000]' ");
        }
    }


    public static void main(String...args) throws Exception
    {
        EquiPointsInArray e = new EquiPointsInArray(new int[]{-1,3,-4, 5 ,1,-6 ,2, 1,0} );
        e.startProcess_v2();
        e.startProcess_v3();

//        e = new EquiPointsInArray( e.createTestArray(100000) );
//        //e.startProcess();
//        //e.startProcess_v2();
//        e.startProcess_v3();


        e = new EquiPointsInArray(new int[]{-1,3,-4, 5 ,1,-6 ,2, 1} );
        //e.startProcess();
        //e.startProcess_v2();
        e.startProcess_v3();


        e = new EquiPointsInArray(new int[]{1,-1,3,-4, 5 ,1,-6 ,2, 1,-6789098,-1,3,-4, 5 ,1,-6 ,2, 1,1} );
        //e.startProcess();
        //e.startProcess_v2();
        e.startProcess_v3();

        e = new EquiPointsInArray(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        //e.startProcess();
        //e.startProcess_v2();
        e.startProcess_v3();



//        e = new EquiPointsInArray( e.createTestArray(1000) );
//        e.startProcess();
//        //e.startProcess_v2();
//        e.startProcess_v3();

    }
}
