import java.util.ArrayList;
import java.util.List;

/*
 * @author Vinayak Nair$
 *
 */
public class DAODesignPattern {

	public static void main(String[] args) {
		DAO userDao =new UserDAO();
		User firstUser=userDao.get(0);
		System.out.println(firstUser);
		firstUser.setUserEmail("harry.mill@gmail.com");
		userDao.updateUser(firstUser);
		firstUser=userDao.get(0);
		System.out.println(firstUser);
		System.out.println(userDao.getAll());
		userDao.deleteUser(0);
		System.out.println(userDao.getAll());
		userDao.addUser(new User("Mike","Mike@gmail.com"));
		System.out.println(userDao.getAll());
		
		
	}

}

class User {
	String userName;
	String userEmail;

	public User(String userName, String userEmail) {
		this.userEmail = userEmail;
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User: " + userName + "-" + userEmail;
	}
}

interface DAO {
	User get(int id);

	List<User> getAll();

	void addUser(User user);

	void updateUser(User user);

	void deleteUser(int id);
}

class UserDAO implements DAO {

	List<User> userList = new ArrayList<>();

	UserDAO() {
		userList.add(new User("Harry", "harry@gmail.com"));
		userList.add(new User("Bill", "bill@gmail.com"));
	}

	@Override
	public User get(int id) {
		return userList.get(id);
	}

	@Override
	public List<User> getAll() {
		return userList;
	}

	@Override
	public void addUser(User user) {
		if (user != null) {
			userList.add(user);
		} else {
			System.out.println("Invalid Arguments!");
		}
	}

	@Override
	public void updateUser(User user) {

		for (User oldUser : userList) {
			if (oldUser.getUserName().equals(user.getUserName())) {
				int index = userList.indexOf(oldUser);
				userList.set(index, user);
				return;
			}
		}
	}

	@Override
	public void deleteUser(int id) {
		userList.remove(id);
	}
}