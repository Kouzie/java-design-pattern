package proxy;

public interface Printable {
    public abstract String getPrinterName();
    public abstract void setPrinterName(String printerName);
    public abstract void print(String str);
}
