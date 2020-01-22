
package com.design.patterns;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * @author Vinayak Nair$
 *
 */

public class SingletonImproved {
	public static void main(String[] args) {
		SingletonClass2 firstObject = SingletonClass2.getInstance();
		SingletonClass2 secondObject = SingletonClass2.getInstance();
		System.out.println("firstObject HashCode: " + firstObject.hashCode());
		System.out.println("secondObject HashCode: " + secondObject.hashCode());

		/* Breaking Singleton contract using Reflection */
		try {
			Class<?> class1 = Class.forName("com.design.patterns.SingletonClass2");
			Constructor<?> constr = class1.getDeclaredConstructor();
			constr.setAccessible(true);
			SingletonClass2 thirdObject = (SingletonClass2) constr.newInstance();
			System.out.println("Reflection::thirdObject HashCode: " + thirdObject.hashCode());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| SecurityException | ClassNotFoundException | NoSuchMethodException e) {
			e.printStackTrace();
		}

		/*
		 * Breaking Singleton contract using Serialization
		 */

		try {
			// Serialization of second object
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("s2.ser"));
			out.writeObject(secondObject);
			out.close();

			// Deserialization of second object
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("s2.ser"));
			SingletonClass2 fourthObject = (SingletonClass2) in.readObject();
			System.out.println("Serialization::fourthObject HashCode: " + fourthObject.hashCode());
			in.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		/*
		 * Breaking Singleton contract using Cloning
		 */

		try {
			SingletonClass2 fifthObject = firstObject.clone();
			System.out.println("Cloning::fifthObject HashCode: " + fifthObject.hashCode());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		/*
		 * Breaking Singleton contract using MultiThreading
		 */
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(SingletonImproved::useSingleton);
		service.submit(SingletonImproved::useSingleton);
		service.shutdown();
	}

	static void useSingleton() {
		SingletonClass2 sixthObject = SingletonClass2.getInstance();
		// Sometimes same output and sometimes different...
		System.out.println("Multithreading::sixthObject HashCode:" + sixthObject.hashCode());
	}
}

class SingletonClass2 implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private static SingletonClass singletonObject = new SingletonClass();  Eager loading...
	//volatile added to stop thread from getting partially instantiated object
	private static volatile SingletonClass2 singletonObject;

	private SingletonClass2() {
		// To handle Reflection issue...
		if (singletonObject != null) {
			throw new RuntimeException("Cannot create, please use getInstance() method...");
		}
		System.out.println("Creating Object....");
	}

	// Synchronized to stop multiple threads from creating object...
	public static SingletonClass2 getInstance() {
		if (singletonObject == null) {
			synchronized (SingletonClass2.class) {
				if (singletonObject == null) { //Double check locking...
					singletonObject = new SingletonClass2(); // lazy Loading....
				}
			}
		}
		return singletonObject;
	}

	private Object readResolve() throws ObjectStreamException {
		System.out.println(
				"This is called before deserialization. Here, we are returning the created instance to maintain contract of Singleton object...");
		return singletonObject;
	}

	@Override
	protected SingletonClass2 clone() throws CloneNotSupportedException {
		// return super.clone(); // default return.

		// A Singleton object should not be clobeable.
		// throw new RuntimeException("Clone not supported!!");

		// And if we need to clone then we can simply return the single instance.
		return singletonObject;
	}
}
