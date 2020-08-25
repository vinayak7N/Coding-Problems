package example16;

public class ThreadLocalDemoInheritance3 {

    public static void main(String[] args) {

        ParentThread parentThread = new ParentThread();
        parentThread.start();
    }

}

class ParentThread extends Thread {

    static ThreadLocal parentThreadLocal = new ThreadLocal();

    public void run() {

        parentThreadLocal.set("MyParent");
        System.out.println("Parent value:" + parentThreadLocal.get());
        ChildThread childThread = new ChildThread();
        childThread.start();
    }
}

class ChildThread extends Thread {

    public void run() {

        /*Here in, parent thread local value won't be available for child thread
          and default value is set which is null...
          To get the parent thread local value we need to use "InheritableThreadLocal"
          */
        System.out.println("Child thread value inherited from parent: "
                + ParentThread.parentThreadLocal.get());
    }
}


