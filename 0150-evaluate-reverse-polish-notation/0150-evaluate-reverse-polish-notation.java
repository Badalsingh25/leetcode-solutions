class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-":
                    int a1 = stack.pop();
                    int b1 = stack.pop();
                    stack.push(b1 - a1);
                    break;

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/":
                    int a2 = stack.pop();
                    int b2 = stack.pop();
                    stack.push(b2 / a2);
                    break;

                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}