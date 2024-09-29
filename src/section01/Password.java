package section01;

import java.util.Scanner;

/**
 * 암호
 *
 * 알파벳 대문자로 구성된 비밀편지
 * 알파벳 한 문자마다 # 또는 *이 7개로 구성
 * 1. “#*****#”를 일곱자리의 이진수로 바꿉니다. #은 이진수의 1로, *이진수의 0으로 변환합니다. 결과는 “1000001”로 변환됩니다.
 * 2. 바뀐 2진수를 10진수화 합니다. “1000001”을 10진수화 하면 65가 됩니다.
 * 3. 아스키 번호가 65문자로 변환합니다. 즉 아스크번호 65는 대문자 'A'입니다.
 * 암호 해석 프로그램 작성
 *
 * in : 4
 *      #****###**#####**#####**##**
 * out : COOL
 */
public class Password {

    public static final String BINARY_ONE_CHAR = "#";
    public static final String BINARY_ZERO_CHAR = "*";
    public static final int CHARACTER_BINARY_LENGTH = 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pwdLength = sc.nextInt();
        String pwdCodes = sc.next();

        String[] specialCodes = splitStringToPwdCodes(pwdLength, pwdCodes);
        convertSpecialCodesToBinaryString(specialCodes);
        int[] binaryArray = convertBinaryStringToDecimal(specialCodes);

        String result = convertDecimalToString(binaryArray);
        System.out.println(result);
        sc.close();
    }

    private static String convertDecimalToString(int[] binaryArray) {
        StringBuilder sb = new StringBuilder();
        for (int binary : binaryArray) {
            sb.append((char) binary);
        }
        return sb.toString();
    }

    private static int[] convertBinaryStringToDecimal(String[] specialCodes) {
        int[] binaryArray = new int[specialCodes.length];
        for (int i = 0; i < specialCodes.length; i++) {
            binaryArray[i] = Integer.parseInt(specialCodes[i], 2);
        }
        return binaryArray;
    }

    private static void convertSpecialCodesToBinaryString(String[] specialCodes) {
        for (int i = 0; i < specialCodes.length; i++) {
            String specialCode = specialCodes[i];

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < specialCode.length(); j++) {
                String code = String.valueOf(specialCode.charAt(j));

                if (BINARY_ONE_CHAR.equals(code)) {
                    sb.append("1");
                } else if (BINARY_ZERO_CHAR.equals(code)) {
                    sb.append("0");
                }
            }
            specialCodes[i] = sb.toString();
        }
    }

    private static String[] splitStringToPwdCodes(int pwdLength, String pwdCodes) {
        String[] specialCodes = new String[pwdLength];
        for (int i = 0; i < specialCodes.length; i++) {
            int startIndex = i * CHARACTER_BINARY_LENGTH;
            int endIndex = startIndex + CHARACTER_BINARY_LENGTH;
            specialCodes[i] = pwdCodes.substring(startIndex, endIndex);
        }
        return specialCodes;
    }
}
