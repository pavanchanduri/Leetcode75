package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println("Combinations that sum to " + target + ":");
        combinationSum(candidates, target);
    }

    /**
     * This method finds all unique combinations in candidates where the candidate numbers sum to target.
     * The same repeated number may be chosen from candidates unlimited number of times.
     * The algorithm works as below:
     * 1. Sort the candidates array to help with early stopping in backtracking.
     * 2. Use a helper method to perform backtracking, exploring each candidate and building combinations.
     * 3. If the current combination sums to the target, add it to the result list.
     * 4. If the sum exceeds the target, backtrack by removing the last added number and try the next candidate.
     *
     * @param candidates an array of candidate numbers
     * @param target     the target sum
     */
    private static void combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }

    /**
     * Helper method for backtracking through candidates to find valid combinations.
     * The method works as below:
     * 1. If the target is zero, add the current combination to the result list.
     * 2. If the target is negative, return as no valid combination can be formed.
     * 3. Iterate through the candidates starting from the given index.
     * 4. For each candidate, add it to the current combination and recursively call backtrack with the updated target.
     * 5. After exploring, remove the last added number to backtrack and try the next candidate.
     * 
     * @param candidates an array of candidate numbers
     * @param target     the target sum
     * @param start      the starting index for the current combination
     * @param current    the current combination being explored
     * @param result     the list to store all valid combinations
     */
    private static void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
