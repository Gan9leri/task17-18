package helpers;
import Authorization.Authorization;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        Authorization.setCookiesInBrowser(Authorization.getCookie());
    }
}