package ir.maktabsharif127.jpa.service;

import ir.maktabsharif127.jpa.config.ApplicationContext;
import ir.maktabsharif127.jpa.domains.Province;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProvinceServiceImplTest {

    @Test
    void performIntegrationTestOnSave() {
        ApplicationContext instance = ApplicationContext.getInstance("test");

        ProvinceService provinceService = instance.getProvinceService();
        Assertions.assertEquals(0, provinceService.countAll());

        Province province = new Province();

        Assertions.assertThrows(
                RuntimeException.class, () -> provinceService.save(province)
        );

        province.setName("test");
        provinceService.save(province);
//        Assertions.assertNotNull(province);
        Assertions.assertNotNull(province.getLastUpdateDate());
        Assertions.assertNotNull(province.getId());
        Assertions.assertNotNull(province.getCreateDate());
        Assertions.assertEquals(1, provinceService.countAll());
        Assertions.assertTrue(provinceService.existsById(province.getId()));

    }
}