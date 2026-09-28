class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> remainMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
            remainMap.put(ch, remainMap.getOrDefault(ch, 0) + 1);
        }
        int i = 0 , j = 0;
        String result = null;
        for ( ; j < s.length() ; j++) {
            sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0) + 1);
            if (remainMap.containsKey(s.charAt(j))) {
                if (remainMap.get(s.charAt(j)) == 1) {
                    remainMap.remove(s.charAt(j));
                } else {
                    remainMap.put(s.charAt(j), remainMap.get(s.charAt(j)) - 1);
                }
                if (remainMap.isEmpty()) {
                    while (true) {
                        if (j == s.length() - 1 && j - i + 1 < t.length())
                            break;
                        if (result == null || (j - i + 1) < result.length()) {
                            result = s.substring(i, j + 1);
                        }
                        if (sMap.get(s.charAt(i)) == 1){
                            sMap.remove(s.charAt(i));
                        } else {
                            sMap.put(s.charAt(i), sMap.get(s.charAt(i)) - 1);
                        }
                        
                        if (tMap.getOrDefault(s.charAt(i), 0) > sMap.getOrDefault(s.charAt(i), 0)) {
                            remainMap.put(s.charAt(i), 1);
                            i++;
                            break;
                        } else {
                            i++;
                            continue;
                        }
                    }
                }
            }
        }
        return result == null ? "" : result;
    }
}
