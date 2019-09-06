

public class Main {
    public static void main(String[] args) {

        MaxStack ms = new MaxStack();
        ms.push(100);
        System.out.println(ms.peek());
        System.out.println(ms.getMax());

        ms.push(2);
        System.out.println(ms.peek());
        System.out.println(ms.getMax());
        System.out.println("------------------");
        while(!ms.isEmpty()){
            System.out.println(ms.pop());
        }
    }
    
}