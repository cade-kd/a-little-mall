package cool.cade.mall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cool.cade.mall.product.entity.BrandEntity;
import cool.cade.mall.product.service.BrandService;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

//@RefreshScope
@Component
@Data
class MyComponent{

    @Value("${spring.datasource.username}")
    private String username;

}
@SpringBootTest
@Component
@RefreshScope
class ProductApplicationTests {

    @Autowired
    ConfigurableApplicationContext context;
    @Autowired
    BrandService brandService;

    @Autowired
    MyComponent myComponent;

    @Value("${spring.datasource.username:default}")
    private String username;

    @Test
    void contextLoads() {
    }

    @Test
    void testNacosConfig() throws InterruptedException {
        while(true) {
            System.out.println("===========================================");
            System.out.println("usrname from @Value =" + username);
            System.out.println("username from context ="+context.getEnvironment().getProperty("spring.datasource.username"));
            System.out.println("username from @Value in other bean = " + myComponent.getUsername());
            System.out.println("-------------------------------------------");
            Thread.sleep(1000);
        }
    }

    @Test
    void testBrandCURD(){
        System.out.println("======testBrandCURD======");
        // 查询所有品牌
        System.out.println(brandService.list());
        System.out.println("=================");
        BrandEntity entity = new BrandEntity();
        System.out.println("当前品牌数目："+brandService.count());
        entity.setName("=======增加一个品牌==========");
        brandService.save(entity);
        System.out.println("新增后品牌数目："+brandService.count());
        BrandEntity entity2 = brandService.getOne(new QueryWrapper<>(entity));
        System.out.println("新增的品牌的id："+entity2.getBrandId());
        System.out.println("品牌描述为："+entity2.getDescript());
        System.out.println("==========修改描述=========");
        entity2.setDescript("--->华为是个鸟");
        brandService.updateById(entity2);
        entity2 = brandService.getOne(new QueryWrapper<>(entity2));
        System.out.println("新的品牌描述："+entity2.getDescript());
        System.out.println("========删除==========");
        brandService.removeById(entity2.getBrandId());
        System.out.println("删除后数据条目："+brandService.count());;

    }

}
