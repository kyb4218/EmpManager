public class Employee {
    protected String name;
    protected int id;
    protected int salary;

    public Employee(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void introduce(){
//        System.out.println("""
//                ID: %d,
//                Name: %s
//                급여: %d
//                """.formatted(id,name,salary));
//        System.out.println("========================================");
//        System.out.println(" ID         이름               급여  ");
//        System.out.println("========================================");
        System.out.printf("%-10d %-15s %-10d\n", id, name, salary);
        System.out.println("----------------------------------------");
    }

    public void increaseSalary(int amount) throws MyException{
        if(salary > 4000){
            throw new MyException("급여가 현재 " + salary +"인상불가");
        }else {
            salary += amount;
        }
    }

    public void increaseSalary(double percentage, boolean isPercentage){
        if(isPercentage){
            salary += (int) (salary * (percentage/100));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}
