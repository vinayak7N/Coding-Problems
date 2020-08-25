package example16;

public class ThreadLocalDemo1 {

    public static void main(String[] args) {

        ThreadLocal t1 = new ThreadLocal();

        //Default initial value = null
        System.out.println(t1.get());

        t1.set("MyValue");
        System.out.println(t1.get());
        t1.remove();

        //Default initial value = null
        System.out.println(t1.get());
    }

}
