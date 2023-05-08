import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhoneNumber {

    private Map<Character, String> digitToChar = Map.of(
    '2',
    "abc",
    '3',
    "def",
    '4',
    "ghi",
    '5',
    "jkl",
    '6',
    "mno",
    '7',
    "pqrs",
    '8',
    "tuv",
    '9',
    "wxyz"
    );

    public List<String> letterCombinations(String digits){

        List<String> res = new ArrayList<>();

        if (digits.length() == 0)
            return res;
        
        String curr = "";

        backtrack(res, curr, digits, 0);

        return res;
    }

    public void backtrack(List<String> res, String curr, String digits, int index){
        if (curr.length() == digits.length())
            res.add(curr);

        else if (index >= digits.length())
            return;

        else{
            String digit = digitToChar.get(digits.charAt(index));
            for (char c : digit.toCharArray()){
                backtrack(res, curr + c, digits, index + 1);
            }
        }
    }
}
