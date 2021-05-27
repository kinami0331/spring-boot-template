package cc.kinami.template.controller;


import cc.kinami.template.model.dto.ResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "测试用接口")
@RestController
@AllArgsConstructor
@RequestMapping("/api/test")
public class TestController {

    @ApiOperation(value = "helloworld", notes = "this is an example")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseDTO<String> helloWorld(@RequestParam(required = false) String name) {
        if (name == null)
            return new ResponseDTO<>(200, "OK", "Hello, world!");
        else
            return new ResponseDTO<>(200, "OK", "Hello, " + name + "!");
    }

    @ApiOperation(value = "exception test", notes = "this is an example")
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ResponseDTO<Object> testError() {
        throw new RuntimeException("test");
    }


}
