//package com.stackroute.trackservice.configure;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//public class DBConfiguration {
//    private String driverClassName;
//    private String url;
//    private String userName;
//    private String password;
//    @ConfigurationProperties(prefix = "app")
//@Profile("dev")
//   @Bean
//    public String  devDbConfiguraton(){
//       System.out.println("DEV-DB-H2");
//       System.out.println(driverClassName);
//       System.out.println(url);
//       return "Data Base Connection for h2";
//
//   }
//    @Profile("test")
//    @Bean
//    public String  testDbConfiguraton(){
//        System.out.println("Test using DataBase H2");
//        System.out.println(driverClassName);
//        System.out.println(url);
//        return "Data Base Connection for h2";
//
//    }
//    @Profile("prod")
//    @Bean
//    public String  prodDbConfiguraton(){
//        System.out.println("For Production");
//        System.out.println(driverClassName);
//        System.out.println(url);
//        return "Data Base Connection for h2";
//
//    }
//
//}
