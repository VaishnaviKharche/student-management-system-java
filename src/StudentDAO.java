import java.sql.*;

public class StudentDAO {

    public void addStudent(Student student) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO students(name, course, fees) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, student.getName());
            ps.setString(2, student.getCourse());
            ps.setDouble(3, student.getFees());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student added successfully!");
            }
        } catch (Exception e) {
            System.out.println("Add Error: " + e.getMessage());
        }
    }

    public void viewStudents() {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM students";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("\n--- Student List ---");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("course") + " | ₹" +
                    rs.getDouble("fees")
                );
            }
        } catch (Exception e) {
            System.out.println("View Error: " + e.getMessage());
        }
    }

    public void deleteStudent(int id) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "DELETE FROM students WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found.");
            }
        } catch (Exception e) {
            System.out.println("Delete Error: " + e.getMessage());
        }
    }
}
