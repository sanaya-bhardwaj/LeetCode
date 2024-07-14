//Given a string formula representing a chemical formula, return the count of each atom.
//The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.
//One or more digits representing that element's count may follow if the count is greater than 1. If the count is 1, no digits will follow.
//For example, "H2O" and "H2O2" are possible, but "H1O2" is impossible.
//Two formulas are concatenated together to produce another formula.
//For example, "H2O2He3Mg4" is also a formula.
//A formula placed in parentheses, and a count (optionally added) is also a formula.
//For example, "(H2O2)" and "(H2O2)3" are formulas.
//Return the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
//The test cases are generated so that all the values in the output fit in a 32-bit integer.

class Solution {
    public String countOfAtoms(String formula) {
        StringBuffer sb = new StringBuffer();
        sb.append(formula.charAt(0));
        char prevC = formula.charAt(0);
        int length = formula.length();
        for (int i = 1; i < length; i++) {
            char c = formula.charAt(i);
            boolean flag = Character.isLowerCase(c) || Character.isDigit(c) && Character.isDigit(prevC);
            if (!flag)
                sb.append(' ');
            sb.append(c);
            prevC = c;
        }
        String[] array = sb.toString().split(" ");
        Stack<String> stack = new Stack<String>();
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength; i++) {
            String str = array[i];
            if (str.equals(")")) {
                if (i < arrayLength - 1 && Character.isDigit(array[i + 1].charAt(0)))
                    stack.push(str);
                else {
                    Stack<String> tempStack = new Stack<String>();
                    while (!stack.peek().equals("("))
                        tempStack.push(stack.pop());
                    stack.pop();
                    while (!tempStack.isEmpty())
                        stack.push(tempStack.pop());
                }
            } else if (Character.isDigit(str.charAt(0))) {
                int count = Integer.parseInt(str);
                String prev = stack.pop();
                if (prev.equals(")")) {
                    Stack<String> tempStack = new Stack<String>();
                    while (!stack.peek().equals("(")) {
                        String element = stack.pop();
                        int index = element.indexOf(',');
                        if (index >= 0) {
                            String atom = element.substring(0, index);
                            int atomCount = Integer.parseInt(element.substring(index + 1)) * count;
                            tempStack.push(atom + "," + atomCount);
                        } else
                            tempStack.push(element + "," + str);
                    }
                    stack.pop();
                    while (!tempStack.isEmpty())
                        stack.push(tempStack.pop());
                } else {
                    String curStr = prev + "," + str;
                    stack.push(curStr);
                }
            } else
                stack.push(str);
        }
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        while (!stack.isEmpty()) {
            String atomCount = stack.pop();
            int index = atomCount.indexOf(',');
            if (index >= 0) {
                String atom = atomCount.substring(0, index);
                int count = Integer.parseInt(atomCount.substring(index + 1));
                count += map.getOrDefault(atom, 0);
                map.put(atom, count);
            } else {
                int count = map.getOrDefault(atomCount, 0) + 1;
                map.put(atomCount, count);
            }
        }
        StringBuffer output = new StringBuffer();
        Set<String> keySet = map.keySet();
        for (String atom : keySet) {
            int count = map.get(atom);
            output.append(atom);
            if (count > 1)
                output.append(count);
        }
        return output.toString();
    }
}
