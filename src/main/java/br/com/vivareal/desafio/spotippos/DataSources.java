package br.com.vivareal.desafio.spotippos;

import br.com.vivareal.desafio.spotippos.models.Boundary;
import br.com.vivareal.desafio.spotippos.models.vo.PropertiesVO;
import br.com.vivareal.desafio.spotippos.models.Property;
import br.com.vivareal.desafio.spotippos.models.Province;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstracao de acesso aos dados. No futuro pode ser substituido por um banco de dados de verdade.
 */
@Component
public class DataSources {
    private static final Gson GSON = new GsonBuilder().create();
    private PropertiesVO properties;
    private List<Province> provinces;

    @PostConstruct
    public void setup() throws IOException, NullPointerException {
        ClassLoader classLoader = getClass().getClassLoader();
        FileReader jsonFile = new FileReader(classLoader.getResource(Constants.databaseFile).getPath());
        properties = GSON.fromJson(jsonFile, PropertiesVO.class);

        // nao vou ler do json devido a quantidade
        provinces = new ArrayList<>();
        provinces.add(new Province("Gode", new Boundary(0, 1000, 600, 500)));
        provinces.add(new Province("Ruja", new Boundary(400, 1000, 1100, 500)));
        provinces.add(new Province("Jaby", new Boundary(1100, 1000, 1400, 500)));
        provinces.add(new Province("Scavy", new Boundary(0, 500, 600, 0)));
        provinces.add(new Province("Groola", new Boundary(600, 500, 800, 0)));
        provinces.add(new Province("Nova", new Boundary(800, 500, 1400, 0)));
    }

    public DataSources() {
    }

    public List<Property> getPropertySession() {
        if (properties != null && properties.getProperties() != null && properties.getProperties().size() > 0) {
            return properties.getProperties();
        }
        return null;
    }

    public List<Province> getProvinceSession() {
        if (provinces != null && properties.getProperties().size() > 0) {
            return provinces;
        }
        return null;
    }
}