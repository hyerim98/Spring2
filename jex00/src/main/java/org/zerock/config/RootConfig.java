package org.zerock.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 	* web.xml을 대신하는 class
*/

@Configuration
// == root-context.xml의 <context:component-scan base-package="org.zerock.sample"/>와 같은 역할
@ComponentScan(basePackages = {"org.zerock.sample"})
public class RootConfig {

}
