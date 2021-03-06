package cn.zsk.ribbon9001.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author:zsk
 * @CreateTime:2019-06-03 11:20
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /*
     * 如果不定义这个myRule（）方法，默认使用轮询算法。
     * 现在使用重新选择的随机算法代替原来的轮询算法
     * */
    @Bean
    public IRule myRule(){
        //轮询
//        return new RoundRobinRule();
        //随机
//        return new RandomRule();

        return new RetryRule();
    }
}
