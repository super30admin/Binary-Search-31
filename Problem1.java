
// Time - O (m*n log(m*n))
// Space - O( m*n)




class OptimalUtilization {

    public static void main(String[] args) {
        int[][] a = {{1, 2}, {2, 4}, {3, 6}};
        int[][] b = {{1, 2}};
        int target = 7;
        OptimalUtilization op = new OptimalUtilization();
        List<int[]> result = getOptimizedPairs(a, b, target);
        result.forEach( arr -> System.out.println(Arrays.toString(arr)));

    }

    private static List<int[]> getOptimizedPairs(int[][] a,int[][] b, int target) {

        // store the sum as the key and ids as the list in treemap
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < b.length; j++) {

                int [] ids = {a[i][0],b[j][0]};
                int value = a[i][1] + b[j][1];
                map.putIfAbsent(value,new ArrayList<>());
                map.get(value).add(ids);
            }
        }

        List<int[]> result = new ArrayList<>();

        // iterate over the treemap as it is sorted we would be storing the greater value in the result as we move along
        for (Map.Entry<Integer, List<int[]>> current : map.entrySet()) {
            if(current.getKey() > target) {

                break;
            }
            result = current.getValue();
        }
        return result;

    }

}

