package Listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listen implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("servletcontent初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
