package sample;

public class over_60_member extends default_member{
    private String age;
    private String relative_name;

    public over_60_member(String membership_no,String name,String dates,String age,String relative_name){
        super(membership_no, name, dates);
        setAge(age);
        setRelative_number(relative_name);

    }
    public void setAge(String age){
       int ages=Integer.parseInt(age);
        if (ages>=60){
            this.age=age;
        }else{
            throw new IllegalArgumentException("Invalid age for members abouve 60");
        }
    }
    public String getAge(){
        return age;
    }
    public String getRelative_name(){
        return relative_name;
    }
    public  void setRelative_number(String relative_name){
        this.relative_name=relative_name;
    }

}
