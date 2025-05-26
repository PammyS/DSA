import java.util.*;



/*
* Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number.
The second 1's next greater number needs to search circularly, which is also 2.

Input: nums = [1,2,3,4,3] 1
Output: [2,3,4,-1,4]

* */


public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        Parser parser = new GroupSimilarCharacters();
//
//        List<String> input = Arrays.asList("abc", "bca", "def", "efd", "kim", "zya");
//        List<List<String>> output  = parser.parseWords(input);
//        System.out.println(input);
//        System.out.println(output);
        System.out.println("abcde".substring(0,3));
        int[] input = new int[]{1,5,3,3,2};
        int[] output = nextGreaterElement(input);
        for(Integer num : output) {
            System.out.println(num);
        }
    }
    //[1,2,3,4,3]
    //[5,-1,-1,-1,5]

    private static int[] nextGreaterElement(int[] arr) {
        if(arr == null || arr.length == 0) return new int[0];
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.length-1;i>=0;i--) {
            if(!stack.empty() && stack.peek()<=arr[i]) {
                stack.pop();
            }
            stack.push(arr[i]);
        }
        int max = arr[arr.length-1];
        for(int i=0;i<arr.length-1;i++) {
            if(max <= arr[arr.length-1] && arr[i]> arr[arr.length-1]) {
                max = arr[i];
            }
            while(!stack.empty() && stack.peek() <=arr[i]) {
                stack.pop();
            }
            if(stack.empty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
        }


        result[arr.length-1] = max > arr[arr.length-1]?max:-1;
        return result;
    }

}



/*
* Given input of string array and rule, you have to apply this rule and group the words basis the given rule.
* We will start with one rule if time permits we will extend the problem with more rules.
* You need to follow all clean code principle and write test to validate your solution.

Input: {“abc”, “bcaa”, “def”, “efd”, “kim”, “zya”}
* Rule: Rule-1 - similar characters
*Output: {{“abc”, “bca”}, {“def”, “efd”}, {“klm”}, {“zya”}}
* */

//{“abc”, “bca”, “def”, “efd”, “kim”, “zya”}
//{{“abc”, “bcaa”}, {“def”, “efd”}, {“klm”}, {“zya”}}


/*
interface Parser
    List<List<String>> parseWords(List<String> input)

class SimilarCharatecs implemnts Parser {
}


 */


