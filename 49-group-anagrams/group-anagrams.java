class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char charArray[]=str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if (!map.containsKey(sortedStr)){
                map.put(sortedStr,new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        // Convert map values (lists of anagrams) to list and return
        return new ArrayList<>(map.values());        
    }
}