class Solution {

    private List<String> results = new ArrayList<>();

    String[] chars = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return results;

        backtrack(digits, 0, new StringBuilder());
        return results;
    }

    private void backtrack(String digits, int index, StringBuilder path) {

        // ✅ Base case
        if (index == digits.length()) {
            results.add(path.toString());
            return;
        }

        // ✅ Get letters for current digit
        String letters = chars[digits.charAt(index) - '0'];

        // ✅ Try all choices
        for (char ch : letters.toCharArray()) {

            path.append(ch);                 // choose
            backtrack(digits, index + 1, path); // explore
            path.deleteCharAt(path.length() - 1); // undo
        }
    }
}