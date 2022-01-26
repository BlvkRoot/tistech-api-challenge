package api.tistech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import api.tistech.dto.ThirdIntGeneratorDTO;
import api.tistech.services.ThirdIntGeneratorService.IThirdIntGeneratorService;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ThirdIntGeneratorTests {

    @Autowired
    IThirdIntGeneratorService thirdIntGeneratorService;

    @Autowired
    ThirdIntGeneratorDTO thirdIntGeneratorDTO;

    @Test
	void thirdIntegerC() throws Exception {
		

		thirdIntGeneratorDTO.setNumberA(129);
		thirdIntGeneratorDTO.setNumberA(387);
		
		Long result = thirdIntGeneratorService.execute(thirdIntGeneratorDTO);

		Assertions.assertEquals(150122L, result);
	}
}
