package com.suhael.rest.menu;

import com.suhael.rest.ResponseBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Path("menu")
public class MenuResource {

    @GET
    @Path("v1")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBasicMenuData() throws IOException {
        return ResponseBuilder.returnJsonResponse(new Menu());
    }

    @GET
    @Path("v1/ml")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMenuDataForMl() throws IOException {
        return ResponseBuilder.returnJsonResponse(new Menu());
    }

    @GET
    @Path("v1/saf")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMenuDataForSaf() throws IOException {
        Menu menu = new Menu();
        menu.setMenuItems(Arrays.asList("home", "search", "edit", "contact"));
        return ResponseBuilder.returnJsonResponse(menu);
    }

    @GET
    @Path("v1/sea")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMenuDataForSea() throws IOException {
        return ResponseBuilder.returnJsonResponse(new Menu());
    }

    private class Menu {
        private List<String> menuItems = Arrays.asList("home", "search", "edit");

        public List<String> getMenuItems() {
            return menuItems;
        }

        public void setMenuItems(List<String> menuItems) {
            this.menuItems = menuItems;
        }
    }
}
