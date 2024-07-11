class DetectSquares {
    private Map<Integer, Map<Integer, Integer>> points;

    public DetectSquares() {
        points = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        points.putIfAbsent(x, new HashMap<>());
        points.get(x).put(y, points.get(x).getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0], y = point[1];
        if (!points.containsKey(x)) {
            return 0;
        }
        int count = 0;
        Map<Integer, Integer> yCount = points.get(x);
        for (Map.Entry<Integer, Integer> entry : yCount.entrySet()) {
            int y1 = entry.getKey();
            if (y1 == y) continue;
            int sideLength = Math.abs(y1 - y);
            // Check for points (x-sideLength, y) and (x-sideLength, y1)
            if (points.containsKey(x - sideLength)) {
                Map<Integer, Integer> leftPoints = points.get(x - sideLength);
                count += entry.getValue() * leftPoints.getOrDefault(y, 0) * leftPoints.getOrDefault(y1, 0);
            }
            // Check for points (x+sideLength, y) and (x+sideLength, y1)
            if (points.containsKey(x + sideLength)) {
                Map<Integer, Integer> rightPoints = points.get(x + sideLength);
                count += entry.getValue() * rightPoints.getOrDefault(y, 0) * rightPoints.getOrDefault(y1, 0);
            }
        }
        return count;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
