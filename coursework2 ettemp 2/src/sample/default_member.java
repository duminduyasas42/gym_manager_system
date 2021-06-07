package sample;

public class default_member  implements Comparable<default_member> {
    private String membership_no;
    private String name;
    private String dates;

    public default_member(String membership_no,String name,String dates){
        super();
        this.membership_no=membership_no;
        this.name=name;
        this.dates=dates;
    }
    public String getMembership_no(){
        return membership_no;
    }
    public void setMembership_no(String membership_no){
        this.membership_no=membership_no;
    }
    public String getName(){
        return name;

    }
    public void setName(String name) {
        this.name=name;

    }
    public String getDates(){
        return dates;
    }
    public void setDates(String dates){
        this.dates=dates;
    }

    @Override
    public int compareTo(default_member other) {
        int compareInt=this.name.compareTo(other.name);
        if(compareInt<0){
            return -1;
        }
        if (compareInt>0){
            return 1;
        }
        return 0;
    }
}
