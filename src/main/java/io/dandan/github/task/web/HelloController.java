package io.dandan.github.task.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/test")
	public @ResponseBody String sayHello(){
		return "Hello Web1 ";
	}
}
