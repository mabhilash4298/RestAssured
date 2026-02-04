package steps;

import java.io.Serializable;

public class JavaClassTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private  int id=1;
    private String name;
    private  int age;

    @Override
    public String toString() {
        return "JavaClassTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public JavaClassTest(int id, String name, int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
