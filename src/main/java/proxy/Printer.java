package proxy;

public class Printer implements Printable {
    private String printerName;

    public Printer() {
        heavyJob("printer 의 인스턴스 생성중");
    }

    public Printer(String printerName) {
        this.printerName = printerName;
        heavyJob("printer 의 인스턴스 (" + printerName + ") 을 생성중");
    }

    @Override
    public String getPrinterName() {
        return this.printerName;
    }

    @Override
    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public void print(String str) {
        System.out.println("=======" + printerName + "=======");
        System.out.println(str);
    }

    private void heavyJob(String msg) {
        System.out.println(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }
        System.out.println("완료.");
    }
}
