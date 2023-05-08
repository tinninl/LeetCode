import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

     public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> combination = new ArrayList<>();
        int start = 0;

        backtrack(res, combination, candidates, target, start);
 
        return res;

    }

    // We are looking for solutions that add up to target
    public void backtrack(
        List<List<Integer>> res,
        List<Integer> combination,
        int[] candidates,
        int remainder,
        int start
    ) {

        if (remainder < 0)
            return;

        else if (remainder == 0)
            res.add(new ArrayList<>(combination));

        else {

            for (int i = start; i < candidates.length; i++){
                combination.add(candidates[i]);
                backtrack(res, combination, candidates, remainder - candidates[i], i);
                combination.remove(combination.size() - 1);
            }

        }
  
    }

}
