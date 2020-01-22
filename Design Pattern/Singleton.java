
package com.design.patterns;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * @author Vinayak Nair$
 *
 */

public class Singleton {
	public static void main(String[] args) {
		SingletonClass firstObject = SingletonClass.getInstance();
		SingletonClass secondObject = SingletonClass.getInstance();
		System.out.println("firstObject HashCode: " + firstObject.hashCode());
		System.out.println("secondObject HashCode: " + secondObject.hashCode());

		/* Breaking Singleton contract using Reflection */
		try {
			Class<?> class1 = Class.forName("com.design.patterns.SingletonClass");
			Constructor<?> constr = class1.getDeclaredConstructor();
			constr.setAccessible(true);
			SingletonClass thirdObject = (SingletonClass) constr.newInstance();
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
			SingletonClass fourthObject = (SingletonClass) in.readObject();
			System.out.println("Serialization::fourthObject HashCode: " + fourthObject.hashCode());
			in.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		/*
		 * Breaking Singleton contract using Cloning
		 */

		try {
			SingletonClass fifthObject = (SingletonClass) firstObject.clone();
			System.out.println("Cloning::fifthObject HashCode: " + fifthObject.hashCode());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		/*
		 * Breaking Singleton contract using MultiThreading
		 */
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(Singleton::useSingleton);
		service.submit(Singleton::useSingleton);
		service.shutdown();
	}

	static void useSingleton() {
		SingletonClass sixthObject = SingletonClass.getInstance();
		// Sometimes same output and sometimes different...
		System.out.println("Multithreading::sixthObject HashCode:" + sixthObject.hashCode());
	}
}

class SingletonClass implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private static SingletonClass singletonObject = new SingletonClass(); //Eager
	// loading...
	private static SingletonClass singletonObject;

	private SingletonClass() {
		System.out.println("Creating Object....");
	}

	public static SingletonClass getInstance() {
		if (singletonObject == null) {
			singletonObject = new SingletonClass(); // lazy Loading....
		}
		return singletonObject;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
