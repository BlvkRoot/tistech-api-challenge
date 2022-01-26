package api.tistech.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import api.tistech.dto.ThirdIntGeneratorDTO;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ThirdIntGeneratorServiceImpl implements IThirdIntGeneratorService {
    private String thirdIntegerC = "";

    public Long execute(ThirdIntGeneratorDTO numbers) {
        String numberAToString = String.valueOf(numbers.getNumberA()),
               numberBToString = String.valueOf(numbers.getNumberB());
        String[] numbersASplit = numberAToString.split(""),
                 numbersBSplit = numberBToString.split("");
        boolean isNumbersLengthEqual = numberAToString.length() == numberBToString.length();

        if (isNumbersLengthEqual) {
            System.out.println("isNumbersLengthEqual === true");
            for (int i = 0; i < numbersASplit.length; i++) {
                System.out.println("Numbers splitted:::::: " + numbersASplit[i]);
                thirdIntegerC += numbersASplit[i];
                thirdIntegerC += numbersBSplit[i];
            }

            System.out.println("thirdNumberGenerated::: " + thirdIntegerC);
        }

        if (!isNumbersLengthEqual) {
            System.out.println("isNumbersLengthEqual === false");
        }

        Long thirdIntConverted = Long.parseLong(thirdIntegerC);

        if (thirdIntConverted > 1_000_000L)
            System.out.println("C greater than 1M");

        System.out.println("Called Numbers: " + numbers.getNumberA() + " " + numbers.getNumberB());

        return thirdIntConverted;
    }
}
