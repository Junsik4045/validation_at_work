package hello.itemservice.web.validation;

import hello.itemservice.web.validation.form.ItemSaveForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/validation/api/items")
public class ValidationItemApiController {
        @PostMapping("/add")
        public Object addItem(@RequestBody @Validated ItemSaveForm form, BindingResult bindingResult){
            log.info("API controller calling");

            if (bindingResult.hasErrors()) {
                log.info("검증 오루 발생 errors=()" + bindingResult);
                return bindingResult.getAllErrors();
            }

            log.info("logic is success! ");
            return form;
        }


}
