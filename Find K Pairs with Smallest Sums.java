public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        // heap
        /*
         PriorityQueue<int[]> pq = new PriorityQueue<>(k, new Comparator<int[]>() {
         public int compare(int[] arr1, int[] arr2) {
         return arr2[0] + arr2[1] - arr1[0] - arr1[1];
         }
         });
         for (int i = 0; i < nums1.length; i++) {
         for (int j = 0; j < nums2.length; j++) {
         pq.offer(new int[]{nums1[i], nums2[j]});
         if (pq.size() > k) {
         pq.poll();
         }
         }
         }
         List<int[]> res = new ArrayList<>();
         res.addAll(pq);
         return res;
         */
        
        List<int[]> res = new LinkedList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }
        int[] index = new int[nums1.length];
        while (k-- > 0) {
            int min = Integer.MAX_VALUE;
            int i = -1;
            for (int j = 0; j < index.length; j++) {
                if (index[j] > nums2.length - 1) {
                    continue;
                }
                if (nums2[index[j]] + nums1[j] < min) {
                    min = nums2[index[j]] + nums1[j];
                    i = j;
                }
            }
            if (i == -1) {
                break;
            }
            int[] data = {nums1[i], nums2[index[i]]};
            res.add(data);
            index[i]++;
        }
        return res;
    }
    
}