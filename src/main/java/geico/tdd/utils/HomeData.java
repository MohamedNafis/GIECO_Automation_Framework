package geico.tdd.utils;

public class HomeData {

	String zipCode2;
	String getAHQPageTitle;
	String location;
	String unitNumber;

	public HomeData(String zipCode2, String getAHQPageTitle, String location, String unitNumber) {
		if (zipCode2 == null || getAHQPageTitle == null || location == null || unitNumber == null
				|| zipCode2.length() == 0 || getAHQPageTitle.length() == 0 || location.length() == 0
				|| unitNumber.length() == 0) {
			throw new NullPointerException();
		} else {
			this.zipCode2 = zipCode2;
			this.getAHQPageTitle = getAHQPageTitle;
			this.location = location;
			this.unitNumber = unitNumber;
		}
	}

	public String getZipCode2() {
		return zipCode2;
	}

	public String getGetAHQPageTitle() {
		return getAHQPageTitle;
	}

	public String getLocation() {
		return location;
	}

	public String getUnitNumber() {
		return unitNumber;
	}

}
