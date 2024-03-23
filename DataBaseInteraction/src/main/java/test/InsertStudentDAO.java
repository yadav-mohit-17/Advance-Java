package test;
import java.sql.*;
public class InsertStudentDAO {

	public int k=0;
	public int insert(StudentBean sb) {
		try {
			Connection cn=DBConnection.getCon();
			PreparedStatement ps = cn.prepareStatement("insert into studentTable values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, sb.getId());
			ps.setString(2, sb.getFirstName());
			ps.setString(3, sb.getLastName());
			ps.setString(4, sb.getFatherName());
			ps.setString(5, sb.getMotherName());
			ps.setString(6, sb.getCourse());
			ps.setString(7, sb.getBloodGroup());
			ps.setString(8, sb.getEmail());
			ps.setString(9, sb.getMobile());
			ps.setString(10, sb.getCollegeName());
			ps.setString(11, sb.getUniversityName());
			
			
			k=ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
