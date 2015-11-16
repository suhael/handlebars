package com.suhael.template.brands.sea;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.suhael.template.TemplateContext;

import java.io.IOException;
import java.net.URL;

public class SEATemplateContext extends TemplateContext {

    protected JsonNode createModel() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode model = mapper.readTree(new URL("http://localhost:7001/pageTemplate-1.0.0-SNAPSHOT/rest/menu/v1/sea"));
        ((ObjectNode) model).put("title", "Sealand");
        ((ObjectNode) model).put("brandCode", "sea");
        return model;
    }
}
