// 3Sum

// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// For example, given array S = [-1, 0, 1, 2, -1, -4],

// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        
        if(nums==null||nums.length==0){
            return result;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            //skip the duplicate triples with the same first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            int target = 0 - nums[i];
            twoSum(nums, left, right, target, result);
        }
        
        return result;
    }
    public void twoSum(int[] nums,
                  int left,
                  int right,
                  int target,
                  List<List<Integer>> result) {
                      
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] == target) {
                List<Integer> triple = new ArrayList<Integer>();
                triple.add(-target);
                triple.add(nums[left]);
                triple.add(nums[right]);
                result.add(triple);
                
                left++;
                right--;
                // skip duplicate pairs with the same left
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else {
                right--;
            }
        }
        return;
    }
}