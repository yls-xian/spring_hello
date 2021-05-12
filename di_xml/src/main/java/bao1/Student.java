package bao1;

public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(int id) {
        System.out.println("调用了setId");
        this.id = id;
    }

    public void setName(String name) {
        System.out.println("调用了setname");
        this.name = name;
    }

    private int id;
    private String name;

}
