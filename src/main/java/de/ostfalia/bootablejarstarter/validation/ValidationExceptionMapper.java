package de.ostfalia.bootablejarstarter.validation;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import jakarta.validation.ConstraintViolationException;


@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {
        // 创建自定义响应体，例如使用JSON构建器
        // 这里仅作为例子，具体实现可以根据需要调整
        String json = "{\"classViolations\":[],\"parameterViolations\":[{\"constraintType\":\"PARAMETER\",\"message\":\"" + e.getMessage() + "\",\"path\":\"allAddresses.page\",\"value\":\"0\"}],\"propertyViolations\":[],\"returnValueViolations\":[]}";
        return Response.status(Response.Status.BAD_REQUEST).entity(json).type(MediaType.APPLICATION_JSON).build();
    }
}
