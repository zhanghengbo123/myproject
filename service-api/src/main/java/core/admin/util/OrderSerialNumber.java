package core.admin.util;

public abstract class OrderSerialNumber {

    public synchronized String getSerialNumber() {
        return process();
    }
    protected abstract String process();
}
