package com.academysmart.restsqrt;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.academysmart.restsqrt.resource.SqrtResource;

public class RestSqrtApplication extends Application {
	@Override
	public synchronized Restlet createInboundRoot() {
		Router router = new Router(getContext());
		
		router.attachDefault(SqrtResource.class);
		return router;
	}
}
