package com.gpfaltz;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("credit")
public class CreditResource {

	@Inject
	CreditService creditService;

	@GET
	@Path("newOrderValue")
	@Produces(MediaType.TEXT_PLAIN)
	public Response newOrderValue(Long orderId, int value) {
		try {
			creditService.newOrderValue(orderId, value);
			return Response.ok().entity("All good").build();
		} catch (IllegalStateException e) {
			return Response.status(Status.NOT_ACCEPTABLE).entity("Something went wrong").build();
		}
	}

	@GET
	@Path("cancelOrderValue")
	@Produces(MediaType.TEXT_PLAIN)
	public void cancelOrderValue(Long id) {
		creditService.cancelOrderValue(id);
	}

	@GET
	@Path("getTotalCredit")
	public int getTotalCredit() {
		return creditService.getTotalCredit();
	}

}
