package cr.ac.backend.apigateway.config;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class RouterValidator {

    public static final List<String> publicRoutes = List.of(
            "/Login",
            "/user/all"
    );

    public Predicate<ServerHttpRequest> isSecured = request -> publicRoutes
            .stream()
            .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
