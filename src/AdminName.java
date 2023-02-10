
public class AdminName {
	public String name;

	public AdminName() {
		name ="";
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AdminName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AdminName [name=" + name + "]";
	}
}
