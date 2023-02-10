
public class Signupdata_2 extends Signupdata_1{
	public String email;
	public String password;
	public Signupdata_2() {
		super("");
		email = "";
		password = "";
	}
	public Signupdata_2(String name, String email, String password) {
		super(name);
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void display()
	{
		System.out.println(toString());
	}
	@Override
	public String toString() {
		return "Signupdata_2 [name=" + name + ", email= "+email + ", password=" + password + "]";
	}
	public Signupdata_2(Signupdata_2 p) {
		super("");
		this.name = p.name;
		this.email = p.email;
		this.password = p.password;
	}
}
