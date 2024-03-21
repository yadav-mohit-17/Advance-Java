package test;
public class DemoCon17 {
	public static void main(String[] args) {
		ConnectionPooling cp=new ConnectionPooling("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		cp.createConnection();
		
	}

}
