package cn.lhz.esc;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableDiscoveryClient
@SpringBootApplication
public class EscApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(EscApplication.class, args);
    }

    // 启用负载均衡，默认算法是轮询
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }


    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
           FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
           FastJsonConfig config = new FastJsonConfig();
           config.setDateFormat("yyyy-MM-dd HH:mm:ss");
          converter.setFastJsonConfig(config);
           return converter;
       }
}
