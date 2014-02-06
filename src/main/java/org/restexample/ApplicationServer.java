package org.restexample;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class ApplicationServer extends Application {

	public static void main(String[] args) throws Exception {
		Server server = new Server(Protocol.HTTP, 8080);
		server.setNext(new ApplicationServer());
		server.start();
	}

	public ApplicationServer() {
		setName("Test");
		setDescription("asdasd");
		setAuthor("Daniele Antonini");
		setOwner("Owner");
	}

	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		router.attach("http://localhost:8080/asd", AsdResource.class);
		return router;
	}
}
