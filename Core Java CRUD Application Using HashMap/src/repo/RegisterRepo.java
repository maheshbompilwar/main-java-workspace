package repo;

import model.Student;

import java.util.HashMap;
import java.util.Map;



public class RegisterRepo {

	Map<Integer, Student> students = new HashMap<>();
	
	public String saveStudent(Student student) {
		students.put(student.getRollNo(),student);
		return "Student Added Successfully...";
	}
	
	public String updateStudent(Student student) {
		int rollNo = student.getRollNo();
		if(students.containsKey(rollNo)) {
			students.put(student.getRollNo(),student);
			return "Student Updated Successfully...";	
		}else {
			return "Student not available with this roll No.";
		}
		
	}
	
	public Map<Integer,Student> getStudents(){
		return students;
	}
	
	public String deleteStudentByRollNo(int rollNo) {
		students.remove(rollNo);
		return "Student Removed Successfully";
	}
	
}
