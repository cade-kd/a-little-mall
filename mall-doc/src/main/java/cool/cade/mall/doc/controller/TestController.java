package cool.cade.mall.doc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Tag(name="test", description = "Test")
@RestController
@RequestMapping("docs/test")
public class TestController {
    @Operation(summary = "test-test", description = "springdoc测试")
    @GetMapping("/test-test")
    //@RequiresPermissions("product:brand:list")
    public String list(@RequestParam Map<String, Object> params) {
        return "success";
    }
}
