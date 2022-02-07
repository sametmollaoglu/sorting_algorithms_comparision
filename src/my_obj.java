public class my_obj {
    public int attr;
    public String attr2;

    public my_obj(int attr, String attr2) {
        this.attr = attr;
        this.attr2 = attr2;  //i take as a parameter in constructor to test stability of given sorting algorithm
    }

    public my_obj(int attr) {
        this.attr = attr;
        this.attr2 = "a";  // i give "a" letter to attr2 for sorting algorithms
    }
}
