package geico.tdd.utils;

public class AutoData {

	String zipCode;
	String expectedAbtPageTitle;
	String dateOfBirth;
	String firstName;
	String lastName;
	String address;
	String aptNo;
	String expectedVhdPageTitle;
	String vhcYear;
	String vhcMake;
	String vhcModel;

	public AutoData(String zipCode, String expectedAbtPageTitle, String dateOfBirth, String firstName, String lastName,
			String address, String aptNo, String expectedVhdPageTitle, String vhcYear, String vhcMake,
			String vhcModel) {
		if (zipCode == null || expectedAbtPageTitle == null || dateOfBirth == null || firstName == null
				|| lastName == null || address == null || aptNo == null || expectedVhdPageTitle == null
				|| vhcYear == null || vhcMake == null || vhcModel == null || zipCode.length() == 0
				|| expectedAbtPageTitle.length() == 0 || dateOfBirth.length() == 0 || firstName.length() == 0
				|| lastName.length() == 0 || address.length() == 0 || aptNo.length() == 0
				|| expectedVhdPageTitle.length() == 0 || vhcYear.length() == 0 || vhcMake.length() == 0
				|| vhcModel.length() == 0) {
			throw new NullPointerException();
		} else {
			this.zipCode = zipCode;
			this.expectedAbtPageTitle = expectedAbtPageTitle;
			this.dateOfBirth = dateOfBirth;
			this.firstName = firstName;
			this.lastName = lastName;
			this.address = address;
			this.aptNo = aptNo;
			this.expectedVhdPageTitle = expectedVhdPageTitle;
			this.vhcYear = vhcYear;
			this.vhcMake = vhcMake;
			this.vhcModel = vhcModel;

		}
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getExpectedAbtPageTitle() {
		return expectedAbtPageTitle;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getAptNo() {
		return aptNo;
	}

	public String getExpectedVhdPageTitle() {
		return expectedVhdPageTitle;
	}

	public String getVhcYear() {
		return vhcYear;
	}

	public String getVhcMake() {
		return vhcMake;
	}

	public String getVhcModel() {
		return vhcModel;
	}
}
