package BackEnd;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.reporting.shadow.org.opentest4j.reporting.events.core.UserName;


public class facadeTest {
    facade testFacade;

    @BeforeEach
    public void setUp() {
        facade testFacade = new facade();

    }

    @AfterEach
    public void reset() {
        testFacade = new facade();

    }

    
@Test
public void NullLoginTests() {
    facade testFacade = new facade();
    assertTrue(testFacade.login(null, null) == null);
    testFacade.logout();
    assertTrue(testFacade.getCurrentUser() == null);
}
@Test
public void CreateAccountTest() {
        facade testFacade = new facade();
        assertTrue("Account Not Created",testFacade.createAccount("Username", "first", "Last", "@email", "U5555",UserType.STUDENT,"1234"));
}
@Test
public void DupAccountTest() {
    facade testFacade = new facade();
    testFacade.createAccount("Username", "first", "Last", "@email", "U5555",UserType.STUDENT,"1234");
    // checks to see if duplacate accounts can be made 
    assertFalse("Duplacate Made",testFacade.createAccount("Username", "first", "Last", "@email", "U5555",UserType.STUDENT,"1234"));
}
@Test
public void SameUSCID() {
    facade testFacade = new facade();
    testFacade.createAccount("Username", "first", "Last", "@email", "U5555",UserType.STUDENT,"1234");
    // checks to see if duplacate accounts can be made 
    assertFalse("Duplacate Made",testFacade.createAccount("Username1", "first", "Last", "@email", "U5555",UserType.STUDENT,"1234"));

}



}





