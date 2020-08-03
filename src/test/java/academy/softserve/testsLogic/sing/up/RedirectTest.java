package academy.softserve.testsLogic.sing.up;

import academy.softserve.helpers.BaseTest;
import academy.softserve.helpers.StaticDataProvider;
import academy.softserve.widgets.MainPage;
import academy.softserve.widgets.SingUpPage;
import org.testng.annotations.Test;
import static academy.softserve.constantParameters.sing.up.SelectorsValue.*;
import static academy.softserve.constantParameters.BaseLink.BASE_URL;

public class RedirectTest extends BaseTest {
    @Test(groups = {"redirect"},dataProvider = "correctSingUp",dataProviderClass = StaticDataProvider.class)
    public void testSingUp(String mail, String name, String password, String confirmPassword, String expectedPath) {
        open(BASE_URL.getValue());
        new MainPage(driver)
                .singUp()
                .setFor(EMAIL, mail)
                .setFor(USER_NAME, name)
                .setFor(PASSWORD, password)
                .setFor(PASSWORD_CONFIRM, confirmPassword)
                .confirmSingUp(SING_UP_BUTTON)
                .waitSuccessfulRegistrationMsg()
                .checkPath(expectedPath);
    }
}
