class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Map<Character, Integer> charIdxMap = new HashMap<>();
        int i = 0 , j = 0;
        while (j < s.length()) {
            if (charIdxMap.containsKey(s.charAt(j))) {
                int duplicateIdx = charIdxMap.get(s.charAt(j));
                for ( ; i <= duplicateIdx ; i++) {
                    charIdxMap.remove(s.charAt(i));
                }
            }
            charIdxMap.put(s.charAt(j), j);
            result = Math.max(result, j - i + 1);
            j++;
        }
        return result;
    }
}
