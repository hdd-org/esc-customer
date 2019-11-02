package cn.lhz.esc.controller;

import cn.lhz.esc.entity.User;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public int addUser(@RequestBody User user){
        Integer result = restTemplate.postForObject("http://esc-provider/user",user,Integer.class);

        return result;
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public User login(User user, HttpServletRequest request){
        String result = restTemplate.postForObject("http://esc-provider/user/login",user,String.class);
        user = JSON.parseObject(result,User.class);
        request.getSession().setAttribute("user",user);
        System.out.println(result);
        return user;
    }


}
