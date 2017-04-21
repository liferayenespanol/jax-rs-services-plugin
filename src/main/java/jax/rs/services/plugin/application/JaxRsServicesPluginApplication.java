package jax.rs.services.plugin.application;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

@ApplicationPath("/rest")
@Component(immediate = true, service = Application.class)
public class JaxRsServicesPluginApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces("text/plain")
	public String funciona() {
		return "¡Esto funciona!";
	}

	@GET
	@Path("/saludar")
	@Produces("text/plain")
	public String hello() {
		return "¡Hola!";
	}

	@GET
	@Path("/saludar/{nombre}")
	@Produces("text/plain")
	public String saludarPath(@PathParam("nombre") String nombre) {
		return  "¡Hola " + nombre + "!";
	}
	
	@GET
	@Path("/saludar")
	@Produces("text/plain")
	public String saludarQuery(@QueryParam("nombre") String nombre) {
		return "¡Hola " + nombre + "!";
	}
	
}