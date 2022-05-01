package cool.cade.mall.product.exception;

import cool.cade.mall.common.exception.BizCodeEnum;
import cool.cade.mall.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 集中处理所有异常
 *
 * @author ander
 */
@Slf4j
//@ResponseBody
//@ControllerAdvice(basePackages = "cool.cade.mall.product.controller")
@RestControllerAdvice(basePackages = "cool.cade.mall.product.controller")
public class MallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {
        log.error("数据校验出现问题{}，异常类型：{}", e.getMessage(), e.getClass());
        BindingResult bindingResult = e.getBindingResult();

        Map<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError) -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(), BizCodeEnum.VALID_EXCEPTION.getMsg()).put("data", errorMap);
    }

    @ExceptionHandler(value = Throwable.class)
    public void handleException(Throwable throwable) throws Throwable {

        log.error("错误：", throwable);
        throwable.printStackTrace();
        throw throwable;
//        return R.error(BizCodeEnum.UNKNOWN_EXCEPTION);
    }
}
