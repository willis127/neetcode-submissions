class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] numFreqArr = new int[2001];
        for(int num : nums){
            numFreqArr[num + 1000]++;
        }
        SortedMap<Integer, List<Integer>> freqNumListMap = new TreeMap<>(Comparator.reverseOrder());
        for(int i = -1000 ; i < 1001 ; i++){
            int freq = numFreqArr[i + 1000];
            if(freq > 0){
                if (freqNumListMap.containsKey(freq)) {
                    freqNumListMap.get(freq).add(i);
                }else{
                    freqNumListMap.put(freq, new LinkedList<Integer>(List.of(i)));
                }
            }
        }
        int i = 0;
        List<Integer> resultList = new LinkedList<>();
        for(List<Integer> list : freqNumListMap.values()){
            for(int num : list){
                if(i == k){
                    break;
                }else{
                    resultList.add(num);
                    i++;
                }
            }
        }
        int[] resultArr = new int[resultList.size()];
        for(int j = 0 ; j < resultList.size(); j++){
            resultArr[j] = resultList.get(j);
        }
        return resultArr;        
    }
}
