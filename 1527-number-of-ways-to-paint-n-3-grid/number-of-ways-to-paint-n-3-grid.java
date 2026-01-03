class Solution {
    public int numOfWays(int n) {
        int MOD=1_000_000_007;
        long pattern1=6;//aba
        long pattern2=6;//abc
        for(int i=2;i<=n;i++){
            long updatedPattern1=(2*pattern1+2*pattern2)%MOD;
            long updatedPattern2=(2*pattern1+3*pattern2)%MOD;
            pattern1=updatedPattern1;
            pattern2=updatedPattern2;

        }
        return (int)((pattern1+pattern2)%MOD);

    }
}
//  New A (2-color row)

// From old A → 2 ways

// From old B → 2 ways

// newA = 2*A + 2*B

// New B (3-color row)

// From old A → 2 ways

// From old B → 3 ways

// newB = 2*A + 3*B//