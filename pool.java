public class pool {
    static int[] pool = new int[5];
    public static void allocate() {
        for (int i = 0; i < pool.length; i++) {
            if (pool[i] == 0) {
                pool[i] = 1;
                System.out.println("Memory allocated at block " + i);
                return;
            }
        }
        System.out.println("It is full");
    }
    public static void free(int index) {
        pool[index] = 0;
        System.out.println("Memory freed at block " + index);
    }
    public static void display() {
        System.out.println("Memory Status:");
        for (int i = 0; i < pool.length; i++) {
            System.out.println("Block " + i + " = " + pool[i]);
        }
    }
    public static void main(String[] args) {
        allocate();
        allocate();
        display();
        free(0);
        display();
    }
}