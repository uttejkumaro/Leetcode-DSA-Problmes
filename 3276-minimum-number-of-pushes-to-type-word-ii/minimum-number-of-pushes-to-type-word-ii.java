/*
class Solution {
    public int minimumPushes(String word) {
        int map[][]=new int[26][2];//count 
        //[][0]-letter [][1]-count
        int i=0;
        for(int j[]:map) j[0]=i++;
        for(char c:word.toCharArray()){
            map[c-'a'][1]++;//inc count
        }
        Arrays.sort(map,(a,b)->Integer.compare(b[1],a[1]));
        int count=0;
        for(int j=0;j<map.length;j++){
            if(j<8) count+=map[j][1];
            else if(j<16) count+=map[j][1]*2;
            else if(j<24) count+=map[j][1]*3;
            else count+=map[j][1]*4;

        }
        return count;

        
    }
}
*/
class Solution {
  public int minimumPushes(String word) {
    int ans = 0;
    int[] count = new int[26];

    for (char c : word.toCharArray())
      ++count[c - 'a'];

    Arrays.sort(count);
    for (int i = 0; i < 26; ++i)
      ans += count[26 - i - 1] * (i / 8 + 1);

    return ans;
  }
}
