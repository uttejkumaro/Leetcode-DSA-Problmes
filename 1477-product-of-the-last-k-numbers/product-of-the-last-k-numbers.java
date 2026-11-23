class ProductOfNumbers {

        List<Integer>al=new ArrayList<>(List.of(1) );
   

    public void add(int num) {
        if(num==0){al.clear();
        al.add(1);}
        else 
        al.add(num*al.get(al.size()-1));
    }
    
    public int getProduct(int k) {
        int n=al.size();
        if(k>=n)return 0;
        return al.get(n-1)/al.get(n-k-1);
    }
    
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */