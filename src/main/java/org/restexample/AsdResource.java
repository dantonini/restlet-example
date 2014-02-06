package org.restexample;

import org.restlet.ext.rdf.Graph;
import org.restlet.ext.rdf.Literal;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class AsdResource extends ServerResource {

	@Get("json")
	public String json() {
		System.out.println(getPreferredVariant(getVariants()));
		return "{\"test\":\"json\"}";
	}

	@Get("xml")
	public String xml() {
		System.out.println(getPreferredVariant(getVariants()));
		return "<asd>test xml</asd>";
	}

	@Get("rdf|n3")
	public Graph other() {
		System.out.println(getPreferredVariant(getVariants()));
		Graph graph = new Graph();
		graph.add(getReference(), "http://predicate/asd#gdfw", new Literal(
				"asd"));
		return graph;
	}

	@Get("txt")
	public String asd() {
		System.out.println(getPreferredVariant(getVariants()));
		return "test asd";
	}
}
