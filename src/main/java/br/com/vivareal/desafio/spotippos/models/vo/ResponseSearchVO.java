package br.com.vivareal.desafio.spotippos.models.vo;

import br.com.vivareal.desafio.spotippos.models.Property;

import java.util.ArrayList;
import java.util.List;

public class ResponseSearchVO {
    private Integer foundProperties = 0;
    private List<Property> properties;

    public Integer getFoundProperties() {
        return getProperties().size();
    }

    public void setFoundProperties(Integer foundProperties) {
        this.foundProperties = foundProperties;
    }

    public List<Property> getProperties() {
        if (properties == null) {
            properties = new ArrayList<>();
        }
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public void addProperty(Property property) {
        getProperties().add(property);
    }
}
