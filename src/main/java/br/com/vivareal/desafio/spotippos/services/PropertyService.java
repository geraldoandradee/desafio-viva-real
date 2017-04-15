package br.com.vivareal.desafio.spotippos.services;

import br.com.vivareal.desafio.spotippos.DataSources;
import br.com.vivareal.desafio.spotippos.Utils;
import br.com.vivareal.desafio.spotippos.exceptions.PropertyException;
import br.com.vivareal.desafio.spotippos.models.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private DataSources dataSources;
    @Autowired
    private ProvinceService provinceService;

    /**
     * Para recuperar a propriedade pelo ID
     */
    public Property get(Integer id) {
        if (dataSources.getPropertySession() != null) {
            for (Property property : dataSources.getPropertySession()) {
                if (property.getId().equals(id)) {
                    property.setProvices(provinceService.getProvincesByCoordinates(property.getX(), property.getY()));
                    return property;
                }
            }
        }
        return null;
    }

    /**
     * Para salvar a propriedade.
     */
    public Property save(Property property) throws Exception {
        if (dataSources.getPropertySession() != null) {
            validateProperty(property);
            if (property.getId() != null) {
                Property p = get(property.getId());
                p.setBaths(property.getBaths());
                p.setBeds(property.getBeds());
                p.setDescription(property.getDescription());
                p.setPrice(property.getPrice());
                p.setX(property.getX());
                p.setY(property.getY());
                p.setSquareMeters(property.getSquareMeters());
                p.setTitle(property.getTitle());
                p.setProvices(provinceService.getProvincesByCoordinates(property.getX(), property.getY()));

                return p;
            } else {
                property.setId(getNextId());
                property.setProvices(provinceService.getProvincesByCoordinates(property.getX(), property.getY()));
                dataSources.getPropertySession().add(property);
                return property;
            }
        }
        return null;
    }

    /**
     * Para procurar propriedades.
     */
    public List<Property> search(Integer upperLeftX, Integer upperLeftY, Integer bottomRightX, Integer bottomRightY) {
        List<Property> properties = new ArrayList<>();
        if (dataSources.getPropertySession() != null) {
            for (Property property : dataSources.getPropertySession()) {
                if (Utils.isInRange(property.getX(), property.getY(), upperLeftX, upperLeftY, bottomRightX, bottomRightY)) {
                    property.setProvices(provinceService.getProvincesByCoordinates(property.getX(), property.getY()));
                    properties.add(property);
                }
            }
        }
        return properties;
    }

    private void validateProperty(Property property) throws PropertyException {
        if (property.getX() == null || property.getX() < 0 || property.getX() > 1400) {
            throw new PropertyException("Propriedade fora dos limites de Spotippos. X deve ser maior igual a zero e menor igual a 1400");
        }
        if (property.getY() == null || property.getY() < 0 || property.getY() > 1000) {
            throw new PropertyException("Propriedade fora dos limites de Spotippos. Y deve ser maior igual a zero e menor igual a 1000");
        }
        if (property.getBaths() == null || property.getBaths() > 4 || property.getBaths() < 1) {
            throw new PropertyException("Uma propriedade necessita de pelo ao menos 1 bath e no máximo 4");
        }
        if (property.getBeds() == null || property.getBeds() > 5 || property.getBeds() < 1) {
            throw new PropertyException("Uma propriedade necessita de pelo ao menos 1 bath e no máximo 5");
        }
        if (property.getSquareMeters() == null || property.getSquareMeters() < 20 || property.getSquareMeters() > 240) {
            throw new PropertyException("Uma propriedade tem que ter pelo menos 20 e no máximo 240 metros quadrados");
        }

        // regras nao mapeadas
        if (property.getPrice() == null || property.getPrice() <= 0) {
            throw new PropertyException("Uma propriedade necessita de um preço válido");
        }
    }

    private synchronized Integer getNextId() {
        return dataSources.getPropertySession().size() + 1;
    }
}