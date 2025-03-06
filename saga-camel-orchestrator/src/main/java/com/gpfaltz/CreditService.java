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
@RegisterRestClient(baseUri = "http://saga-camel-credit-gpfaltz-dev.apps.rm2.thpm.p1.openshiftapps.com/credit")
public interface CreditService {

	@GET
	@Path("newOrderValue")
	@Produces(MediaType.TEXT_PLAIN)
	public void newOrderValue(@QueryParam("orderId") @Header("id") Long orderId, @Header("value") int value);

	@GET
	@Path("cancelOrderValue")
	@Produces(MediaType.TEXT_PLAIN)
	public void cancelOrderValue(@QueryParam("id") @Header("id") Long id);

	@GET
	@Path("getTotalCredit")
	@Produces(MediaType.TEXT_PLAIN)
	public int getTotalCredit();
}
