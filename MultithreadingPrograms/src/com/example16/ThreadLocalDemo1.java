package example16;

public class ThreadLocalDemo1 {

    public static void main(String[] args) {

        ThreadLocal t1 = new ThreadLocal();

        //Default initial value = null
        System.out.println("T1:" + t1.get());

        t1.set("MyValue");
        System.out.println("T1:" + t1.get());
        t1.remove();

        //Default initial value = null
        System.out.println("T1:" + t1.get());

        //Overriding initial value using anonymous class
        ThreadLocal t2 = new ThreadLocal() {

            public Object initialValue() {
                return "Default Value";
            }
        };
        //Default initial value = Default Value
        System.out.println("T2:" + t2.get());

        t2.set("MyValue");
        System.out.println("T2:" + t2.get());
        t2.remove();

        //Default initial value = Default Value
        System.out.println("T2:" + t2.get());
    }

}
