package de.ostfalia.bootablejarstarter.resource;

import de.ostfalia.bootablejarstarter.entity.Address;
import de.ostfalia.bootablejarstarter.service.AddressService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/addresses")
public class AddressResource {
    @Inject
    AddressService addressService;
    @GET
    @Path("{page}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAddress(@PathParam("page") Integer page){
        return Response.ok(addressService.getAddressListWithPage(page)).build();

    }
}
