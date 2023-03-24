package sortinglogic;

import java.util.Comparator;

import com.jspiders.Student;

public class SortStudentByAge implements Comparator<Student>{
public int compare(Student X, Student Y)
{
	return X.getAge()-Y.getAge();
}
}
