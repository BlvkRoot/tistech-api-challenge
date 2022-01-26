package api.tistech.controllers;

import api.tistech.dto.ThirdIntGeneratorDTO;
import api.tistech.security.AccountCredentials;
import api.tistech.security.JWTLoginFilter;
import api.tistech.services.ThirdIntGeneratorService.IThirdIntGeneratorService;
import api.tistech.services.ThirdIntGeneratorService.ThirdIntGeneratorServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api
@RequestMapping("")
@Log4j2
public class ThirdIntGeneratorController {
	@Autowired
	IThirdIntGeneratorService thirdIntGeneratorService;

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna um terceiro inteiro C"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@RequestMapping(value = "/third-int-generator", method = RequestMethod.POST, params = {},  produces="application/json")
	public String handle(@RequestBody ThirdIntGeneratorDTO numbers) {

		try {
			Long thirdIntCResult = thirdIntGeneratorService.execute(numbers);

			log.info("Third Int Result " + thirdIntCResult);

			return "{\"Result\": \""+ thirdIntCResult + "\"}";
		} catch (Exception e) {

			log.info("Message: " + e.getMessage());

			return "{\"message\": \""+ e.getMessage() + "\"}";
		}
	}
}
