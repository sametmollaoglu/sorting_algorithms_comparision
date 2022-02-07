public class stooge_sort {
    void sort(my_obj[] input, int i, int j) {
        if (input[i].attr > input[j].attr) {
            my_obj temp = input[i];
            input[i] = input[j];
            input[j] = temp;
        }
        if ((j - i + 1) > 2) {
            int t = (int) Math.floor(((double) j - (double)i + 1) / 3);
            sort(input, i, j - t);
            sort(input, i + t, j);
            sort(input, i, j - t);
        }
    }
}
