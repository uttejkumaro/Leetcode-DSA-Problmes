class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Create a max-heap based on the possible increment in the pass rate
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        // Populate the heap with the initial possible increments for all classes
        for (int i = 0; i < classes.length; i++) {
            int pass = classes[i][0];
            int total = classes[i][1];
            double possibleIncrement = increment(pass, total);
            maxHeap.offer(new double[] {possibleIncrement, pass, total});
        }
        // Distribute extra students
        while (extraStudents-- > 0) {
            // Extract the class with the highest increment potential
            double[] top = maxHeap.poll();
            double currentIncrement = top[0];
            int pass = (int) top[1];
            int total = (int) top[2];
            // Add one student to this class
            pass++;
            total++;
            // Recalculate the increment and reinsert into the heap
            double newIncrement = increment(pass, total);
            maxHeap.offer(new double[] {newIncrement, pass, total});
        }
        // Calculate the final average pass ratio
        double finalAvg = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            finalAvg += (double) pass / total;
        }
        return finalAvg / classes.length;
    }

    // Helper method to calculate the possible increment when adding one student
    private double increment(int pass, int total) {
        return (double) (pass + 1) / (total + 1) - (double) pass / total;
    }
}
