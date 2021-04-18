package com.pinecone.api.gateway.config;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@RestController
public class SwaggerConfig {

	@Autowired
	private EurekaClient discoveryClient;
	

	@GetMapping("/swagger-config.json")
	public Map<String, Object> swaggerConfig() {
		 
		Map<String, Object> rtn = new LinkedHashMap<>();
		 List<Map<String,String>> urls = new LinkedList<>();

		discoveryClient
		.getApplications()
		.getRegisteredApplications()
		.forEach(application->{
			if(application.getName().matches(".*-SERVICE")) {
				String serviceName = application.getName();
				String path = serviceName.toLowerCase().replace("-service", "").concat("s");
				 Map<String, String> url = new LinkedHashMap<>();
		          url.put("url", "/" + path + "/api-docs");
		          url.put("name", serviceName);
		          urls.add(url);
			}
		});
		rtn.put("urls", urls);
	    return rtn;
	}

}