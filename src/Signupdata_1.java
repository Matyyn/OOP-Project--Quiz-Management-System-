// Used for inheritance
public class Signupdata_1 extends Signupdata0{
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Signupdata_1(String name) {
		this.name = name;
	}
	public void display()
	{
		System.out.println(toString());
	}
	public String toString() {
		return "Signupdata_1 [name=" + name + "]";
	}
	public Signupdata_1(Signupdata_1 p) {
		this.name = p.name;
	}
}
