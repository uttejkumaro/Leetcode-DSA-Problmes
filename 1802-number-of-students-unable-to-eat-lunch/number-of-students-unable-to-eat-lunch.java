class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int type1 = 0; //count of students who prefer type1
        int type0 = 0; //count of students who prefer type0
		
        for(int stud : students){
            if(stud == 0) type0++;
            else type1++;
        }
        
        // for each sandwich in sandwiches
        for(int sandwich : sandwiches){
            if(sandwich == 0){  // if sandwich is of type0
                if(type0 == 0){ // if no student want a type0 sandwich
                    return type1;
                }
                type0--;
            }
            else{  // if sandwich is of type1
                if(type1 == 0){  // if no student want a type1 sandwich 
                    return type0;
                }
                type1--;
            }
        }
        return 0;
    }
}