package com.suhael.template;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.JsonNodeValueResolver;

import java.io.IOException;

public abstract class TemplateContext {

    public Context createContext() throws IOException {
        JsonNode model = createModel();
        Context contextJson = Context
                .newBuilder(model)
                .resolver(JsonNodeValueResolver.INSTANCE)
                .build();

        return contextJson;
    }

    protected abstract JsonNode createModel() throws IOException;
}
