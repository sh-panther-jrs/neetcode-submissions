class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        /**
            1. Sort array.Go through the sorted array, add elements with k count freq. O(n + nlogn), Space O(1)
            2. HashMap: Num -> Freq. Build HashMap, traverse HashMap. O(number fo unique elements) space complexity. O(n) time.
            3. Build an Array of length 2000 where each num[i] corresponds to a location in array and its freq. For handling negative, 
                add 1000 to all the numbers. Traverse again to get numbers with freq. O(1) constant space and O(n) time complexity.
            4. Use TreeMap ->freq -> <Number>,
        **/

        HashMap<Integer, Integer> hs = getNumToFreq(nums);
        PriorityQueue<int[]> pq = buildPQ(hs, k);
        int[] output = new int[pq.size()];
        int index = 0;
        for(int[] elem: pq) {
            output[index] = elem[1];
            index++;
        }
        return output;
    }

    private PriorityQueue<int[]> buildPQ(HashMap<Integer, Integer> hs, int k) {
        Comparator<int[]> c = (a, b) -> {
            return a[0]-b[0];
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(c);
        for (Map.Entry<Integer, Integer> entry: hs.entrySet()) {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
            if (pq.size()>k) {
                pq.poll();
            }
        }
        return pq;
    }
    private HashMap<Integer, Integer> getNumToFreq(int nums[]) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int num: nums) {
            hs.put(num, hs.getOrDefault(num, 0) + 1);
        }
        return hs;
    }
}
