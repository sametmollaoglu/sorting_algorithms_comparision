public class gnome_sort {
    void sort(my_obj[] input) {
        int pos = 0;
        while (pos < input.length) {
            if (pos == 0 || input[pos].attr >= input[pos - 1].attr) {
                pos++;
            } else {
                my_obj temp = input[pos];
                input[pos] = input[pos - 1];
                input[pos - 1] = temp;
                pos--;
            }
        }
    }
}
