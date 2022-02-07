import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        int[] list_sizes = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096};  //the lengths of the lists to be sorted
        String[] sort_types = {"CombSort", "BitonicSort", "ShakerSort", "StoogeSort", "GnomeSort"}; //sort types keys

        System.out.println("Average Case Sorts");
        System.out.print("Algorithms/n\t");
        for (int y = 0; y < list_sizes.length; y++) {
            System.out.print(list_sizes[y] + ((y == list_sizes.length - 1) ? "" : "\t"));
        }
        System.out.print("\n");
        for (int p = 0; p < sort_types.length; p++) {
            System.out.print(sort_types[p] + "\t");
            for (int u = 0; u < list_sizes.length; u++) {
                sort(list_sizes[u], sort_types[p], Global.SortingKinds.Average);  //to calculate times average cases of lists
                System.out.print((u == list_sizes.length - 1) ? "" : "\t");
            }
            System.out.print("\n");
        }

        System.out.println("Worst Case Sorts");
        System.out.print("Algorithms/n\t");
        for (int y = 0; y < list_sizes.length; y++) {
            System.out.print(list_sizes[y] + ((y == list_sizes.length - 1) ? "" : "\t"));
        }
        System.out.print("\n");
        for (int p = 0; p < sort_types.length; p++) {
            System.out.print(sort_types[p] + "\t");
            for (int u = 0; u < list_sizes.length; u++) {
                sort(list_sizes[u], sort_types[p], Global.SortingKinds.Worst);  //to calculate times worst cases of lists
                System.out.print((u == list_sizes.length - 1) ? "" : "\t");
            }
            System.out.print("\n");
        }

        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l"};  //objects string attributes to check stable or not
        my_obj[] reserve = new my_obj[8];

        for (int i = 0; i < reserve.length; i++) {
            reserve[i] = new my_obj((i+2)/2,letters[i]);  //assign their attributes to each objects for stability check
        }

        Collections.shuffle(Arrays.asList(reserve));
        for (int u=1;u<6;u++){
            stable_control(u,reserve);  //stable_control execute and it prints that given function is stable or not
        }
    }

    private static void stable_print(my_obj[] stability_test_list) {
        for (my_obj my_obj : stability_test_list) {
            System.out.print(my_obj.attr + "-" + my_obj.attr2 + "\t");
        }
        System.out.print("\n");
    }
    private static void stable_control(int a,my_obj[] reserve){ //this function indicates whether the given list is stable in sorting algorithms
        my_obj[] stability_test_list=reserve.clone();
        if(a==1){
            comb_sort combstability = new comb_sort();
            System.out.println("Comb Sort isn't stable.");
            stable_print(stability_test_list);
            combstability.sort(stability_test_list);  //execute comb sort function
        }else if(a==2){
            bitonic_sort bitonicstability = new bitonic_sort();
            System.out.println("Bitonic Sort isn't stable.");
            stable_print(stability_test_list);
            bitonicstability.sort(stability_test_list, stability_test_list.length, 1);  //execute bitonic sort function
        }else if(a==3){
            shaker_sort shakerstability = new shaker_sort();
            System.out.println("Shaker Sort is stable.");
            stable_print(stability_test_list);
            shakerstability.sort(stability_test_list);  //execute shaker sort function
        }else if(a==4){
            stooge_sort stoogestability = new stooge_sort();
            System.out.println("Stooge Sort isn't stable.");
            stable_print(stability_test_list);
            stoogestability.sort(stability_test_list,0,stability_test_list.length-1);  //execute stooge sort function
        }else{
            gnome_sort gnomestability = new gnome_sort();
            System.out.println("Gnome Sort is stable.");
            stable_print(stability_test_list);
            gnomestability.sort(stability_test_list);  //execute gnome sort function
        }
        stable_print(stability_test_list);
    }

    private static void sort(int size, String sortingTypes, Global.SortingKinds sortingKinds) {
        long startTime = 0, endTime = 0, duration = 0;
        for (int y = 0; y < 1001; y++) {   //this loop repeat same process to get a more realistic result
            my_obj[] unsorted_list = new my_obj[size];  //object list to be sorted
            for (int i = 0; i < unsorted_list.length; i++) {
                unsorted_list[i] = new my_obj(unsorted_list.length - i);  //object list will be decreasing order default.
            }

            if (sortingKinds == Global.SortingKinds.Average) { //if the list should consist of random numbers, the list is shuffled here
                Collections.shuffle(Arrays.asList(unsorted_list));
            }
            //every sorting algorithm has if block to execute which sorting algorithm should be executed
            if (sortingTypes.equals(Global.SortingTypes.BitonicSort.toString())) {
                bitonic_sort a = new bitonic_sort();
                startTime = System.nanoTime();
                a.sort(unsorted_list, unsorted_list.length, 1);  //executing the sorting function of bitonic sort
            } else if (sortingTypes.equals(Global.SortingTypes.CombSort.toString())) {
                comb_sort a = new comb_sort();
                startTime = System.nanoTime();
                a.sort(unsorted_list);  //executing the sorting function of comb sort
            } else if (sortingTypes.equals(Global.SortingTypes.GnomeSort.toString())) {
                gnome_sort a = new gnome_sort();
                startTime = System.nanoTime();
                a.sort(unsorted_list);  //executing the sorting function of gnome sort
            } else if (sortingTypes.equals(Global.SortingTypes.ShakerSort.toString())) {
                shaker_sort a = new shaker_sort();
                startTime = System.nanoTime();
                a.sort(unsorted_list);  //executing the sorting function of shaker sort
            } else if (sortingTypes.equals(Global.SortingTypes.StoogeSort.toString())) {
                stooge_sort a = new stooge_sort();
                startTime = System.nanoTime();  //executing the sorting function of stooge sort
                a.sort(unsorted_list, 0, unsorted_list.length - 1);
            } else {
                System.out.println("Error in sortingTypes!!!");
            }
            endTime = System.nanoTime();

            if (y > 0) {
                duration += (endTime - startTime);  //this line add elapsing time to duration
            }
        }
        System.out.print(duration / 1000);
    }
}