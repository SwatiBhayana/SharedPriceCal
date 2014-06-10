
public class Company {
	private String strName;
	private String strYear;
	private String strMonth;
	private int intPrice;
	
	public Company (String strName, String strYear, String strMonth, int intPrice) {
		super();
		this.strName = strName;
		this.strYear = strYear;
		this.strMonth = strMonth;
		this.intPrice = intPrice;
	}
	
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public String getStrYear() {
		return strYear;
	}
	public void setStrYear(String strYear) {
		this.strYear = strYear;
	}
	public String getStrMonth() {
		return strMonth;
	}
	public void setStrMonth(String strMonth) {
		this.strMonth = strMonth;
	}
	public int getIntPrice() {
		return intPrice;
	}
	public void setIntPrice(int intPrice) {
		this.intPrice = intPrice;
	}
	

}
