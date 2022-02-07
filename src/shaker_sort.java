public class shaker_sort {
    void sort(my_obj[] input) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < input.length - 1; i++) {
                if (input[i].attr > input[i + 1].attr) {
                    my_obj temp1 = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp1;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int k = 0; k < input.length - 1; k++) {
                if (input[k].attr > input[k + 1].attr) {
                    my_obj temp2 = input[k];
                    input[k] = input[k + 1];
                    input[k + 1] = temp2;
                    swapped = true;
                }
            }
        } while (
                swapped
        );
    }
}
