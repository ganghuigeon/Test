import java.util.Scanner;

public class java_banking_project {
    public static void main(String[] args) {
        boolean banking = true;
        String name = "";
        String birth = "";
        int account = 0; // 계좌번호 초기화
        int accountbalance = 0;
        Scanner scanner = new Scanner(System.in);



        while (banking) {
            System.out.println("===============================");
            System.out.println("1.계좌생성 | 2.입출금 및 잔고확인 | 3.계좌관리 | 4.종료");
            System.out.println("===============================");
            System.out.println("진행하실 은행업무를 선택해주세요: ");
            String strNum = scanner.nextLine();
            if (strNum.equals("1")) {
                //이름, 생년월일 입력
                System.out.println("성함을 입력해주세요");
                name = scanner.nextLine();
                boolean validInput = false;
                while (!validInput) {
                    System.out.println("생년월일을 6자리로 숫자로 입력해주세요");
                    try {
                        birth = scanner.nextLine();
                        // 입력이 숫자이며 6자리인지 확인
                        long longBirth = Long.parseLong(birth);
                        if (longBirth >= 100000 && longBirth <= 999999) {
                            validInput = true;
                        } else {
                            System.out.println("생년월일 6자리 입력해주세요.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("올바른 생년월일 입력이 아닌 거 같습니다. 다시 입력해주세요.");
                    }
                }
                account = (int) (Math.random() * 99999999) + 10000000;//10,000,000 ~ 99,999,999 까지의 숫자가 랜덤으로 지정되어 계좌로 지정


                System.out.println("입력된 성함: " + name);
                System.out.println("입력된 생년월일: " + birth);
                System.out.println("발급된 계좌번호: " + account);


            } else if (strNum.equals("2")) {
             while (banking) {
                 System.out.println("===============================");
                 System.out.println("1.입금 | 2.출금 | 3.잔고확인 | 4.종료");
                 System.out.println("===============================");
                 int depositwithdraw = Integer.parseInt(scanner.nextLine());
                 if (depositwithdraw == 1) {
                     System.out.println("입금할 금액을 입력해주세요: ");
                     accountbalance += Integer.parseInt(scanner.nextLine());
                     System.out.println("입금하셨습니다. 잔고: " + accountbalance + "원");
                 } else if (depositwithdraw == 2) {
                     System.out.println("출금할 금액을 입력해주세요: ");
                     accountbalance -= Integer.parseInt(scanner.nextLine());
                     System.out.println("출금하셨습니다. 잔고: " + accountbalance + "원");
                 } else if (depositwithdraw == 3) {
                     System.out.println("현재 잔고: " + accountbalance + "원");
                 } else if (depositwithdraw == 4) {
                     banking = false;
                     System.out.println("프로그램 종료");
                 } else {
                     System.out.println("잘못 선택하셨습니다.");
                 }
             }
            } else {
                System.out.println("잘못 선택하셨습니다.");
            }
        }
        scanner.close();
    }
}
