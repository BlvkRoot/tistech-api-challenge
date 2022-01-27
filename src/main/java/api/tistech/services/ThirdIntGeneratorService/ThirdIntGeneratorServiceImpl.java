package api.tistech.services.ThirdIntGeneratorService;

import org.springframework.stereotype.Service;
import api.tistech.dto.ThirdIntGeneratorDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Service
@NoArgsConstructor
@Getter
@Setter
@Log4j2
public class ThirdIntGeneratorServiceImpl implements IThirdIntGeneratorService {

    private String thirdIntegerC = "";
    private Long thirdIntConverted;

    @Override
    public Long execute(ThirdIntGeneratorDTO numbers) {
        String numberAToString = String.valueOf(numbers.getNumberA()),
                numberBToString = String.valueOf(numbers.getNumberB());
        String[] numbersASplit = numberAToString.split(""),
                numbersBSplit = numberBToString.split("");
        int numbersALength = numbersASplit.length,
                numbersBLength = numbersBSplit.length;
        boolean isNumbersLengthEqual = numbersALength == numbersBLength;

        if (isNumbersLengthEqual) {
            this.setThirdIntConverted(this.generateIntWhenEqualLength(thirdIntegerC, numbersASplit, numbersBSplit));
        }

        if (!isNumbersLengthEqual) {
            boolean isNumberALengthGreater = numbersALength > numbersBLength ? true : false;
            
            if (isNumberALengthGreater) {
                this.setThirdIntConverted(this.generateIntWhenLengthIsGreater(thirdIntegerC, numbersASplit, numbersBSplit));
            } else {
                this.setThirdIntConverted(this.generateIntWhenLengthIsGreater(thirdIntegerC, numbersBSplit, numbersASplit));
            }
            log.info("Number A length is different from Number B length \n" +
                    "Result: " + this.thirdIntegerC);
        }

        if (thirdIntConverted > 1_000_000L)
            return -1L;

        return this.getThirdIntConverted();
    }

    private Long generateIntWhenEqualLength(String thirdIntegerC, String[] numbersA, String[] numbersB) {
        for (int i = 0; i < numbersA.length; i++) {
            thirdIntegerC += numbersA[i];
            thirdIntegerC += numbersB[i];
        }
        log.info("Number A length is equal to Number B length \n" +
                "Result: " + this.thirdIntegerC);
        return Long.parseLong(thirdIntegerC);
    }

    private Long generateIntWhenLengthIsGreater(String thirdIntegerC, String[] numbersLengthGreater, String[] numbersLengthLess) {
        for (int i = 0; i < numbersLengthGreater.length; i++) {
            if(numbersLengthGreater.length > i) thirdIntegerC += numbersLengthGreater[i];
            if(numbersLengthLess.length > i) thirdIntegerC += numbersLengthLess[i];
        }
        return Long.parseLong(thirdIntegerC);
    }

}
