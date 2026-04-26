import com.zeroc.Ice.*;

public class Server {
    public static void main(String[] args) {
        try (Communicator communicator = Util.initialize(args)) {

            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints(
                    "SimplePrinterAdapter", "default -p 5678");

            Demo.Printer servant = new PrinterI();
            adapter.add(servant, Util.stringToIdentity("SimplePrinter"));
            adapter.activate();

            System.out.println("Server running on port 5678...");
            communicator.waitForShutdown();

        } catch (LocalException e) {
            e.printStackTrace();
        }
    }
}
