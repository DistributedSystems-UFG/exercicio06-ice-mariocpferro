import com.zeroc.Ice.Current;

public class PrinterI implements Demo.Printer {

    private int pageCount = 0;

    @Override
    public String printString(String s, Current current) {
        pageCount++;
        System.out.println("[printString] " + s);
        return "Printed: " + s;
    }

    @Override
    public String printLines(String[] lines, Current current) {
        pageCount++;
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            System.out.println("[printLines] " + line);
            sb.append(line).append("\n");
        }
        return "Printed " + lines.length + " line(s):\n" + sb.toString().trim();
    }

    @Override
    public int getPageCount(Current current) {
        return pageCount;
    }
}
