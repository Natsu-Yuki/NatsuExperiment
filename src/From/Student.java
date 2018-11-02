package From;

public class Student implements Comparable<Student> {
    private String sno;
    private String name;
    private int age;
    private String pro;
    private String hobby;
    private float credits;

    public Student() {
    }

    public Student(String sno, String name, int age, String pro, String hobby, float credits) {
        this.sno = sno;
        this.name = name;
        this.age = age;
        this.pro = pro;
        this.hobby = hobby;
        this.credits = credits;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public float getCredits() {
        return credits;
    }

    public void setCredits(float credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Stundent{" +
                "sno='" + sno + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", pro='" + pro + '\'' +
                ", hobby='" + hobby + '\'' +
                ", credits=" + credits +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if(credits<o.credits)
            return -1;
        else return 0;
    }
}
