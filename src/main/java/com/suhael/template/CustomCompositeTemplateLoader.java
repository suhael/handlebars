package com.suhael.template;

import com.github.jknack.handlebars.io.CompositeTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;

public class CustomCompositeTemplateLoader extends CompositeTemplateLoader {

    public CustomCompositeTemplateLoader(){
        super();
    }

    public CustomCompositeTemplateLoader(TemplateLoader... loaders){
        super(loaders);
    }

    public String getSuffix() {
        return ".html";
    }
}
