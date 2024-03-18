package com.project.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test_bean {

    public static void main(String[] args) {
        // Spring ApplicationContext 초기화
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Bean_SpringSecurityTest 빈 가져오기
        Bean_SpringSecurityTest springSecurityTest = context.getBean(Bean_SpringSecurityTest.class);

        // 테스트 실행
        springSecurityTest.testSpringSecurity();
        springSecurityTest.testSpringJDBC();
    }
}
