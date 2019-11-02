package cn.lhz.esc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    /**
     * @return 首页
     */
    @RequestMapping(value = "/")
    public String index(){
        return "starter";
    }
}
