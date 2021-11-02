package com.company;

public class Main {
    // histogram:
    public static void main(String[] args) {
        // write your code here
        String str = "sldkjfdwpeoeri";
        // sldekjfdewpori
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals(String.valueOf('d'))) {
                result = result + 'd';
                result = result + 'e';
            } else if (str.substring(i, i + 1).equals(String.valueOf('e'))) {

            } else {
                result = result + str.substring(i, i + 1);
            }
        }
        System.out.println(result);

        int[] nums = {3, 1, 1, 3, 4, 4};
        //           {3, 4, 1, 3, 4, 1};
        nums = fix34(nums);
        for (int i = 0; i < nums.length; i++) {
            //System.out.println(nums[i]);
        }

        int[] nums2 = {5, 4, 9, 4, 9, 5};
        nums2 = fix45(nums2);
        for (int i = 0; i < nums2.length; i++) {
            System.out.println(nums2[i]);
        }
    }

    public static int[] fix34(int[] nums) {
        //
        int[] result = new int[nums.length];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 3) {
                if (nums[i+1] == 4) {
                    temp = temp;
                    i++;
                } else {
                    temp = nums[i+1];
                    nums[i+1] = 4;
                    i++;
                }
            } else if (nums[i] == 4) {
                nums[i] = temp;
            }
        }
        return nums;
    }

    // VIRKER IKKE
    public static int[] fix45(int[] nums) {
        int temp = 0;
        // 5, 4, 9, 4, 9, 5
        // 9, 4, 5, 4, 5, 9
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i] == 4) {
                if (nums[i-1] == 5) {
                    nums[i-1] = nums[i+1];
                    nums[i+1] = 5;
                } else if (nums[i+1] == 5) {
                    i++;
                } else {
                    temp = nums[i+1];
                    nums[i+1] = 5;
                }
            }

        }
        return nums;
    }
}

        /*
        fix45([5, 4, 9, 4, 9, 5]) → [9, 4, 5, 4, 5, 9]
        fix45([1, 4, 1, 5]) → [1, 4, 5, 1]
        fix45([1, 4, 1, 5, 5, 4, 1]) → [1, 4, 5, 1, 1, 4, 5]
        */