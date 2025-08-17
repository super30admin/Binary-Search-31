using System;
namespace Algorithms
{
    public class HIndex
    {
        public class Solution
        {
            /// Time Complexity : O(n)
            // Space Complexity :O(1)
            // Did this code successfully run on Leetcode :Yes
            // Any problem you faced while coding this :  No
            public int FindHIndex(int[] citations)
            {
                if (citations == null || citations.Length == 0) return 0;
                int idx = citations.Length;
                for (int i = 0; i < citations.Length; i++)
                {
                    int diff = idx - i;
                    if (citations[i] >= diff)
                        return diff;

                }
                return 0;
            }
        }
    }
}
