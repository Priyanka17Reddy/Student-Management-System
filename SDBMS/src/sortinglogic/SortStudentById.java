package sortinglogic;

import java.util.Comparator;

import com.jspiders.Student;

public class SortStudentById implements Comparator<Student>{
	public int compare(Student X, Student Y)
	{
		return X.getId().compareTo(Y.getId());
	}
}
