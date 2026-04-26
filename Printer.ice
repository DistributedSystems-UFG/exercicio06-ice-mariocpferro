module Demo
{
    sequence<string> StringSeq;

    interface Printer
    {
        string printString(string s);
        string printLines(StringSeq lines);
        int getPageCount();
    }
}
