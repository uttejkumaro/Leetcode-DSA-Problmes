class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String>map=new HashMap<>();
        for(int i=0;i<heights.length;i++){
            map.put(heights[i],names[i]);
        }
        List<Integer> sortedHeights = new ArrayList<>(map.keySet());
        Collections.sort(sortedHeights,Collections.reverseOrder());
        String[] sortNames=new String [names.length];
        for(int i=0;i<names.length;i++){
            sortNames[i]=map.get(sortedHeights.get(i));
        }
        return sortNames;
        
    }
}