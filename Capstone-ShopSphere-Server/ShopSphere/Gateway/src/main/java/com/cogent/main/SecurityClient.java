package com.cogent.main;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "identity-service", url = "localhost:9898/api/v1/auth")
public interface SecurityClient
{
	@PostMapping("/validate")
	public String validate(@RequestParam("token") String jwtToken);
}
