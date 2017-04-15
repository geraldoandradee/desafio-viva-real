package br.com.vivareal.desafio.spotippos.controllers;

import br.com.vivareal.desafio.spotippos.models.Property;
import br.com.vivareal.desafio.spotippos.models.vo.ResponseErrorVO;
import br.com.vivareal.desafio.spotippos.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class PropertyController extends BaseController {

    @Autowired
    PropertyService propertyService;

    @RequestMapping(value = "/", method = GET)
    public String getProperties() {
        return "########################## Seja bem vindo ao resultado do teste do desafio VivaReal ##########################";
    }

    @RequestMapping(value = "/properties/{id}", method = GET)
    public ResponseEntity getProperty(@PathVariable(value = "id") Integer id) {
        Property property = propertyService.get(id);
        if (property == null) {
            return new ResponseEntity<>(new ResponseErrorVO(404, "Propriedade não encontrada"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(property, HttpStatus.OK);
    }

    @RequestMapping(value = "/properties", method = POST)
    public ResponseEntity postProperty(@RequestBody final Property property) {
        try {
            return new ResponseEntity<>(propertyService.save(property), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseErrorVO(400, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/properties", method = GET)
    public ResponseEntity searchProperty(@RequestParam(value = "ax") Integer upperLeftX, @RequestParam(value = "ay") Integer upperLeftY,
                                         @RequestParam(value = "bx") Integer bottomRightX, @RequestParam(value = "by") Integer bottomRightY) {
        List<Property> properties = propertyService.search(upperLeftX, upperLeftY, bottomRightX, bottomRightY);
        return new ResponseEntity<>(adapt(properties), HttpStatus.OK);
    }
}
