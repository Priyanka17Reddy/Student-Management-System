package example;

public class UpdatingId {
private String id;
private String name;

static int count=101;

public UpdatingId( String name) {
	super();
	this.id = "JSP"+count;
	this.name = name;
	count++;
	
}
public String getId() {
	return id;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

@Override
public String toString() {
	return "student name is "+name+"id is "+ id;
}
public static void main(String[] args) {
	UpdatingId u1=new UpdatingId("prii");
	System.out.println(u1);
	UpdatingId u2=new UpdatingId("vach");
	System.out.println(u2);
}
}
