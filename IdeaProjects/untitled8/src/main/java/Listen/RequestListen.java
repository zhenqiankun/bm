package Listen;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListen implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("request销毁");
    }
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("request初始化");
    }
}
