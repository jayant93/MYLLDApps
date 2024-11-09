import org.jay.singleton.Singleton;
import org.jay.stack.Stack;
import org.jay.stack.StackInterface;

/**
 * Driver Class
 */
public class DriverClass
{
    public static void main( String[] args )
    {
        Singleton object = Singleton.getSingletonObject();
        object.showMessage();

        StackInterface<Integer> stack = new Stack<Integer>();
        for(int i=0;i<100;i++){
          stack.push(i);
        }
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

    }
}
