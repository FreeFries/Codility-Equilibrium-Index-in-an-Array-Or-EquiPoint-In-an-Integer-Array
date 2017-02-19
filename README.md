# Codility-Solutions

[(1) Solution for Codility's Equi-Point Array Solution](https://github.com/FreeFries/Codility-Solutions/blob/master/src/test/java/codility/demo/EquiPointsInArray.java "Clicking this link takes you to the source-code")

What is the gist (should this have been a github gist?) of the problem posed by Codility ?

Basically, Codility wants you to traverse an array of numbers (ints) and at every point it wants you to calculate a sum to the LHS of that position in the array and a sum to the RHS as well. If, the sums match you should report that position of that array since it is an "equi-point". By the way what is not made clear is that none of the sums include the point of the array you are currently in. The problem is worded in so much mathematical jargon that most of your time to solve this programming riddle is wasted in understanding what they really want from you.

To make matters worst it should be performant. Effectively you should 
(1) Traverse the array in one loop
(2) Calculate the LHS sum without using a second loop
(3) Calculate the RHS sum without using a third loop

I think I achieve this in method startProcess_v3(). The other methods namely _v2() and _v1() are not going to performnant - though sometimes I noticed that _v3() is not always fastest and I have not figured out why yet!

Because if this was huge array your solution probably would not finish even if you were provided a Cray. All this gubbins brings us to something called O(N) notation

