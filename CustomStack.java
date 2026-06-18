public class CustomStack {
    
    int[] stack;
    int top;
    
    public CustomStack() {
        stack = new int[100];
        top = -1;
    }
    
    public void push(int x) {
        if (top < 99) {
            top++;
            stack[top] = x;
        }
    }
    
    public int pop() {
        if (top >= 0) {
            int value = stack[top];
            top--;
            return value;
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < k && i <= top; i++) {
            stack[i] = stack[i] + val;
        }
    }
    
    public void print() {
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        CustomStack s = new CustomStack();
        
        s.push(10);
        s.push(20);
        s.push(30);
        s.print();
        
        s.increment(2, 5);
        s.print();
        
        System.out.println("Pop: " + s.pop());
        s.print();
    }
}