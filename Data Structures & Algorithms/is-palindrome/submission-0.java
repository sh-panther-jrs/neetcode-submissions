class Solution {
    public boolean isPalindrome(String s) {
        String sWoSpace = s.replace(" ", "");
        sWoSpace = sWoSpace.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(sWoSpace);
        int start =0;
        int end = sWoSpace.length()-1;
        while(start<=end) {
            if (sWoSpace.charAt(start)!=sWoSpace.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
