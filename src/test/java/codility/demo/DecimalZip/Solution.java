package codility.demo.DecimalZip;

/**
 * @author Created by APereira JavaDeveloper,Croydon, UK on 05/02/17.
 *
<pre>
The order is: byte 8 bits, short 16 bits, int 32 bits, long 64 bits.
width                     minimum                         maximum
byte:   8 bit                        -128                            +127
short: 16 bit                     -32 768                         +32 767
int:   32 bit              -2 147 483 648                  +2 147 483 647
long:  64 bit  -9 223 372 036 854 775 808      +9 223 372 036 854 775 807
All types are signed, there are no unsigned versions. However, bit manipulations treat the numbers as they were unsigned (that is, handling all bits correctly).
</pre>
 *
 */
public class Solution {

    int a ; String sa ;
    int b ; String sb ;

    private Solution(int pa, int pb) throws Exception
    {
       this.a = this.testInput(pa) ;
       this.b = this.testInput(pb) ;

       this.sa = new Integer(this.a).toString();
       this.sb = new Integer(this.b).toString();
    }

    /**
     * This is annoying codility restriction - otherwise you would discuss this implementation detail as a requirement with the users
     *
     * @param A
     * @param B
     * @return
     * @throws Exception
     */
    public static int solution(int A, int B) throws Exception {
        return new Solution(A,B).calcDeciZip();
    }




    private int testInput(int x) throws Exception
    {
        System.out.println("Validating input value " + x );
        if (x >= 0 && x <= 100_000_000)
        {
            return x ;
        }
        else
        {
            throw new Exception(" Invalid input value A or B integer should be between+inclusive 0 - 100 million");
        }
    }

    private int calcDeciZip()
    {
        int rtnValue = -1 ;
        StringBuilder tmp = new StringBuilder(this.sa.length() + this.sb.length()) ;

        int a = 0 ; int b = 0;
        for (; a < this.sa.length() ; a++)
        {
            tmp.append(this.sa.charAt(a)) ;

            for (  ; b < this.sb.length() ; b++)
            {
                tmp.append(this.sb.charAt(b)) ;
                if ( a == (this.sa.length() -1) ) // the outer loop is on it's last elem - finish the inner loop
                {
                    // dont break out finish the concatenation
                }
                else
                {
                    b++ ;
                    break;
                }
            }
        }
        return this.testResult(tmp.toString().trim()) ;
    }


    private int testResult(String deciZipResult)
    {
        long test = new Long(deciZipResult).longValue(); // just in case the DeciZip created is more than what an int can accommodate
        if ( test < 0 || test > 100_000_000L )
        {
            System.out.println(deciZipResult + " (RtnCode=-1) result ranges should be 0 to 100 million so we are returning - plus we induce from assumption that 2 +ve numbers should give another ALWAYS +ve number");
            return -1 ;
        }
        else
        {
            int testA = Integer.parseInt(deciZipResult);
            System.out.println("DecimalZipResult=" + testA);
            return testA;
        }
    }

    public static void main(String ... args) throws Exception
    {
        Solution.solution(100_000_000,0) ;              //dzD.calcDeciZip();
        Solution.solution(100_000_000,1) ;  //dzE.calcDeciZip();
        Solution.solution(0,100_000_000) ;  //dz0.calcDeciZip();
        Solution.solution(12,56) ;          //dz1.calcDeciZip();
        Solution.solution(56,12) ;          //dz2.calcDeciZip();
        Solution.solution(12345,678) ;      //dz3.calcDeciZip();
        Solution.solution(123,67890) ;      //dz4.calcDeciZip();
        Solution.solution(1234,0) ;         //dz5.calcDeciZip();
/*
//      Test Cases for Result within the range of acceptable results
        Solution dz6 = new Solution(0,0);
        int rtnValue = dz6.testResult("100000001") ;
        if ( (rtnValue == -1) == false)
        {
            System.out.println("Decimal Zip calculated is " + rtnValue);
        }

        rtnValue = dz6.testResult( new Integer(Integer.MAX_VALUE).toString()) ;
        if ( (rtnValue == -1) == false)
        {
            System.out.println("Decimal Zip calculated is " + rtnValue);
        }

        rtnValue = dz6.testResult( new Integer(Integer.MAX_VALUE + 1).toString()) ;
        if ( (rtnValue == -1) == false)
        {
            System.out.println("Decimal Zip calculated is " + rtnValue);
        }

        rtnValue = dz6.testResult( new Integer(0).toString()) ;
        if ( (rtnValue == -1) == false)
        {
            System.out.println("Decimal Zip calculated is " + rtnValue);
        }

        rtnValue = dz6.testResult( new Integer(-1).toString()) ;
        if ( (rtnValue == -1) == false)
        {
            System.out.println("Decimal Zip calculated is " + rtnValue);
        }
*/
//        Test Cases for Incorrect Input - Uncomment to test
//
//        Solution dzA = new Solution(-1,100_000_000) ;
          Solution.solution(0,100_000_001) ;
//        Solution dzC = new Solution(100_000_001,0) ;
//        Solution dzD = new Solution(100_000_000,-1) ;


    }




}
