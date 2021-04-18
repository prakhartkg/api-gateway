package com.pinecone.api.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	@GetMapping("/user-fallback")
	public String getUserFallBack() {
		return "user service down";
	}

	@PostMapping("/user-fallback")
	public String postUserFallBack() {
		return "user service down";
	}

	@PostMapping("/department-fallback")
	public String postDepartmentFallBack() {
		return "department service down";
	}

	@GetMapping("/department-fallback")
	public String departmentFallBack() {
		return "department service down";
	}
}
