package sortinglogic;

import java.util.Comparator;

import com.jspiders.Student;

public class SortStudentByMarks implements Comparator<Student>{
public int compare(Student X, Student Y)
{
	return (int) (X.getMarks()-Y.getMarks());
}
}
