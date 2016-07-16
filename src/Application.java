
public class Application {
    public static void main(String[] args) {
        if (args.length > 0)
            System.out.print(args[0] + " + 1 = ");
            System.out.println(computeInputPlusOne(Integer.parseInt(args[0])));
    }

    public static int computeInputPlusOne(int number) {
        return number + 1;
    }
}
