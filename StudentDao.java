package Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDao {
    Scanner ne = new Scanner(System.in);

    public StudentDao() {

    }

    public boolean insert(Student st) {
        boolean f = false;

        try {
            Connection con = CP.create();
            String querry = "insert into student(name,phone,city) values(?,?,?)";
            //prepared statements
            PreparedStatement pstmt = con.prepareStatement(querry);
            pstmt.setString(1, st.getStudentName());
            pstmt.setString(2, st.getStudentPhone());
            pstmt.setString(3, st.getStudentCity());

            // execute
            pstmt.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }


    public boolean delete(String mid ) {
        boolean l =  false;
        try {
            int a = Integer.parseInt(mid);
            Connection con = CP.create();
            String querry = "delete from student where id = ?";
            //prepared statements
            PreparedStatement pstmt = con.prepareStatement(querry);
            pstmt.setInt(1, a);


            // execute
            pstmt.executeUpdate();
            l = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

    public void display() {

        try {
            Connection con = CP.create();
            String querry = "select * from student ";
            //prepared statements
         Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(querry);

while(rs.next())
{
    int id =  rs.getInt(1);
    String name = rs.getString(2);
    String phone = rs.getString(3);
    String city = rs.getString("city");
    System.out.println("id :"+id );
    System.out.println("name :"+name );
    System.out.println("phone  :"+phone );
    System.out.println("city :"+city );
}

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean update() {
        boolean m =  false;
        System.out.println("Enter id :" );
        int i = Integer.parseInt(ne.nextLine());
        System.out.println("Enter new name : ");
        String name = ne.nextLine();
        System.out.println("enter city name :");
        String city = ne.nextLine();

        try {
            Connection con = CP.create();
            String querry = "update student set city=? , name=?  where id=?";
            //prepared statements
            PreparedStatement pstmt = con.prepareStatement(querry);
            pstmt.setString(1,city );
            pstmt.setString(2,name );
            pstmt.setInt(3,i );


            // execute
            pstmt.executeUpdate();
            m = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;


    }
}
