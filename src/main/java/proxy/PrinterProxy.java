package proxy;

public class PrinterProxy implements Printable {

    private String printerName;
    private Printer real;

    public PrinterProxy(String printerName) {
        this.printerName = printerName;
    }

    @Override
    public String getPrinterName() {
        return this.printerName;
    }

    @Override
    public void setPrinterName(String printerName) {
        synchronized (this) {
            if (real != null) {
                // null 이 아니라면 설정
                real.setPrinterName(printerName);
            }
        }
        this.printerName = printerName;
    }

    public synchronized void realize() {
        if (real == null) {
            real = new Printer(printerName);
        }
    }

    @Override
    public void print(String str) {
        realize(); //인스턴스 생성
        real.print(str);
    }
}
