package br.com.vivareal.desafio.spotippos.services;

import br.com.vivareal.desafio.spotippos.DataSources;
import br.com.vivareal.desafio.spotippos.Utils;
import br.com.vivareal.desafio.spotippos.models.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvinceService {

    @Autowired
    private DataSources dataSources;

    /**
     * Para recuperar a província por coordenadas. Considerando duas coordenadas cartesianas:
     * <pre>
     * y
     * ^    YT
     * |    * -----------|  -> Top Left
     * |    |            |
     * |    |            |
     * |    |            | YB
     * | XT |----------- *  -> Bottom Right
     * |                 XB
     * |_ _ _ _ _ _ _ _ _ _ _>  x
     * |
     * </pre>
     * <p>
     * Logo para uma propriedade seja considerada dentro de uma provincia ele deve obedecer as condicoes:
     * </p>
     * x | x > xt e x < xb e
     * y | y > yb e y < yt
     * <p>
     * Vou considerar aqui que as divisas nao sao lugares definidos.
     */
    public List<String> getProvincesByCoordinates(Integer x, Integer y) {
        List<String> provincias = new ArrayList<>();
        if (dataSources.getProvinceSession() != null) {
            for (Province province : dataSources.getProvinceSession()) {
                if (Utils.isInRange(x, y, province.getBoundary().getUpperLeftX(), province.getBoundary().getUpperLeftY(), province.getBoundary().getBottomRightX(), province.getBoundary().getBottomRightY())) {
                    provincias.add(province.getName());
                }
            }
        }
        return provincias;
    }
}