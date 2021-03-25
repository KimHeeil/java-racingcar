package step3;

import java.util.Scanner;

public class RacingMain {
    public static String SYSTEM_MESSAGE_ASK_CAR_COUNT = "> 자동차 대수는 몇 대 인가요?";
    public static String SYSTEM_MESSAGE_ASK_LAP_COUNT = "> 시도할 횟수는 몇 회 인가요?";
    public static String SYSTEM_MESSAGE_CAR_RETRY = "자동차는 최소 1대 이상이여야 합니다. 다시 입력해주세요.";
    public static String SYSTEM_MESSAGE_LAP_RETRY = "횟수는 최소 1회 이상이여야 합니다. 다시 입력해주세요.";

    private static Scanner scanner = new Scanner(System.in);

    public static int getCarCount() {
        return getCount(SYSTEM_MESSAGE_ASK_CAR_COUNT, SYSTEM_MESSAGE_CAR_RETRY);
    }

    public static int getLapCount() {
        return getCount(SYSTEM_MESSAGE_ASK_LAP_COUNT, SYSTEM_MESSAGE_LAP_RETRY);
    }

    public static int getCount(String askMessage, String retryMessage){
        int count;
        do {
            System.out.println(askMessage);
            count = scanner.nextInt();
            if (count < 1) {
                System.out.println(retryMessage);
            }
        } while (count < 1);
        return count;
    }

    public static void main(String[] args) {
        try {
            int carCount = getCarCount();
            int lapCount = getLapCount();
            System.out.println("Car Racing start... Car Count : " + carCount + "  Lap Count : " + lapCount);
            new Racing(carCount, lapCount);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
