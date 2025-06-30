package string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }

    public static String convert(String s, int numRows) {
        List<List<Character>> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }
        int dir = 1; //1 pastga 2 bo'lsa diagonal
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (dir==1 && k < numRows){
                list.get(k).add(s.charAt(i));
                if (k<numRows-1) {
                    k++;
                }else {
                    dir=2;
                    k--;
                }
            }else {
                if (dir == 2 && k>0){
                    list.get(k).add(s.charAt(i));
                    k--;
                }
                if(k==0){
                    dir = 1;
                }
            }
        }
        return list.stream()
                .flatMap(List::stream)        // ichki listlarni tekislash
                .map(String::valueOf)         // har bir Character ni String ga aylantirish
                .collect(Collectors.joining());
    }

    public static String convertOrg(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        List<List<Character>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }

        int row = 0;
        boolean down = true;

        for (char c : s.toCharArray()) {
            list.get(row).add(c);
            if (row == 0) down = true;
            else if (row == numRows - 1) down = false;

            row += down ? 1 : -1;
        }

        return list.stream()
                .flatMap(List::stream)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}
