class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> currentMap = new HashMap<>();
        int i = 0, n = formula.length();
        
        while (i < n) {
            char c = formula.charAt(i);
            
            if (c == '(') {
                stack.push(currentMap);
                currentMap = new HashMap<>();
                i++;
            } else if (c == ')') {
                i++;
                int start = i;
                int multiplicity = 1;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                if (i > start) {
                    multiplicity = Integer.parseInt(formula.substring(start, i));
                }
                
                Map<String, Integer> topMap = currentMap;
                currentMap = stack.pop();
                
                for (String key : topMap.keySet()) {
                    currentMap.put(key, currentMap.getOrDefault(key, 0) + topMap.get(key) * multiplicity);
                }
            } else {
                int start = i;
                i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(start, i);
                
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplicity = (i > start) ? Integer.parseInt(formula.substring(start, i)) : 1;
                
                currentMap.put(name, currentMap.getOrDefault(name, 0) + multiplicity);
            }
        }
        
        TreeMap<String, Integer> sortedMap = new TreeMap<>(currentMap);
        StringBuilder sb = new StringBuilder();
        for (String key : sortedMap.keySet()) {
            sb.append(key);
            int count = sortedMap.get(key);
            if (count > 1) {
                sb.append(count);
            }
        }
        
        return sb.toString();
    }
}
