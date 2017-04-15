package br.com.vivareal.desafio.spotippos.models.vo;

import br.com.vivareal.desafio.spotippos.models.Property;

import java.util.List;

public class PropertiesVO {
    private Integer totalProperties;
    private List<Property> properties;

    public Integer getTotalProperties() {
        return totalProperties;
    }

    public void setTotalProperties(Integer totalProperties) {
        this.totalProperties = totalProperties;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
