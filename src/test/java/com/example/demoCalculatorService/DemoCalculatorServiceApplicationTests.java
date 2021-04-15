package com.example.demoCalculatorService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoCalculatorServiceApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void factorialTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:8080/factorial?number=10",
				String.class)).contains("3628800");
	}

	@Test
	public void fibonacciTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:8080/fibonacci?number=100",
				String.class)).contains("573147844013817084101");
	}

	@Test
	void contextLoads() {
	}



}
