package demo2;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;



public class App {

    public static void main(String[] args) throws Exception {
        //ResourceConfig (Jersey) inherit from Application and gives a new configuration without custom properties
        ResourceConfig config = new ResourceConfig();
        config.packages("demo2");
        //ServletHolder (Jetty) is a Servlet instance and context holder. 
        //It holds name, parameters and some states of javax.servlet.Servlet instance. 
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));


        Server server = new Server(2222);
        //ServletContextHandler (Jetty) takes the arguments HandlerContainer and contextPath. 
        //It gives Servlet context and is and extends ContextHandler.
        ServletContextHandler context = new ServletContextHandler(server, "/*");
        //convenience method to add a Servlet.
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
