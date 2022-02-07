import java.lang.Math;

public class comb_sort {
    void sort(my_obj[] input) {
        int gap = input.length;
        double shrink = 1.3;
        boolean sorted = false;

        while (!sorted) {
            gap = (int) Math.floor(gap / shrink);
            if (gap <= 1) {
                gap = 1;
                sorted = true;
            }
            int i = 0;
            while (i + gap < input.length) {
                if (input[i].attr > input[i + gap].attr) {
                    my_obj temp = input[i];
                    input[i] = input[i + gap];
                    input[i + gap] = temp;
                    sorted = false;
                }
                i++;
            }
        }
    }
}
