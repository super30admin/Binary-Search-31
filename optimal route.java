//Timecomplexity :- mlogm+nlogn for sorting and binary search.
//Spacecomplexity:-O(1).
//Did you face any problems:- yes for sorting comparators problem.
//Did it run on leetcode:- yes.
//Your code with explanation:- initially sorted two tuples based on distance after apllied binary search when target-middle value
//is less than or equal to element in other tuple overriding global maximum comparing with previous value. Finally global max is returned.




public class Main {
    public static List<List<Integer>> closestSum(List<List<Integer>> listA, List<List<Integer>> listB, int target) {
        // Sort by element value
        listA.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        listB.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        
        // A -> [[3,9], [1,8], [2,15]]
        // B -> [[1,8], [2,11], [3,12]]
        
        int i = 0;
        int j = listB.size() - 1;
        
        System.out.println("a = " + listA);
        System.out.println("b = " + listB);
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        List<List<Integer>> resSoFar = new ArrayList<List<Integer>>();
        int closestSum = Integer.MIN_VALUE;
        
        while (i < listA.size() && j >= 0) {
            List<Integer> aVal = listA.get(i);
            List<Integer> bVal = listB.get(j);
            
            int sum = aVal.get(1) + bVal.get(1);
            
            System.out.println(i + " " + j + " " + sum);
            
            if (target - sum < 0) {
                j--;
            } else {
                if (sum > closestSum) {
                    closestSum = sum;
                    resSoFar.clear();
                    resSoFar.add(new ArrayList<>() {{
                        add(aVal.get(0));
                        add(bVal.get(0));
                    }});
                } else if (sum == closestSum) {
                    resSoFar.add(new ArrayList<>() {{
                        add(aVal.get(0));
                        add(bVal.get(0));
                    }});
                }
                i++;
            }
        }
        res.addAll(resSoFar);
        
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> listA = new ArrayList<List<Integer>>();
        List<List<Integer>> listB = new ArrayList<List<Integer>>();
        listA.add(new ArrayList<Integer>(Arrays.asList(1, 8)));
        listA.add(new ArrayList<Integer>(Arrays.asList(2, 15)));
        listA.add(new ArrayList<Integer>(Arrays.asList(3, 9)));
       // listA.add(new ArrayList<Integer>(Arrays.asList(4, 10)));
        listB.add(new ArrayList<Integer>(Arrays.asList(1, 8)));
        listB.add(new ArrayList<Integer>(Arrays.asList(2, 11)));
        listB.add(new ArrayList<Integer>(Arrays.asList(3, 12)));
       // listB.add(new ArrayList<Integer>(Arrays.asList(4, 5)));
        System.out.println("a = " + listA);
        System.out.println("b = " + listB);
        int target = 20;
        System.out.println("target = " + target);
        System.out.println(closestSum(listA, listB, target));
    }
}