package sample;

public class list {
    private String name;
    private String type;
    private String membership_no;
    private String date;
    private String age;
    private String school;
    private String relative;

    public list(String name,String type,String membership_no,String date,String school,String age,String relative){
        this.name=name;
        this.date=date;
        this.membership_no=membership_no;
        this.type=type;
        this.school=school;
        this.age=age;
        this.relative=relative;


    }
    public String getName(){
        return name;
    }
    public void setName(){
        this.name=name;
    }
    public String getDate(){
        return date;
    }
    public void setDate(){
        this.date=date;
    }
    public String getMembership_no(){
        return membership_no;
    }
    public void setMembership_no(){
        this.membership_no=membership_no;
    }
    public String getType(){
        return type;
    }
    public void setType(){
        this.type=type;
    }
    public String getAge(){
        return age;
    }
    public void setAge(){
        this.age=age;
    }
    public String getSchool(){
        return school;
    }
    public void setSchool(){
        this.school=school;
    }
    public String getRelative(){
        return relative;
    }
    public void setRelative(){
        this.relative=relative;
    }
}
