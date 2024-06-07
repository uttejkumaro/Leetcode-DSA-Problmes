class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);
        StringBuilder res = new StringBuilder();

        String[] words = sentence.split(" ");

        for(String word: words){
            res.append(findRoot(word, set) + " ");
        }

        return res.toString().trim();
    }

    public String findRoot(String word, Set<String> set){
        for(int i = 0; i < word.length(); i++){
            String root = word.substring(0, i);
            if(set.contains(root)){
                return root;
            }
        }
        return word;
    }
}