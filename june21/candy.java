import java.util.HashMap;
/*
Reference: https://leetcode.com/problems/candy/solution/
Approach 4: Single Pass Approach with Constant Space
Algorithm

This approach relies on the observation (as demonstrated in the figure below as well) that in order to distribute the candies as per the given criteria using the minimum number of candies, the candies are always distributed in terms of increments of 1. Further, while distributing the candies, the local minimum number of candies given to a student is 1. Thus, the sub-distributions always take the following form: 
{1, 2, 3, ..., n}1, 2, 3, ..., n or 
{n,..., 2, 1}n,..., 2, 1. Which, can simply be added using the formula n(n+1)/2n(n+1)/2.

Now, we can view the given rankings as some rising and falling slopes. Whenever the slope is rising, the distribution takes the form: 
{1, 2, 3, ..., m}1, 2, 3, ..., m. Similarly, a falling slope takes the form: 
{k,..., 2, 1}k,..., 2, 1. A challenge that arises now is that the local peak point can be included in only one of the slopes. Should we include the local peak point, n, in the rising slope or the in falling slope?

In order to decide, we can observe that in order to satisfy both the right neighbor and the left neighbor criteria, the peak point's count needs to be the max. of the counts determined by the rising and the falling slopes. Thus, in order to determine the number of candies required, the peak point needs to be included in the slope which contains more number of points. The local valley point can also be included in only one of the slopes, but this issue can be resolved easily, since the local valley point will always be assigned a candy count of 1 (which can be subtracted from the next slope's count calculations).

Coming to the implementation, we maintain two variables oldSlope and newSlope to determine the occurrence of a peak or a valley. We also use up and down variables to keep a track of the count of elements on the rising slope and on the falling slope respectively (without including the peak element). We always update the total count of candies at the end of a falling slope following a rising slope (or a mountain). The leveling of the points in rankings also works as the end of a mountain. At the end of the mountain, we determine whether to include the peak point in the rising slope or in the falling slope by comparing the up and down variables up to that point. Thus, the count assigned to the peak element becomes: max(up, down) + 1. At this point, we can reset the up and down variables indicating the start of a new mountain.

The following figure shows the cases that need to be handled for this example:

rankings: [1 2 3 4 5 3 2 1 2 6 5 4 3 3 2 1 1 3 3 3 4 2]

Candy_Two_Arrays

From this figure, we can see that the candy distributions in the sub-regions always take the form 
{1, 2, ...n}1, 2, ...n or 
{n, ..., 2, 1}n, ..., 2, 1. For the first mountain comprised by the regions a and b, while assigning candies to the local peak point (point 5), it needs to be included in a to satisfy the left neighbor criteria. The local valley point at the end of region b (point 8) marks the end of the first mountain (region c). While performing the calculations, we can include this point in either the current or the following mountain. Then, point 13 marks the end of the second mountain due to leveling of the point 13 and point 14. Since region e has more points than region d, the local peak (point 10) needs to be included in region e to satisfy the right neighbor criteria. Now, the third mountain f can be considered as a mountain with no rising slope (as up = 0) but only a falling slope. Similarly, points 16, 18, and 19 also act as the mountain ends due to the leveling of the points.
*/

public class candy {
    public int count(int n) {
        return (n * (n + 1)) / 2;
    }

    public int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int candies = 0;
        int up = 0;
        int down = 0;
        int oldSlope = 0;
        for (int i = 1; i < ratings.length; i++) {
            int newSlope = (ratings[i] > ratings[i - 1]) ? 1 : (ratings[i] < ratings[i - 1] ? -1 : 0);

            if ((oldSlope > 0 && newSlope == 0) || (oldSlope < 0 && newSlope >= 0)) {
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (newSlope > 0) {
                up++;
            } else if (newSlope < 0) {
                down++;
            } else {
                candies++;
            }

            oldSlope = newSlope;
        }
        candies += count(up) + count(down) + Math.max(up, down) + 1;
        return candies;
    }
}
