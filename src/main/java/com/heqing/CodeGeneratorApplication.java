package com.heqing;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * spring boot 启动类
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/01/02
 */
@SpringBootApplication
public class CodeGeneratorApplication {

	//使用@Bean注入fastJsonHttpMessageConvert
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters(){
		//1.需要定义一个Convert转换消息的对象
		FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
		//2.添加fastjson的配置信息，比如是否要格式化返回的json数据
//
		FastJsonConfig fastJsonConfig=new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		//3.在convert中添加配置信息
		fastConverter.setFastJsonConfig(fastJsonConfig);

		HttpMessageConverter<?> converter=fastConverter;
		return new HttpMessageConverters(converter);
	}

	public static void main(String[] args) {
		SpringApplication.run(CodeGeneratorApplication.class, args);
	}

}
