package com.cogent.main;

import java.util.List;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import com.google.common.base.Predicate;

@Component
public class RouteValidator
{
	List<String> openApiEndPoints = List.of("api/v1/auth/register", "api/v1/auth/login", "api/v1/auth/validate", "api/v1/product/products/**","/api/v1/product/products");

	List<String> adminEndPoints = List.of("/admin/");

	public Predicate<ServerHttpRequest> isSecured = request -> openApiEndPoints.stream()
			.noneMatch(uri -> request.getURI()
					.getPath()
					.contains(uri));

	public Predicate<ServerHttpRequest> isAdmin = request -> adminEndPoints.stream()
			.anyMatch(uri -> request.getURI()
					.getPath()
					.contains(uri));
}
