package bao3;

public class Student {

    private int id;
    private String name;
    private School school;
    public Student(){}
    public Student(String name,int id,School school){
        System.out.println("有参构造器");
        this.name = name;
        this.id = id;
        this.school = school;
    }
    public void setId(int id) {
        System.out.println("调用了setId");
        this.id = id;
    }

    public void setName(String name) {
        System.out.println("调用了setname");
        this.name = name;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school=" + school +
                '}';
    }
}
