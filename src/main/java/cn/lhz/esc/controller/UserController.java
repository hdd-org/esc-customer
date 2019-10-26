package cn.lhz.esc.controller;

import cn.lhz.esc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Neo
 * @date 2019/10/24 0:24
 */
@RequestMapping("/user")
@RestController
public class UserController
{
    @Autowired
    private RestTemplate restTemplate;
    public UserController()
    {
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public int addUser(@RequestBody User user){
        Integer result = restTemplate.postForObject("http://esc-provider/user",user,Integer.class);

        return result;
    }
}
