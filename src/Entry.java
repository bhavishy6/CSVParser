import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Entry {

	private String firstName, lastName;
	private String DOB;
	private String ID;
	private String industry;
	private String active;
	private static final int FIRSTNAMELENGTH = 15;
	private static final int LASTNAMELENGTH = 20;
	private static final int IDLENGTH = 5;
	private static final int INDUSTRYLENGTH = 30;
	private static final int ACTIVELENGTH = 1;

	public Entry(String firstName, String lastName, String DOB, String ID,
			String industry, String active) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.DOB = DOB.replaceAll(" ", "");
		this.ID = ID;
		this.industry = industry;
		this.active = active;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the DOB
	 */
	public String getDOB() {
		return DOB;
	}

	/**
	 * @return the ID
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @return the industry
	 */
	public String getIndustry() {
		return industry;
	}

	/**
	 * @return active
	 */
	public String getActive() {
		return active;
	}

	public void validateDOB(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String dob = "";
		Date d = null;
		try {
			d = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dob = dateFormat.format(d);
		this.DOB = dob;
	}

	private String getTrimmed(String key, String value) {
		String trimmedValue = value;
		switch (key) {
		case "firstName":
			if (value.length() > FIRSTNAMELENGTH) {
				trimmedValue = value.substring(0, FIRSTNAMELENGTH);
			} else if (value.length() < FIRSTNAMELENGTH) {
				for (int i = 0; i < FIRSTNAMELENGTH - value.length(); i++) {
					trimmedValue += " ";
				}
			} else {
				trimmedValue = value;
			}
			break;
		case "lastName":
			if (value.length() > LASTNAMELENGTH) {
				trimmedValue = value.substring(0, LASTNAMELENGTH);
			} else if (value.length() < LASTNAMELENGTH) {
				for (int i = 0; i < LASTNAMELENGTH - value.length(); i++) {
					trimmedValue += " ";
				}
			} else {
				trimmedValue = value;
			}
			break;
		case "DOB":
			this.validateDOB(DOB);
			trimmedValue = DOB;
			break;
		case "ID":
			if (value.length() > IDLENGTH) {
				trimmedValue = value.substring(0, IDLENGTH);
			} else if (value.length() < IDLENGTH) {
				for (int i = 0; i < IDLENGTH - value.length(); i++) {
					trimmedValue += " ";
				}
			} else {
				trimmedValue = value;
			}
			break;
		case "industry":
			if (value.length() > INDUSTRYLENGTH) {
				trimmedValue = value.substring(0, INDUSTRYLENGTH);
			} else if (value.length() < INDUSTRYLENGTH) {
				for (int i = 0; i < INDUSTRYLENGTH - value.length(); i++) {
					trimmedValue += " ";
				}
			} else {
				trimmedValue = value;
			}
			break;
		case "active":
			if (value.length() > ACTIVELENGTH) {
				trimmedValue = value.substring(0, ACTIVELENGTH);
			} else if (value.length() < ACTIVELENGTH) {
				for (int i = 0; i < ACTIVELENGTH - value.length(); i++) {
					trimmedValue += " ";
				}
			} else {
				trimmedValue = value.toUpperCase();
			}
			break;
		default:
			trimmedValue = "Invalid Key";
			break;
		}
		return trimmedValue;
	}

	public String toString() {
		return this.getTrimmed("firstName", firstName)
				+ this.getTrimmed("lastName", lastName)
				+ this.getTrimmed("DOB", DOB) + this.getTrimmed("ID", ID)
				+ this.getTrimmed("industry", industry)
				+ this.getTrimmed("active", active);
	}
}
