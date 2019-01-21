
public class Patient {
	
	private String name;
	private String id;
	private String address;
	private String phoneNumber;
	
	public Patient (String name, String id, String address, String phoneNumber) {
		this.name = name;
		this.id = id;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public static void main(String[] args) {
		Patient mary = new Patient("Mary", "123", "BHAM", "012114149999");
		System.out.println(mary);
	}

	@Override
	public String toString() {
		return name + "(" + id + ") address: " + address + ", phone:" + phoneNumber + "]";
	}
}
