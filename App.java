package demo2;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;



public class App {

    public static void main(String[] args) throws Exception {

        ResourceConfig config = new ResourceConfig();
        config.packages("demo2");
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));


        Server server = new Server(2222);
        ServletContextHandler context = new ServletContextHandler(server, "/*");
        context.addServlet(servlet, "/*");

        try {
            server.start();
            server.join();
        } catch (Exception e){
           // logger.errror("error during server starting",e)
            server.stop();
            server.destroy();
        }
    }
}