package br.com.vivareal.desafio.spotippos.tests.services;

import br.com.vivareal.desafio.spotippos.DataSources;
import br.com.vivareal.desafio.spotippos.Utils;
import br.com.vivareal.desafio.spotippos.models.Property;
import br.com.vivareal.desafio.spotippos.services.PropertyService;
import br.com.vivareal.desafio.spotippos.services.ProvinceService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test.xml")
public class PropertyServiceTest {
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private ProvinceService provinceService;

    /**
     * Para recuperar a propriedade pelo ID
     */
    @Test
    public void testGetOneExistingProperty() {
        Property property = propertyService.get(10);
        Assert.assertNotNull(property);
        Assert.assertTrue(property.getId() == 10);
        Assert.assertEquals("Titulo precisa ser igual a 'Imóvel código 10, com 3 quartos e 2 banheiros.'", "Imóvel código 10, com 3 quartos e 2 banheiros.", property.getTitle());
        Assert.assertEquals("Descricao precisa ser igual a 'In reprehenderit sit dolor nostrud enim nisi proident non deserunt incididunt pariatur sunt. Adipisicing nisi fugiat commodo cillum ea aute anim magna eu magna duis officia.'", "In reprehenderit sit dolor nostrud enim nisi proident non deserunt incididunt pariatur sunt. Adipisicing nisi fugiat commodo cillum ea aute anim magna eu magna duis officia.", property.getDescription());
        Assert.assertNotNull(property.getBaths() == 2);
        Assert.assertNotNull(property.getBeds() == 3);
        Assert.assertNotNull(property.getPrice() == 661000);
        Assert.assertTrue(property.getX() == 304);
        Assert.assertTrue(property.getY() == 225);
        Assert.assertTrue(property.getSquareMeters() == 64);
    }

    @Test
    public void testGetProvincesByCoordinates() {
        List<String> provinceNames = provinceService.getProvincesByCoordinates(870, 867);
        Assert.assertTrue(provinceNames != null);
        Assert.assertTrue(provinceNames.size() == 1);
        Assert.assertTrue(provinceNames.get(0).equals("Ruja"));

        provinceNames = provinceService.getProvincesByCoordinates(1300, 600);
        Assert.assertTrue(provinceNames != null);
        Assert.assertTrue(provinceNames.size() == 1);
        Assert.assertTrue(provinceNames.get(0).equals("Jaby"));

        provinceNames = provinceService.getProvincesByCoordinates(400, 400);
        Assert.assertTrue(provinceNames != null);
        Assert.assertTrue(provinceNames.size() == 1);
        Assert.assertTrue(provinceNames.get(0).equals("Scavy"));

        provinceNames = provinceService.getProvincesByCoordinates(300, 800);
        Assert.assertTrue(provinceNames != null);
        Assert.assertTrue(provinceNames.size() == 1);
        Assert.assertTrue(provinceNames.get(0).equals("Gode"));

        provinceNames = provinceService.getProvincesByCoordinates(1100, 300);
        Assert.assertTrue(provinceNames != null);
        Assert.assertTrue(provinceNames.size() == 1);
        Assert.assertTrue(provinceNames.get(0).equals("Nova"));

        provinceNames = provinceService.getProvincesByCoordinates(650, 480);
        Assert.assertTrue(provinceNames != null);
        Assert.assertTrue(provinceNames.size() == 1);
        Assert.assertTrue(provinceNames.get(0).equals("Groola"));

        // agora vamos testar os dominios onde existe incerteza sobre o nome da provincia
        provinceNames = provinceService.getProvincesByCoordinates(450, 620);
        Assert.assertTrue(provinceNames != null);
        Assert.assertTrue(provinceNames.size() == 2);
        checkForTwoProvinces(provinceNames);

        provinceNames = provinceService.getProvincesByCoordinates(580, 999);
        Assert.assertTrue(provinceNames != null);
        Assert.assertTrue(provinceNames.size() == 2);
        checkForTwoProvinces(provinceNames);
    }

    private void checkForTwoProvinces(List<String> provinceNames) {
        for (String province : provinceNames) {
            if (!province.equals("Gode") && !province.equals("Ruja")) {
                Assert.fail("A provincia precisa estar sempre em Gode e em Ruja");
            }
        }
    }

    @Test
    public void testProvinceDivision() {
        List<String> provinceNames = provinceService.getProvincesByCoordinates(600, 500);
        Assert.assertTrue(provinceNames != null);
        Assert.assertTrue(provinceNames.size() == 0);
    }

    @Test
    public void testSaveProvince() {
        try {
            Property property = propertyService.save(new Property(400, 400, "Titulo de nova propriedade", 1502, "Descricao do imovel", 2, 2, 50));
            Assert.assertNotNull(property);
            Assert.assertNotNull(property.getId());
            Assert.assertTrue(String.format("Nesse caso o ultimo id precisa ser 8001. Recebi ao inves: %s", property.getId()), property.getId() == 8001);
        } catch (Exception e) {
            Assert.fail("Tem que ser possível salvar um imóvel nessas condicoes");
        }
    }

    @Test
    public void testIsInRange() {
        Assert.assertTrue(Utils.isInRange(200, 800,0,1000, 600, 500));
        Assert.assertFalse(Utils.isInRange(1100, 800,0,1000, 600, 500));
    }
}