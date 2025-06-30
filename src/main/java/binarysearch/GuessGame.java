package binarysearch;

public  class GuessGame {

   static int guess(int num) {
        if (num == 6) return 0;
        if (num>6) return -1;
        else return 1;
    }

}
