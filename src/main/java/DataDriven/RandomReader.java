package DataDriven;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomReader {
    public String UserName;
    public void randomReader (){
        String generate = RandomStringUtils.randomAlphabetic(10);
         UserName = generate;
    }
}
