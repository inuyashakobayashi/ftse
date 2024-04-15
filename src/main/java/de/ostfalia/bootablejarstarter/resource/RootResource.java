package de.ostfalia.bootablejarstarter.resource;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("/")
public class RootResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRootResource() {
        List<Map<String, String>> links = new ArrayList<>();
        links.add(Map.of("href", "http://localhost:8083/addresses"));
        links.add(Map.of("href", "http://localhost:8083/customers"));
        links.add(Map.of("href", "http://localhost:8083/payments"));


        return Response.ok(links).build();
    }
}