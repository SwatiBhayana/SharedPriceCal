import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class CompanyLoader {
	private static List<Company> companies;
	private int lastReadIdx=0;

	   public CompanyLoader() {
	   }
	
	@SuppressWarnings("finally")
	public List<Company> loadCompanies() throws Exception {
		Scanner s = null;
		try {
			companies = new ArrayList<Company>();
			File f = new File("C:\\Documents and Settings\\TEMP\\Desktop\\CompanyData.csv");
			System.out.println(f.getAbsolutePath());
			s = new Scanner(new FileInputStream(f));
			String[] headers = readLine(s);
			System.out.println("headers"+Arrays.toString(headers));
			if(headers!=null &&  headers.length > 0) {
				String[] data = null;
				while ((data=readLine(s))!=null) {
					System.out.println("data: " + Arrays.toString(data));
		               if (data.length != headers.length) {
		                  //companies = null;
		                  throw new Exception("Invalid Data - headers count " + headers.length + " does not match with data count "+data.length);
		               }
		               String year = data[0];
		               String month = data[1];
		               for (int x=2; x<data.length; x++) {
		                  int price = new Integer(data[x]).intValue();
		                  Company company = new Company(headers[x], year, month, price);
		                  companies.add(company);
		               }
		               
				}
			}
			return companies;
		}
		finally {
			if (s != null) s.close();
			return companies;

		}
	}
	protected Company getNextCompanyData() {
	      if (companies == null) {
	         lastReadIdx = 0;
	         try {
	            companies = loadCompanies();
	         } catch (Exception e) {
	         }
	      }
	      if (companies == null) return null;
	      if (lastReadIdx < companies.size()) return companies.get(lastReadIdx++);
	      return null;
	   }

	private String[] readLine(Scanner s) {
		if(s.hasNextLine()){
			return s.nextLine().trim().split(",");
		}
		return null;
	}
	public static void main (String args[]) {
		CompanyLoader loader = new CompanyLoader();
		loader.processCompanies();
	}
	public void processCompanies(){
		Map <String, Company> companies = new HashMap <String, Company>();
		Company newCompany = null;
		
		while ((newCompany = getNextCompanyData()) != null) {
	         Company oldCompany = companies.get(newCompany.getStrName());
	         if (oldCompany == null || newCompany.getIntPrice() > oldCompany.getIntPrice())
	            companies.put(newCompany.getStrName(), newCompany);
	      }
	      // Done, now display the winners
	      for (String name : companies.keySet()) {
	         Company company = companies.get(name);
	         System.out.println(company.getStrName() + " highest price " + company.getIntPrice() + " is " + company.getStrMonth() + " " + company.getStrYear());
	      }

	}
}
