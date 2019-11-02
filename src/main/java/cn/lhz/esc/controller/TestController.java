package cn.lhz.esc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Neo
 * @date 2019/10/22 23:37
 */
@RestController
public class TestController
{
    @Autowired
    private RestTemplate restTemplate;
    public TestController()
    {
    }

    @RequestMapping("/testIndex")
        public String index(){
            String result = restTemplate.getForObject("http://esc-provider/", String.class);

            return result;
        }

}
