import java.util.*;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck); // Sort the deck in increasing order
        
        int n = deck.length;
        int[] result = new int[n];
        Deque<Integer> indexQueue = new ArrayDeque<>();
        
        // Initialize deque with indices 0, 1, 2, ..., n-1
        indexQueue.addAll(IntStream.range(0, n).boxed().collect(Collectors.toList()));
        
        for (int card : deck) {
            int idx = indexQueue.poll(); // Get the next available index
            result[idx] = card; // Place the card in the result array
            if (!indexQueue.isEmpty()) {
                indexQueue.add(indexQueue.poll()); // Move the used index to the end of deque
            }
        }
        
        return result;
    }
}
