package arrays;
/*

1491. Average Salary Excluding the Minimum and Maximum Salary
Easy

https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.
Memory Usage: 39 MB, less than 100.00% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.

Given an array of unique integers salary where salary[i] is the salary of the employee i.

Return the average salary of employees excluding the minimum and maximum salary.

 

Example 1:

Input: salary = [4000,3000,1000,2000]
Output: 2500.00000
Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
Average salary excluding minimum and maximum salary is (2000+3000)/2= 2500

Example 2:

Input: salary = [1000,2000,3000]
Output: 2000.00000
Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
Average salary excluding minimum and maximum salary is (2000)/1= 2000

Example 3:

Input: salary = [6000,5000,4000,3000,2000,1000]
Output: 3500.00000


*/
class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salary) {

    	if(salary == null || salary.length == 0 || salary.length == 1)
            return new Double(0);
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int e: salary){
            if(e > max)
                max = e;
            if(e < min)
                min = e;
            sum += e;
        }
        
        return new Double(sum - (min + max)) / new Double(salary.length - 2);
        
    }
}