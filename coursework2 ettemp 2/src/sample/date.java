package sample;

public class date {
    private String date;


    public date(){

        this.date= date;

    }
    public static boolean vale_date(String date) {
        int pos1 = date.indexOf("|");

        int pos2 = date.indexOf("|", pos1 + 1);

        int si = date.length();

        if (pos1 != -1 || pos2 != -1){

            String d = date.substring(0, pos1);
            String m = date.substring(pos1 + 1, pos2);
            String y = date.substring(pos2 + 1);




            boolean  da=is_date(d,"day");
            boolean mo=is_date(m,"month");
            boolean ye=is_date(y,"year");




            if(pos1==2 && pos2==5 && si==10 && mo==true && da==true && ye==true){

                int day = Integer.parseInt(d);
                int month = Integer.parseInt(m);
                int year = Integer.parseInt(y);
                boolean check=validation(day,month,year);
                if(check==true){
                    return true;
                }
                else{
                    System.out.println("not a real date");
                    return false;
                }







            }
            else {
                System.out.println("error reenter date");
                return false;
            }







        }
        else {System.out.println("enter date correctly");
            return false;
        }











    }
    public static boolean validation(int day,int month,int year){
        int x=year%400;
        if(x==0 && month==02 && day<30){
            return true;

        }
        else if(x!=0 && month==02 && day<29){
            return true;

        }
        else if((month==1 ||month==3 || month==5 ||month==7 ||month==8 || month==10 ||month==12) && (day<32)){
            return true;

        }else if((month==4 ||month==6 || month==9|| month==11) && (day<31)){
            return true;

        }else{
            return false;
        }

    }
    public static boolean is_date(String v ,String error) {
        try {
            int year = Integer.parseInt(v);
            if (year > 0) {
                return true;

            } else
            {
                System.out.println("negative "+error);
                return false;

            }
        } catch (Exception e) {
            System.out.println("not a integure "+error);
            return false;
        }

    }
    public String getDates(){
        return date;
    }
    public void setDates(String dates){
        this.date=date;
    }



}
