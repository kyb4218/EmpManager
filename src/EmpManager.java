import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpManager {

    private List<Employee> employees = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);


    public void start() {
        System.out.println("직원 관리 프로그램 시작");

        while (true) {
            showMenu();
            String input = scanner.nextLine();
            scanner.nextLine();
            switch (input) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    listEmployee();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    increaseSalary();
                    break;
                case 6:
                    System.out.println("시스템을 종료합니다");
                    return;

                default:
                    System.out.println("다시 입력하시오");
            }
        }
    }

    public void showMenu() {
        // 15버전 이상 방식
        System.out.println("""
                \n Menu :
                1. 직원 등록
                2. 직원 목록
                3. 직원 검색
                4. 직원 삭제
                5. 실적 등록
                6. 종료
                메뉴를 선택 하시오:
                """);

    }

    //    1. 직원 등록
    public void addEmployee() {
        System.out.println("직원 등록");
        System.out.println("""
                등록직원 종류선택 :
                1. 관리자
                2. 개발자
                """);
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.println("이름 :");
        String name = scanner.nextLine();
        System.out.println("ID :");
        int id = scanner.nextInt();
        System.out.println("급여 :");
        int salary = scanner.nextInt();
        if (type == 1) {
            System.out.print("팀 규모?");
            int teamSize = scanner.nextInt();
            employees.add(new Manager(name, id, salary, teamSize));
        } else if (type == 2) {
            System.out.print("주 사용 언어?");
            scanner.nextLine(); // 기존입력한값 쓰레기값 비우기
            String language = scanner.nextLine();
            employees.add(new Developer(name, id, salary, language));
        } else {
            System.out.println("잘못된 선택입니다");
        }
    }

    //    2. 직원 목록
    public void listEmployee() {
        System.out.println("직원 목록");
        System.out.println("========================================");
        System.out.println(" ID         이름               급여  ");
        System.out.println("========================================");
        if (employees.isEmpty()) {
            System.out.println("등록된 직원이 없습니다");
        } else {
            for (Employee emp : employees) {
                emp.introduce();
                System.out.println();
            }
        }
    }

    //    3. 직원 검색
    public void searchEmployee() {

    }


    //    4. 직원 삭제
    public void deleteEmployee() {
        System.out.println("****** 연락처삭제 ******");
        System.out.println("삭제한 직원의 ID :");
        int searchId = scanner.nextInt();
        boolean find = false;
        Employee targetEmployee = null;

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == searchId) {
                System.out.println(employees.get(i).getName() + "(" + employees.get(i).getId() + ")" + "직원을 삭제합니다.");
                employees.remove(i);
                find = true;
                break;
            }
        }
        if (!find) {
            System.out.println(targetEmployee.getName() + " (" + targetEmployee.getId() + ")" + " 직원이 삭제되었습니다.");
        } else {
            System.out.println("해당 ID의 직원이 없습니다.");
        }
    }

    //    5. 실적 등록
    public void increaseSalary() {
        System.out.println("급여 인상 등록");
        System.out.print("직원 ID:");
        int id = scanner.nextInt();
        Employee target = null;
        for (Employee emp : employees) {
            if (emp.id == id) {
                target = emp;
                break;
            }
        }
        if (target != null) {
            System.out.println("""
                    1. 고정값으로 증가
                    2. 퍼센트로 증가
                    방식을 선택 :
                    """);
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("증가 급여 입력");
                int amount = scanner.nextInt();
                target.increaseSalary(amount);
                System.out.println("급여 증가 성공");
            } else if (choice == 2) {
                System.out.println("증가 급여 퍼센트 입력:");
                double percentage = scanner.nextDouble();
                target.increaseSalary(percentage, true);
                System.out.println("급여 증가 퍼센트 적용");
            } else {
                System.out.println("다시 입력하시오");
            }
        } else {
            System.out.println("해당 직원이 없습니다");
        }
    }
}
