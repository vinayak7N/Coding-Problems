
/**
 * @author Vinayak Nair$
 *
 */
public class ProxyDesignPattern {


	public static void main(String[] args) {
		DBConnection connection=new ProxyDBConnection();
		connection.connectToDB("jdbc url");
		connection.connectToDB("oracle url");
	}
}

interface DBConnection {
	public void connectToDB(String url);
}

class RealDBConnection implements DBConnection {

	@Override
	public void connectToDB(String url) {
		System.out.println("Connected to " + url);
	}
}

class ProxyDBConnection extends RealDBConnection {

	@Override
	public void connectToDB(String url) {
		if (url.startsWith("jdbc"))
			super.connectToDB(url);
		else
			System.out.println("Bad url.Connection denied...");
	}
}