package com.suhael.template;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.cache.ConcurrentMapTemplateCache;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class HandleBarsProducer {

    private static final String TEMPLATE_PATH = "/templates";
    private static final String VIEW_PATH = "/views";
    public static final String HTML = ".html";

    @Produces
    public Handlebars createHandleBars(){
        System.out.println("its in here");
        TemplateLoader cploader = new ClassPathTemplateLoader(VIEW_PATH, HTML);
        TemplateLoader cploader2 = new ClassPathTemplateLoader(TEMPLATE_PATH, HTML);
        return new Handlebars(new CustomCompositeTemplateLoader(cploader, cploader2)).with(new ConcurrentMapTemplateCache());
    }
}
