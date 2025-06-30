import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")))()"));
    }

    public static int longestValidParentheses(String s) {
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // Boshlang'ich qiymat sifatida -1 indeksini qo'shamiz

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // '(' uchratsa, uning indeksini stack'ga qo'shamiz
                stack.push(i);
            } else {
                // ')' uchratsa, stack'dan bir elementni olib tashlaymiz
                stack.pop();
                if (stack.isEmpty()) {
                    // Agar stack bo'sh bo'lsa, yangi boshlang'ich nuqta sifatida joriy indeksni qo'shamiz
                    stack.push(i);
                } else {
                    // Aks holda, joriy indeks bilan stack'ning eng tepasidagi indeksni ayirib,
                    // to'g'ri qavslar ketma-ketligining uzunligini hisoblaymiz
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}
