public static void main(String[] args) {
        int arr1[][] = { {1, 2000}, {2, 3000}, {3, 4000}, {4, 2000} };
        int arr2[][] = { { 1, 5000 }, {2, 3000} };

        List<int[]> re = getClosestPairs(arr1, arr2, 7500);

        for(int[] r : re)
        {
        System.out.println(r[0] + " " + r[1]);
        }
        }


private  static  List<int[]> getClosestPairs(int[][] A, int[][] B, int target)
        {

        TreeMap<Integer, List<Integer>> valueWithIds = new TreeMap<>();

        List<int[]> result = new ArrayList<>();

        int closestTarget = 0;

  /*
       Loop through the first Array and insert the values into the map with 'value' (A[1]) as key and id (A[0]) add to the list as value.
  */

        for(int[] a  : A)
        {
        int currentTarget = a[1], id = a[0];
        valueWithIds.putIfAbsent(currentTarget, new ArrayList<>());
        valueWithIds.get(currentTarget).add(id);

        }


        for(int[] b : B)
        {
        int remainingTarget = target - b[1];  // We will find the remaining target by the value from the value of B.
        // For example if target = 5000, b[1] = 3000, then remainingTarget = 2000

        if(remainingTarget < 0) continue;

        if(valueWithIds.containsKey(remainingTarget)) // That means we find the closest target == currentTarget
        {
        if(closestTarget != target)
        {
        closestTarget = target;
        result = new ArrayList<>();
        }

        for(int id : valueWithIds.get(remainingTarget) )
        {

        result.add(new int[] {id, b[0]});
        }

        }

        else
        {
        Integer floor = valueWithIds.floorKey(remainingTarget);  // Check if we have any least value which is less than remainingTarget.

        if(floor == null) continue;

        int currentTarget = b[1] + floor;

        if(  currentTarget >= closestTarget )
        {
        if(currentTarget != closestTarget)
        {
        closestTarget = currentTarget;
        result = new ArrayList<>();
        }

        for(int id : valueWithIds.get(floor) )
        {
        result.add(new int[] {id, b[0]});
        }
        }

        }
        }


        return result;
        }}