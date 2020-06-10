package scgoom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("httpd", r -> r.path("/**")
                .filters(f -> f.modifyResponseBody(String.class, String.class, (exchange, s) -> Mono.just(s.toUpperCase())))
                .uri("http://scg-oom-httpd:80"))
            .build();
    }
}
