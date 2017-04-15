package br.com.vivareal.desafio.spotippos.controllers;

import br.com.vivareal.desafio.spotippos.models.Property;
import br.com.vivareal.desafio.spotippos.models.vo.ResponseSearchVO;

import java.util.List;

public class BaseController {

    protected ResponseSearchVO adapt(List<Property> properties) {
        ResponseSearchVO responseSearchVO = new ResponseSearchVO();
        if (properties != null && properties.size() > 0) {
            for (Property property : properties) {
                responseSearchVO.addProperty(property);
            }
        }
        return responseSearchVO;
    }
}
