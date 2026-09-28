class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Set<Integer>> extractedList = new HashMap<>();
        for(int i = 0 ; i < strs.length ; i++){
            SortedMap<Character, Integer> formattedMap = new TreeMap<>();
            for(int j = 0 ; j < strs[i].length() ; j++){
                char ch = strs[i].charAt(j);
                if(formattedMap.containsKey(ch)){
                    formattedMap.put(ch, formattedMap.get(ch) + 1);
                }else{
                    formattedMap.put(ch, 1);
                }
                
            }
            String extractedStr = formattedMap.toString();
            if(extractedList.containsKey(extractedStr)){
                extractedList.get(extractedStr).add(i);
            }else{
                Set<Integer> indexSet = new HashSet<>();
                indexSet.add(i);
                extractedList.put(extractedStr, indexSet);
            }
        }
        List<List<String>> resultList = new LinkedList<>();
        for(Set<Integer> idxSet : extractedList.values()){
            List<String> strList = new LinkedList<>();
            for(int idx : idxSet){
                strList.add(strs[idx]);
            }
            resultList.add(strList);
        }
        return resultList;
    }
}
