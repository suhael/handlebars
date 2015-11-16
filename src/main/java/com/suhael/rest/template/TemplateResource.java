package com.suhael.rest.template;

import com.suhael.rest.ResponseBuilder;
import com.suhael.template.TemplateFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("page")
@RequestScoped
public class TemplateResource {

    private static final String VIEW_PATH = "/cmd/";

    @Inject
    private TemplateFactory templateFactory;

    @Context
    private ServletContext servletContext;

    @GET
    @Path("{brand}/{page}")
    @Produces(MediaType.TEXT_HTML)
    public Response getTemplate(@PathParam("brand")String brand, @PathParam("page")String page) throws IOException {

        String html = templateFactory.getTemplate(brand, page);
        return ResponseBuilder.returnHTMLResponse(html);
    }
}
