class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random rand;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false; // Value already exists
        }
        map.put(val, list.size()); // Map the value to the index where it will be added
        list.add(val); // Add the value to the end of the list
        return true; // Insertion successful
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false; // Value does not exist
        }
        int index = map.get(val); // Get the index of the value to remove
        int lastElement = list.get(list.size() - 1); // Get the last element in the list
        list.set(index, lastElement); // Move the last element to the position of the element to remove
        map.put(lastElement, index); // Update the map with the new index of the last element
        list.remove(list.size() - 1); // Remove the last element from the list
        map.remove(val); // Remove the value from the map
        return true; // Removal successful
    }
    
    public int getRandom() {
        int randomIndex = rand.nextInt(list.size()); // Generate a random index
        return list.get(randomIndex); // Return the element at the random index
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
