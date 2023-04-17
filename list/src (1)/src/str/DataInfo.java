package str;

public class DataInfo {
    public String name;
    public long[] tab;

    public DataInfo(String name, int size) {
        this.name = name;
        this.tab = new long[size];
    }
}
