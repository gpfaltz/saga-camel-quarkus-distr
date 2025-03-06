package com.gpfaltz;

import org.apache.camel.Header;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@RegisterRestClient(baseUri = "http://saga-camel-order-gpfaltz-dev.apps.rm2.thpm.p1.openshiftapps.com/order")
public interface OrderService {

	@GET
	@Path("newOrder")
	@Produces(MediaType.TEXT_PLAIN)
	public void newOrder(@QueryParam("id") @Header("id") Long id);

	@GET
	@Path("cancelOrder")
	@Produces(MediaType.TEXT_PLAIN)
	public void cancelOrder(@QueryParam("id") @Header("id") Long id);
}
