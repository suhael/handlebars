package com.suhael.template;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.suhael.template.brands.ml.MLTemplateContext;
import com.suhael.template.brands.saf.SAFTemplateContext;
import com.suhael.template.brands.sea.SEATemplateContext;

import javax.inject.Inject;
import java.io.IOException;

//@ApplicationScoped
public class TemplateFactory {

    @Inject
    private Handlebars handlebars;

    public String getTemplate(String brand, String view)
            throws IOException {

        //this.handlebars = HandleBarsProducer.createHandleBars();
        TemplateContext context = null;
        Template template = null;

        if(brand.equalsIgnoreCase("ml")){
            //template = compileTemplate(view).as(MLTemplate.class);
            template = compileTemplate(view);
            context = new MLTemplateContext();
        } else if(brand.equalsIgnoreCase("saf")){
            //template = compileTemplate(view).as(SAFTemplate.class);
            template = compileTemplate(view);
            context = new SAFTemplateContext();
        } else if(brand.equalsIgnoreCase("sea")){
            template = compileTemplate(view);
            //template = compileTemplate(view).as(SEATemplate.class);
            context = new SEATemplateContext();
        }

        return generateHTML(template, context.createContext());
    }

    public Template compileTemplate(String template) throws IOException {
        return handlebars.compile(template);
    }

    public String generateHTML(Template template, Object context) throws IOException {
        return template.apply(context);
    }
}
