package calculator.service;

public class CalculatorService {
    private static String customDelimiter;
    private static String pureExpression;
    private static int sum;

    public boolean hasCustomDelimiter(String userInput) {
        return userInput.startsWith("//");
    }

    public void handleCustomDelimiter(String userInput) {
        String[] userInputs = userInput.split("\\\\n");
        if (userInputs.length != 2) {
            throw new IllegalArgumentException("커스텀 구분자는 한 개만 입력해 주세요.");
        }
        setCustomDelimiter(userInputs);
        setPureExpression(userInputs);
    }

    public void setCustomDelimiter(String[] userInputs) {
        String delimiter = userInputs[0].substring(2);
        if (delimiter.matches("[0-9]")) {
            throw new IllegalArgumentException("커스텀 구분자가 숫자입니다.");
        }
        customDelimiter = delimiter;
    }

    public String getCustomDelimiter() {
        return customDelimiter;
    }

    public String getPureExpression() {
        return pureExpression;
    }

    public void setPureExpression(String[] userInput) {
        pureExpression = userInput[1];
    }

    public void calculateSum(String userInput, String delimiter) {
        calculateNumbers(userInput.split(delimiter));
    }

    public void calculateNumbers(String[] numbers) {
        for (String number : numbers) {
            int numberInt = Integer.parseInt(number);
            if (numberInt < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            sum += numberInt;
        }
    }

    public int getSum() {
        return sum;
    }
}
