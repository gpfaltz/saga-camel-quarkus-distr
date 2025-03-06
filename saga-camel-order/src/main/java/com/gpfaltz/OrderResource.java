package com.gpfaltz;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("order")
public class OrderResource {

	@Inject
	OrderService orderService;

	@Path("newOrder")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public void newOrder(@QueryParam("id") Long id) {
		orderService.newOrder(id);

	}

	@Path("cancelOrder")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public void cancelOrder(@QueryParam("id") Long id) {
		orderService.cancelOrder(id);

	}

}
