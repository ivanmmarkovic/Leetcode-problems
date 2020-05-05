
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class PermutationsSecondSolution {
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> total = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        List<Integer> origin = new ArrayList<Integer>();
        for(int e: nums)
            origin.add(e);
        helper(origin, current, total);
        return total;
    }
    
    public static void helper(List<Integer> origin, List<Integer> current, List<List<Integer>> total) {
        if(origin.size() == 0)
            total.add(current);
        List<Integer> originClone;
        List<Integer> currentClone;
        
        for(int i = 0; i < origin.size(); i++) {
            originClone = origin.stream().collect(Collectors.toList());
            currentClone = current.stream().collect(Collectors.toList());
            currentClone.add(originClone.get(i));
            originClone.remove(i);
            helper(originClone, currentClone, total);
        }
    } 
}