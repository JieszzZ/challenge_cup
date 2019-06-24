package com.zarry.competition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
public class CompetitionApplication extends WebMvcConfigurationSupport {

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//        /*
//        1.需要先定义一个convert转换消息的对象；
//        2.添加fastjson的配置信息，比如是否要格式化返回的json数据
//        3.在convert中添加配置信息
//        4.将convert添加到converters中
//         */
//        //1.定义一个convert转换消息对象
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        //2.添加fastjson的配置信息，比如：是否要格式化返回json数据
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.PrettyFormat
//        );
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        converters.add(fastConverter);
//    }

    public static void main(String[] args) {
        SpringApplication.run(CompetitionApplication.class, args);
    }
}
