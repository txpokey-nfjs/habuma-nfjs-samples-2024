package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlakyController {

	@GetMapping("/flaky")
	public String flaky() {
		double random = Math.random();
		if (random < 0.5) {
			throw new FlakyException("The value was too low: " + random);
		}
		
		return "It worked!";
	}
}
