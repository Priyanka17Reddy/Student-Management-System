package sortinglogic;

import java.util.Comparator;

import com.jspiders.Student;

public class SortStudentByName implements Comparator<Student>{

	@Override
	public int compare(Student X, Student Y) {
		// TODO Auto-generated method stub
		return X.getName().compareTo(Y.getName());
	}

}
