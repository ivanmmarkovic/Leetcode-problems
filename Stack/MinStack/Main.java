

public class Main {
    public static void main(String[] args) {

        MinStack ms = new MinStack();

        System.out.println(ms.peek()); // null
        System.out.println(ms.getMin()); // null

        ms.push(3);
        System.out.println(ms.peek()); // 3
        System.out.println(ms.getMin()); // 3


        ms.push(1);
        System.out.println(ms.peek()); // 1
        System.out.println(ms.getMin()); // 1


        ms.push(5);
        System.out.println(ms.peek()); // 5
        System.out.println(ms.getMin()); // 1


        ms.push(1);
        System.out.println(ms.peek()); // 1
        System.out.println(ms.getMin()); // 1

        System.out.println("----------------------");
        ms.pop();
        System.out.println(ms.peek()); // 5
        System.out.println(ms.getMin()); // 1

        System.out.println("---------------------");
        while(!ms.isEmpty()){
            System.out.println(ms.pop());
        }

    }
    
}