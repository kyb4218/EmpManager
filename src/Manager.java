public class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int id, int salary, int teamSize){
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void introduce(){
        super.introduce();
        System.out.println("관리 팀규모 : " + teamSize);
    }
}
