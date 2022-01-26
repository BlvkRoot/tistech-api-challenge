package api.tistech.services;

import org.springframework.stereotype.Service;
import api.tistech.dto.ThirdIntGeneratorDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@NoArgsConstructor
@Getter
@Setter
public class ThirdIntGeneratorServiceImpl implements IThirdIntGeneratorService {
    private String thirdIntegerC = "";

    private Long thirdIntConverted;

    public Long execute(ThirdIntGeneratorDTO numbers) {
        String numberAToString = String.valueOf(numbers.getNumberA()),
                numberBToString = String.valueOf(numbers.getNumberB());
        String[] numbersASplit = numberAToString.split(""),
                numbersBSplit = numberBToString.split("");
        int numbersALength = numbersASplit.length,
                numbersBLength = numbersBSplit.length;
        boolean isNumbersLengthEqual = numbersALength == numbersBLength;

        if (isNumbersLengthEqual) {
            for (int i = 0; i < numbersASplit.length; i++) {
                thirdIntegerC += numbersASplit[i];
                thirdIntegerC += numbersBSplit[i];
            }
        }

        if (!isNumbersLengthEqual) {
            boolean isNumberALengthGreater = numbersALength > numbersBLength ? true : false;

            if (isNumberALengthGreater) {
                for (int i = 0; i < numbersBLength; i++) {
                    thirdIntegerC += numbersASplit[i];
                    thirdIntegerC += numbersBSplit[i];
                }

                for (int j = numbersBLength; j < numbersALength; j++) {
                    thirdIntegerC += numbersASplit[j];
                }

            } else {
                for (int i = 0; i < numbersALength; i++) {
                    thirdIntegerC += numbersASplit[i];
                    thirdIntegerC += numbersBSplit[i];
                }

                for (int j = numbersALength; j < numbersBLength; j++) {
                    thirdIntegerC += numbersBSplit[j];
                }
            }
        }

        this.setThirdIntConverted(Long.parseLong(thirdIntegerC));

        if (thirdIntConverted > 1_000_000L)
            return -1L;

        return this.getThirdIntConverted();
    }
}
