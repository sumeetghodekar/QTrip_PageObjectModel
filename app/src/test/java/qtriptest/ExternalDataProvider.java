 package qtriptest;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class ExternalDataProvider {

    DP dataProviderUtility;

    @DataProvider(name="qtripData")
    public Object[][] qtripData() throws IOException
    {
        dataProviderUtility = new DP();
        return dataProviderUtility.dpMethod("TestCase01");
    }
}
