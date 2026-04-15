import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        
        for (int i = 0; i < n; i++) {
            
            // 1. Remove elements out of window
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            
            // 2. Remove smaller elements from back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // 3. Add current index
            deque.offerLast(i);
            
            // 4. Store result when window size reached
            if (i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
}
