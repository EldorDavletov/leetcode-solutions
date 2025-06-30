package string;

public class PerformString {
    public static void main(String[] args) {
        int[][] shift = {
                {1,1},
                {1,1},
                {0,2},
                {1,3}
        };
        System.out.println(stringShift("abcdefg",shift));
    }

    public static String stringShift1(String s, int[][] shift) {
        if (s.length() <= 1) return s;

        StringBuilder sb = new StringBuilder(s);

        for (int[] arr : shift) {
            int direction = arr[0];
            int amount = arr[1];

            // Agar amount string uzunligidan katta bo‘lsa, uni qisqartiramiz
            while (amount > sb.length()) {
                amount -= sb.length(); // Bu modulo o‘rniga ishlaydi, lekin soddaroq
            }

            if (direction == 0) { // Chapga siljitish
                String leftPart = sb.substring(0, amount); // Chapdagi qism
                sb.delete(0, amount).append(leftPart);     // O‘chirib, oxiriga qo‘shamiz
            } else { // O‘ngga siljitish
                String rightPart = sb.substring(sb.length() - amount); // Oxirgi qism
                sb.delete(sb.length() - amount, sb.length()).insert(0, rightPart); // O‘chirib, boshiga qo‘shamiz
            }
        }

        return sb.toString();
    }

    public static String stringShift(String s, int[][] shift) {
        if (s.length() <= 1) return s;

        int totalShift = 0; // Sof siljitish miqdori
        int len = s.length();

        // Har bir shiftni hisoblash
        for (int[] arr : shift) {
            int direction = arr[0];
            int amount = arr[1];
            if (direction == 0) { // Chapga
                totalShift += amount;
            } else { // O‘ngga
                totalShift -= amount;
            }
        }

        // Modulo bilan keraksiz aylanalarni olib tashlash
        totalShift = totalShift % len;
        if (totalShift < 0) {
            totalShift += len; // Agar manfiy bo‘lsa, musbatga aylantiramiz
        }

        // Yakuniy siljitish
        return s.substring(totalShift) + s.substring(0, totalShift);
    }
}



