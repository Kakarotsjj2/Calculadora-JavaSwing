import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Stack<Integer> pila = new Stack<>();

        pila.push(5);
        pila.push(8);
        pila.push(3);

        System.out.println(pila);

        System.out.println("Sale: " + pila.pop());

        System.out.println(pila);

        pila.push(10);

        System.out.println(pila);
    }
}