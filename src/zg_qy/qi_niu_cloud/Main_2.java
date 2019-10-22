package zg_qy.qi_niu_cloud;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Main_2 main = new Main_2();
        if (main.isValid(input)){
            System.out.println("1");
        }else
            System.out.println("0");
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = new HashMap<>();

        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (int i=0; i<s.length(); i++) {
            if (stack.size() == 0) {
                stack.push(s.charAt(i));
                continue;
            }

            char ch = stack.peek();
            if (map.containsKey(ch) && map.get(ch) == s.charAt(i)) {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }

        if (stack.empty())
            return true;
        else
            return false;
    }


    public boolean getResult(String input) {

        if (input == "")
            return false;

        char[] str = {'(', ')', '[', ']', '{', '}', '<', '>'};

        //计数器
        int count = 0;
        char[] inputs = input.toCharArray();

        if (inputs.length%2 != 0 || input.length() == 0) {
            return false;
        }

        for (char c : inputs) {
            if (c==str[0] || c==str[2] || c==str[4] || c==str[6]) {
                count++;
            }else {
                count--;
            }
        }
        if (count != 0)
            return false;

        return true;
    }

}
