
import java.util.LinkedList;
import java.util.Deque;

class Solution {
    // Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) {
        // Your code here
        Deque<Integer> dq = new LinkedList<>();
        int left[] = new int[n];
        int right[] = new int[n];

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && arr[dq.peekLast()] >= arr[i])
                dq.pollLast();
            if (dq.isEmpty())
                left[i] = -1;
            else
                left[i] = dq.peekLast();
            dq.offerLast(i);
        }
        dq.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!dq.isEmpty() && arr[dq.peekLast()] >= arr[i])
                dq.pollLast();
            if (dq.isEmpty())
                right[i] = n;
            else
                right[i] = dq.peekLast();
            dq.offerLast(i);
        }
        int ans[] = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            len = right[i] - left[i] - 1;
            // System.out.println(arr[i]+" "+len+" "+right[i]+" "+left[i]);
            ans[len - 1] = Math.max(ans[len - 1], arr[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        return ans;
    }
}