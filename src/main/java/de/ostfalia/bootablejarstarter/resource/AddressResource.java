package de.ostfalia.bootablejarstarter.resource;

import de.ostfalia.bootablejarstarter.entity.Address;
import de.ostfalia.bootablejarstarter.service.AddressService;
import jakarta.inject.Inject;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/addresses")
public class AddressResource {
    @Inject
    AddressService addressService;
    @GET

    @Produces(MediaType.APPLICATION_JSON)
    public Response getAddress(@Min(value = 1 ,message = "muss größer als 0 sein")@DefaultValue ("1")@QueryParam("page") Integer page){
        return Response.ok(addressService.getAddressListWithPage(page)).build();

    }
}
