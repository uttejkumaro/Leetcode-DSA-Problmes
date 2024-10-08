class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // Deque<String>dq1=new ArrayDeque<>(Arrays.asList(sentence1.split(" ")));
        // Deque<String>dq2=new ArrayDeque<>(Arrays.asList(sentence2.split(" ")));
        //compare and remove common prefix
    
        // array deque accepts only collections as input 
        Deque<String> dq1 = new ArrayDeque<>();
        Deque<String> dq2 = new ArrayDeque<>();

    // Adding elements from the array manually
    for(String word:sentence1.split(" ")){
        dq1.add(word);
    }
    for(String word:sentence2.split(" ")){
        dq2.add(word);
}

        while(!dq1.isEmpty()&&!dq2.isEmpty()&& dq1.peek().equals(dq2.peek())){
            dq1.poll();
            dq2.poll();
        }
        //compare and remnove common suffix
        while(!dq1.isEmpty() && !dq2.isEmpty() && dq1.peekLast().equals(dq2.peekLast())){
                dq1.pollLast();
                dq2.pollLast();
        }
        return dq1.isEmpty()||dq2.isEmpty();
        
    }
}