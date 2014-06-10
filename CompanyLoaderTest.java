import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;


public class CompanyLoaderTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		List companies = new ArrayList<Company>();
		CompanyLoader loader = new CompanyLoader();
		Company newCompany = null;
		try {
			companies = loader.loadCompanies();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int size = companies.size();
		assertTrue(size==4688);
		
		Map <String, Company> companiesMap = new HashMap <String, Company>();
		while ((newCompany = loader.getNextCompanyData()) != null) {
	         Company oldCompany = companiesMap.get(newCompany.getStrName());
	         if (oldCompany == null || newCompany.getIntPrice() > oldCompany.getIntPrice())
	            companiesMap.put(newCompany.getStrName(), newCompany);
	      }
		
		assertTrue(companiesMap.size()==16);
		
		
	}

}
