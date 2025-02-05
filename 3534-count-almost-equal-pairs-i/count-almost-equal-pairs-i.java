class Solution {


	public int countPairs(int[] nums) {
		int res=0,n=nums.length;
		for(int i=0; i<n; i++) {
			for(int j=1+i; j<n; j++) {
				if(count(nums[i],nums[j])) {
					res++;
				}
			}

		}
		return res;
	}
	boolean count(int a,int b) {
		String s1=a+"";
		String s2=b+"";
		while(s1.length()<s2.length()) s1="0"+s1;
		while(s1.length()>s2.length()) s2="0"+s2;
		List<Integer>al=new ArrayList<>();
		int count=0;
		for(int i=0; i<s1.length(); i++) {
			if(s1.charAt(i)!=s2.charAt(i)){
            count++;
			al.add(i);
            } 
                
        }
			if(count ==0) return true;
			if(count>2) return false;
			if(count==2) {
				char ch[]=s1.toCharArray();
				int c1=al.get(0);
				int  c2=al.get(1);
				char swap=ch[c1];
				ch[c1]=ch[c2];
				ch[c2]=swap;

				return new String(ch).equals(s2);
			}
			return false;

		}
	}