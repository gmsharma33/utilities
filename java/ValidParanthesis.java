package practice;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println(new ValidParanthesis().isValid(str));
    }

    public boolean isValid(String s) {
        String[] arr = s.split("");
        Stack<String> st = new Stack<>();
        for(String str : arr) {
            if(str.equals("(") || str.equals("{") || str.equals("[")) {
                st.push(str);
                continue;
            }
            if(st.isEmpty()) return false;
            if(str.equals(")") || str.equals("}") || str.equals("]")) {
                String s1 = st.pop();
                if(str.equals(")")) {
                    if(s1.equals("{") || s1.equals("[")) {
                        return false;
                    }
                }
                if(str.equals("}")) {
                    if(s1.equals("(") || s1.equals("[")) {
                        return false;
                    }
                }
                if(str.equals("]")) {
                    if(s1.equals("{") || s1.equals("(")) {
                        return false;
                    }
                }
            }
        }
        return st.empty();
    }
}
