package stack;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    private final Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList){
        stack = new Stack<>();
        // Stackga elementlarni teskari tartibda yuklash
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }


    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger top = stack.peek(); // Stackning yuqori elementini tekshirish
            if (top.isInteger()) {
                return true; // Agar integer bo‘lsa, `true`
            }
            // Agar ro‘yxat bo‘lsa, stackdan chiqarib, ichidagi elementlarni qo‘shamiz
            stack.pop();
            for (int i = top.getList().size() - 1; i >= 0; i--) {
                stack.push(top.getList().get(i));
            }
        }
        return false; // Stack bo‘sh bo‘lsa, `false`
    }

    @Override
    public Integer next() {
        // `hasNext` orqali integer mavjudligiga ishonch hosil qilamiz
        if (!hasNext()) throw new NoSuchElementException();
        return stack.pop().getInteger(); // Stackning yuqori elementini qaytarish
    }
}
