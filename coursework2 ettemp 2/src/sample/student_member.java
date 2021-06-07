package sample;

public class student_member extends default_member {

    private String school_name;
    private String relatives_name;

    public student_member(String membership_no,String name,String dates,String school_name,String relatives_name){
        super(membership_no,name,dates);
        this.school_name=school_name;
        this.relatives_name=relatives_name;

    }
    public String getSchool_name(){
        return school_name;
    }
    public void setSchool_name(String school_name){
        this.school_name=school_name;

    }
    public String getRelatives_name(){
        return relatives_name;
    }
    public void setRelatives_name(String relatives_name){
        this.relatives_name=relatives_name;
    }

}
