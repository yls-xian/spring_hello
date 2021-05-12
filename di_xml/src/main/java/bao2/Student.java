package bao2;

public class Student {

    private int id;
    private String name;
    private School school;

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
