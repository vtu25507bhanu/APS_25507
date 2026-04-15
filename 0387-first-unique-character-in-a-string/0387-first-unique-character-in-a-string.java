class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        // count frequency
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        // find first unique char
        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstUniqChar("leetcode"));      // 0
        System.out.println(s.firstUniqChar("loveleetcode"));  // 2
        System.out.println(s.firstUniqChar("aabb"));          // -1
    }
}