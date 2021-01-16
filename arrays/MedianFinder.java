
import java.util.ArrayList;
import java.util.List;
/*
295. Find Median from Data Stream
Hard

https://leetcode.com/problems/find-median-from-data-stream/

Runtime: 831 ms, faster than 8.93% of Java online submissions for Find Median from Data Stream.
Memory Usage: 50.5 MB, less than 54.54% of Java online submissions for Find Median from Data Stream.


Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
For example,

[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

    void addNum(int num) - Add a integer number from the data stream to the data structure.
    double findMedian() - Return the median of all elements so far.

 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2

 

Follow up:

    If all integer numbers from the stream are between 0 and 100, how would you optimize it?
    If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?

Accepted
260,152
Submissions
560,571
*/
class MedianFinder {
    
    List<Integer> vals;
    /** initialize your data structure here. */
    public MedianFinder() {
        this.vals = new ArrayList<>();
    }
    
    public void addNum(int num) {
        for(int i = 0; i < this.vals.size(); i++){
            if(this.vals.get(i) > num){
                this.vals.add(i, num);
                return;
            }   
        }
        this.vals.add(num);
    }
    
    public double findMedian() {
        int midpoint = this.vals.size() / 2;
        if(this.vals.size() % 2 == 0){
            return (double)(this.vals.get(midpoint) + this.vals.get(midpoint - 1)) / 2;
        }
        else
            return this.vals.get(midpoint);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
