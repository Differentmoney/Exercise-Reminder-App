package cs6440.exercise;

//patient list from database, edit this
public class Patients {
    private String username;
    private String sex;

    public Patients(String username, String s){
        this.username=username;
        this.sex=s;
    }

    public Patients(String username) {
        this.username=username;
    }
    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

}
