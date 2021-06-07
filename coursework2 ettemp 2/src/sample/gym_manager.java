package sample;

import javafx.collections.ObservableList;

import java.util.List;

public interface gym_manager {
    public void addMember(default_member member);
    public boolean deleteMember(String membership_no);

    public  void sort();
    public void save();
    public void console_list() ;
    public  boolean checkmemno(String num);

    public String get_member_by_name(String name);
    public int readfile();
    public ObservableList<list>getProduct();
}
