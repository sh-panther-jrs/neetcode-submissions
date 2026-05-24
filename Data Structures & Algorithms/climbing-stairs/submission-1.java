class Solution {
    public int climbStairs(int n) {
        if (n<=2) {
            return n;
        }
        int waysPrevPrev=1;
        int waysPrev=2;
        int currCount=2;
        while (currCount<n) {
            int temp=waysPrev;
            waysPrev +=waysPrevPrev;
            waysPrevPrev=temp;
            currCount++;
        }
        return waysPrev;
    }
}
