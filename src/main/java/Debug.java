import utils.HibernateSessionFactory;

public class Debug {

    public static void main(String[] args){
        HibernateSessionFactory.getSession();
        System.out.println("Scheme validated!");
        System.exit(0);
    }
}
