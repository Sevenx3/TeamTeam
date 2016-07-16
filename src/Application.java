
public class Application {
	
	private static final int ARGUMENTS = 2;
	
    public static void main(String[] args) {
        if (args.length > 0){
            System.out.print(args[0] + " + 1 = ");
            System.out.println(computeInputPlusOne(Integer.parseInt(args[0])));
        }
        if (args.length > ARGUMENTS){
        	
        }
    }

    public static int computeInputPlusOne(int number) {
        return number + 1;
    }
    
}
