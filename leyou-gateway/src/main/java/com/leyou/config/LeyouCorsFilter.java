package com.leyou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class LeyouCorsFilter {
    /**
     * Access-Control-Allow-Origin: http://manage.leyou.com
     * Access-Control-Allow-Credentials: true
     * Access-Control-Allow-Methods: GET, POST, PUT
     * Access-Control-Allow-Headers: X-Custom-Header
     */
    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration configuration = new CorsConfiguration();
        /* 允许跨域的域名 */
        configuration.addAllowedOrigin("http://manage.leyou.com");
        /* 允许携带kooie */
        configuration.setAllowCredentials(true);

//        configuration.addAllowedHeader("X-Custom-Header");
        /* 代表允许任何请求头 */
        configuration.addAllowedHeader("*");

        /* 代表允许任何方法请求方法 */
        configuration.addAllowedMethod("*");
//        configuration.addAllowedMethod("POST");
//        configuration.addAllowedMethod("PUT");
//        configuration.addAllowedMethod("GET");
//        configuration.addAllowedMethod("DELETE");
//        configuration.addAllowedMethod("OPTIONS");
//        configuration.addAllowedMethod("HEAD");
//        configuration.addAllowedMethod("PATCH");

        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**",configuration);
        return new CorsFilter(configurationSource);
    }
}
