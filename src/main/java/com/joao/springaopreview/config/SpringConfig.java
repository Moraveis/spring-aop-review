package com.joao.springaopreview.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.joao.springaopreview")
@EnableAspectJAutoProxy
public class SpringConfig {
}
