class Solution {
    public String reorderSpaces(String text) {
        int spaces=0;
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)==' ')
            spaces++;
        }
        if(spaces==0)
        return text;
        String st[]=text.split(" ");
        ArrayList<String> s1=new ArrayList<>();
        for (String word:st) {
            word = word.trim(); 
            if (!word.isEmpty())
                s1.add(word);
        }
        StringBuilder tnew=new StringBuilder();
        int words=s1.size();
        if (words == 1) {
            s1.set(0, s1.get(0).trim());
            for (int i = 0; i < spaces; i++) {
                s1.set(0, s1.get(0) + " ");
            }
            return s1.get(0);
        }
        int reqsp=spaces/(words-1);
        String spaceString="";
        for(int i=0;i<reqsp;i++)
        spaceString+=" ";
        for(int i=0;i<s1.size();i++)
        tnew.append(s1.get(i)).append(spaceString);
        String result=tnew.toString().trim();
        if(reqsp*(words-1)!=spaces){
            int x=spaces-(reqsp*(words-1));
            for(int i=0;i<x;i++)
            result+=" ";
        }
        return result;
    }
}