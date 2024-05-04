class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int len = people.length;
        int index = len -1;
        int boats=0;
        while(index >= 0) {
            if(people[index] == limit) {
                boats++;
            } else {
                break;
            }
            index--;
        }

        if(index < 0) {
            return boats;
        }
        int start = 0;
        while(start<=index) {
            int temp = people[start] + people[index];
            if(temp <= limit) {
                boats++;
                start++;
                index--;
            } else {
                boats++;
                index--;
            }
        }
        return boats;
    }
}