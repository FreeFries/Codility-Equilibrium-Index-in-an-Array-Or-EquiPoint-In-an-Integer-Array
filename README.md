# Codility-Solutions

## [(1) Solution Link for Codility's Equi-Point Array Problem](https://github.com/FreeFries/Codility-Solutions/blob/master/src/test/java/codility/demo/EquiPointsInArray.java "Clicking this link takes you to the source-code")

### What is the gist (should this have been a github gist) of the problem posed by Codility ?
--------------------------------------------------------------------------------------------

<<<<<<< HEAD
Basically, Codility wants you to traverse an array of numbers (ints) and at every point it wants you to calculate a sum to the LHS of that position in the array and a sum to the RHS as well. If, the sums match you should report that position of that array since it is an **"equi-point"**. By the way what is not made clear is that none of the sums include the point of the array you are currently in. The problem is worded in so much mathematical jargon that most of your time to solve this programming riddle is wasted in understanding what they really want you to do.

To make matters worst it should be performant. Effectively you should

Basically, Codility wants you to traverse an array of numbers (ints) and at every point it wants you to calculate a sum to the LHS of that position in the array and a sum to the RHS as well. If, the sums match you should report that position of that array since it is an **"equi-point"**. By the way what is not made clear is that none of the sums include the point of the array you are currently in. The problem is worded in so much mathematical jargon that most of your time to solve this programming riddle is wasted in understanding what they really want from you.

To make matters worst it should be performant. Effectively you should 


1. Traverse the array in one loop
2. Calculate the LHS sum without using a second loop
3. Calculate the RHS sum without using a third loop

I think I achieve this in method **startProcess_v3()**.  Codility's original wording of the problem is part of the JavaDoc for this class.

The other methods namely _..v2()_ and _...v1()_ are not going to performnant - though sometimes I noticed that _v3()_ is not always fastest and I have not figured out why yet! So my final solution might not be performant after all.

Because if this was huge array your solution probably would not finish even if you were provided a Cray. All this gubbins brings us to something called O(N) notation. Some more mathematical jargon but, is increasingly imp. to hone your skills as a developer.

## [(2) Solution Link for Codility's Decimal Zip Problem](https://github.com/FreeFries/Codility-Solutions/blob/master/src/test/java/codility/demo/DecimalZip/Solution.java "Clicking this link takes you to the source-code")

This solution works but might not be O(N) performant as per Codility's standards.

## [(3) Solution Link for Codility's _Is Your Number Divisble by a PowerOfTwo_ Problem](https://github.com/FreeFries/Codility-Solutions/blob/master/src/test/java/codility/demo/DecimalZip/Solution.java "Clicking this link takes you to the source-code")

This solution works but might not be O(N) performant as per Codility's standards.
