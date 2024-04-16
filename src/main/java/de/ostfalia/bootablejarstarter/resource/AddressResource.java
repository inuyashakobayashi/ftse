package de.ostfalia.bootablejarstarter.resource;

import de.ostfalia.bootablejarstarter.entity.Address;
import de.ostfalia.bootablejarstarter.service.AddressService;
import jakarta.inject.Inject;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.Context;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Path("/addresses")
public class AddressResource {
    @Inject
    AddressService addressService;
    @Context
    private UriInfo uriInfo;
    @GET

    @Produces(MediaType.APPLICATION_JSON)
    public Response getAddress(@Min(value = 1 ,message = "muss größer als 0 sein")@DefaultValue ("1")@QueryParam("page") Integer page){
        //return Response.ok(addressService.getAddressListWithPage(page)).build();
        List<Map<String, Object>> addresses = addressService.getAddressListWithPage(page);


        int totalPage = addressService.getPageNumber(); // 假设这是获取总页数的方法
        // 构建分页链接
        Link firstPage = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().queryParam("page", 1))
                .rel("first")
                .type("GET")
                .build();
        Link nextPage = null;
        if (page < totalPage) {
            nextPage = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().queryParam("page", page + 1))
                    .rel("next")
                    .type("GET")
                    .build();
        }

        Link prevPage = null;
        if (page > 1) {
            prevPage = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().queryParam("page", page - 1))
                    .rel("prev")
                    .type("GET")
                    .build();
        }
        Link lastPage = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().queryParam("page", addressService.getPageNumber()))
                .rel("last")
                .type("GET")
                .build();

        // 创建响应
        return Response.ok(addresses)
                .links(firstPage, prevPage,nextPage, lastPage)
                .build();
    }


}
