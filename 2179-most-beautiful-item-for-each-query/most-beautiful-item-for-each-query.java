class Solution {
    public int[] maximumBeauty(int[][] items, int[] priceQueries) {
        int[] result = new int[priceQueries.length];
        Arrays.sort(items, (item1, item2) -> item1[0] - item2[0]);
        int maxBeautySoFar = items[0][1];
        for (int i = 0; i < items.length; i++) {
            maxBeautySoFar = Math.max(maxBeautySoFar, items[i][1]);
            items[i][1] = maxBeautySoFar;
        }
        for (int i = 0; i < priceQueries.length; i++) {
            result[i] = findMaxBeauty(items, priceQueries[i]);
        }
        return result;
    }
    private int findMaxBeauty(int[][] items, int targetPrice) {
        int left = 0;
        int right = items.length - 1;
        int maxBeautyAtTarget = 0;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (items[middle][0] > targetPrice) {
                right = middle - 1;
            } else {
                maxBeautyAtTarget = Math.max(maxBeautyAtTarget, items[middle][1]);
                left = middle + 1;
            }
        }
        return maxBeautyAtTarget;
    }
}
