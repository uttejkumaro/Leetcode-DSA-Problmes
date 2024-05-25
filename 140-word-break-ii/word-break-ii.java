class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> resultList = new ArrayList<>();
        List<String> result = new ArrayList<>();
        canBreak(0, 1, s, new HashSet<>(wordDict), resultList, new ArrayList<>());
        for(List<String> temp : resultList) {
            String joined = String.join(" ", temp);
            // System.out.println(joined);
            result.add(joined);
        }
        return result;
    }

    void canBreak(int startIndex, int endIndex, String s, Set<String>  dict, List<List<String>> resultList, List<String> tempResult) {
        // System.out.println("StartIdx : " + startIndex + ", endIndex : " + endIndex);
        if(startIndex >= s.length()) {
            resultList.add(new ArrayList<>(tempResult));
            return;
        }
        if(endIndex > s.length()) {
            return;
        }
        String subString = s.substring(startIndex, endIndex);
        
        if(dict.contains(subString)) {
            // System.out.println("adding : " + subString);
            tempResult.add(subString);
            canBreak(endIndex, endIndex + 1, s, dict, resultList, tempResult);
            // String lastEle = tempResult.get(tempResult.size() - 1);
            // System.out.println("removing : " + lastEle);
            tempResult.remove(tempResult.size() - 1);
        }
        canBreak(startIndex, endIndex + 1, s, dict, resultList, tempResult);
    }
}