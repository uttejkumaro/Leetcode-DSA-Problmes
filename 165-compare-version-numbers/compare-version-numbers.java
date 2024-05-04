class Solution {
    public int compareVersion(String version1, String version2) {
        char[] ver1 = version1.toCharArray();
        char[] ver2 = version2.toCharArray();
        int n1 = ver1.length;
        int n2 = ver2.length;
        int i=0; 
        int j=0;
        while(i<n1 || j<n2){
            int num1 = 0;
            int num2 = 0;
            boolean numFlag1 = false;
            boolean numFlag2 = false;
            while(i<n1){
                if(ver1[i] =='0' && !numFlag1){
                    i++;
                }
                else{
                    if(ver1[i] == '.'){
                        break;
                    }
                    else{
                        numFlag1 = true;
                        num1 = num1*10+((int)ver1[i]-'0');
                        i++;
                    }
                }
            }
            while(j<n2){
                if(ver2[j] =='0' && !numFlag2){
                    j++;
                }
                else{
                    if(ver2[j] == '.'){
                        break;
                    }
                    else{
                        numFlag2 = true;
                        num2 = num2*10+((int)ver2[j]-'0');
                        j++;
                    }
                }
            }
            if(num1>num2) return 1;
            else if(num2>num1) return -1;
            i++;
            j++;
        }
        return 0;
    }
}