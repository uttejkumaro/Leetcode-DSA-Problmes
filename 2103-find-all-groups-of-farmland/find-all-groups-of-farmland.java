import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> ans = new ArrayList<>();
        int n = land.length, m = land[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1) {
                    int[] group = findFarmlandGroup(land, i, j);
                    ans.add(group);
                }
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    private int[] findFarmlandGroup(int[][] land, int row, int col) {
        int[] group = {row, col, row, col}; // [top left row, top left col, bottom right row, bottom right col]

        // Find the bottom right corner of the farmland group
        for (int i = row; i < land.length && land[i][col] == 1; i++) {
            for (int j = col; j < land[0].length && land[i][j] == 1; j++) {
                land[i][j] = 0; // Mark as visited
                group[2] = i; // Update bottom right row
                group[3] = j; // Update bottom right col
            }
        }

        return group;
    }
}
