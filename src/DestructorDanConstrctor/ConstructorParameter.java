package DestructorDanConstrctor;

public class ConstructorParameter {

   public String username;
   public String password;

    public ConstructorParameter(String username, String password) {
        this.username = username;
        this.password = password;
    }

    class ConstructorMakeParameter{
    public static void main(String[] args) {
        ConstructorParameter user = new ConstructorParameter("Mimin Adresteia", "Adresteia11");
        System.out.println("Username : " + user.username);
        System.out.println("Password : " + user.password);
    }   
} 
}
