class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indices=new ArrayList<>();
        String x1=""+x;
        int n=words.length;
        for(int i=0;i<n;i++){
            if(words[i].contains(x1)){
                indices.add(i);
            }
        }
        return indices;
    }
}