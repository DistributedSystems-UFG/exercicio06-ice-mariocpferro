import com.zeroc.Ice.*;

public class Client {
    public static void main(String[] args) {
        // 1. Initialize the Ice communicator within a try-with-resources block
        try (Communicator communicator = Util.initialize(args)) {

            // 2. Create a proxy to the remote 'Printer' object
            // Replace '10.0.0.5' with the actual IP of your ICE server
            ObjectPrx base = communicator.stringToProxy("SimplePrinter:default -h 98.90.53.6 -p 5678");

            // 3. Downcast the proxy to the Printer interface
            Demo.PrinterPrx printer = Demo.PrinterPrx.checkedCast(base);

            if (printer == null) {
                throw new Error("Invalid proxy");
            }

            String response = printer.printString("Hello from Goiania!");
            System.out.println("Server responded: " + response);

            String[] lines = {"Line 1: foo", "Line 2: bar", "Line 3: baz"};
            String linesResponse = printer.printLines(lines);
            System.out.println("Server responded: " + linesResponse);

            int count = printer.getPageCount();
            System.out.println("Total pages printed: " + count);

        } catch (LocalException e) {
            e.printStackTrace();
        }
    }
}
