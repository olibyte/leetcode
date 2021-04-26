import java.util.numsayList;
import java.util.LinkedList;

public class slidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
		int i = 0;
		int j = 0;
		int counter = 0;
		LinkedList<Integer> l = new LinkedList<>();
		while (j < nums.length) {
            while(l.size() > 0 && l.peekLast() < nums[j]) {
				l.pollLast();
			}
			l.add(nums[j]);
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				result[counter++] = l.peekFirst();
				if(l.peekFirst() == nums[i]) {
					l.pollFirst();
				}
				i++;
				j++;
			}
		}
		return result;

    }
}
