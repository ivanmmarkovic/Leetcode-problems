/*

347. Top K Frequent Elements
Medium

https://leetcode.com/problems/top-k-frequent-elements/

Runtime: 13 ms, faster than 38.22% of Java online submissions for Top K Frequent Elements.
Memory Usage: 41.7 MB, less than 91.98% of Java online submissions for Top K Frequent Elements.

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]

Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
    It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
    You can return the answer in any order.



*/
class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> items = new HashMap<>();
        for(int e: nums){
            if(items.containsKey(e))
                items.put(e, items.get(e) + 1);
            else
                items.put(e, 1);
        }
        
        List<Node> result = new ArrayList<>();
        for(int key: items.keySet())
            result.add(new Node(key, items.get(key)));
        
        List<Node> nodes = result.stream().sorted(Comparator.comparingInt(Node::getCount))
            .collect(Collectors.toList());
        
        int counter[] = new int[k];
        int count = 0;
        for(int i = nodes.size() - 1; i >= nodes.size() - k; i--)
            counter[count++] = nodes.get(i).item;
        return counter;
        
    }
    
    
    class Node {
        int item;
        int count;
        Node(int item, int count){
            this.item =item;
            this.count = count;
        }
        
        int getCount(){
            return this.count;
        }
    }
    
}