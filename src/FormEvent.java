import java.util.EventObject;

public class FormEvent extends EventObject {

    private String name;
    private String job;
    private Agecategory age;

    public FormEvent(Object source, String name, String job,Agecategory age)
    {
        super(source);
        this.name=name;
        this.job=job;
        this.age=age;
    }

    public FormEvent(Object source) {
        super(source);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Agecategory getAge() {
        return age;
    }

//    public Agecategory setAge(Agecategory age) {
//        this.age = age;
//    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }


}
