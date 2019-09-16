package demo2;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("home")
public class Resource {

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {

        return "Hello World!_!_!_!";
    }
    //@QueryParam for the given name of the parameter in the URI, and assign this to the following variable String name. By typing ?name=Umut at the end of the URI, you assign the variable name to Umut.
    @GET
    @Path("param")
    @Produces(MediaType.TEXT_PLAIN)
    public String paramMethod(@QueryParam("name") String name) {

        return "Hello, " + name;
    }
    //http://localhost:2222/home/path/Umut this method will return "Hello, Umut" to the browser.
    @GET
    @Path("path/{var}")
    @Produces(MediaType.TEXT_PLAIN)
    public String pathMethod(@PathParam("var") String name) {

        return "Hello, " + name;
    }

    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String postMethod(@FormParam("name") String name,String s,@FormParam("password") int password) {
        if(name.equalsIgnoreCase("umut")) {
            s = "<h2>Hello, " + name + "</h2>";
        }
        else
            s = "no";
        return s;
    }
    /*@POST
    @Path("post1")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String post2Method(@FormParam("name") String name) {
        return "<h2>Hellooooo, " + name + "</h2>";
    }*/
}
