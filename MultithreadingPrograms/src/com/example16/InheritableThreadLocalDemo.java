package example16;

public class InheritableThreadLocalDemo {

    public static void main(String[] args) {
        ParentThreadInheritance threadInheritance = new ParentThreadInheritance();
        threadInheritance.start();
    }
}

class ParentThreadInheritance extends Thread {

    //Because of this, child thread will get the updated value of parent thread local.
    //static InheritableThreadLocal parentThreadLocal = new InheritableThreadLocal();

    //Because of this statement Child thread will get "Child Value" not the updated parent value
    static InheritableThreadLocal parentThreadLocal = new InheritableThreadLocal() {

        protected Object childValue(Object parent) {

            //Separate value for child thread
            return "Child Value";
        }
    };

    public void run() {

        parentThreadLocal.set("MyParent value");
        System.out.println("Parent value: " + parentThreadLocal.get());
        ChildThreadInheritance childThread = new ChildThreadInheritance();
        childThread.start();
    }
}

class ChildThreadInheritance extends Thread {

    public void run() {

        System.out.println("Child thread value inherited from parent: "
                + ParentThreadInheritance.parentThreadLocal.get());
    }
}

