public class bitonic_sort {
    void compAndSwap(my_obj[] input, int i, int j, int dir) {
        if ((input[i].attr > input[j].attr && dir == 1) || (input[i].attr < input[j].attr && dir == 0)) {
            my_obj temp = input[i];
            input[i] = input[j];
            input[j] = temp;
        }
    }

    void bitonicMerge(my_obj[] input, int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++)
                compAndSwap(input, i, i + k, dir);
            bitonicMerge(input, low, k, dir);
            bitonicMerge(input, low + k, k, dir);
        }
    }

    void bitonicSort(my_obj[] input, int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            bitonicSort(input, low, k, 1);
            bitonicSort(input, low + k, k, 0);
            bitonicMerge(input, low, cnt, dir);
        }
    }

    void sort(my_obj[] input, int N, int up) {
        bitonicSort(input, 0, N, up);
    }
}
