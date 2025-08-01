package login;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.*;
import page.products.ProductsPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static io.qameta.allure.Allure.step;
import static util.Constants.*;

@Tag("Login")
public class SuccessfulLoginTest extends BaseTest {

    // Pages
    private ProductsPage productsPage;

    @BeforeMethod
    public void setUpTest() {
        // Initialize products page
        productsPage = new ProductsPage(page);
    }

    @Test(testName = "Successful login with valid credentials")
    @Description("Verify successful login with valid credentials")
    public void test() {
        step("1. Open the login page",
                loginPage::navigate
        );

        step("2. Enter valid credentials and verify that a page with products list is displayed", () -> {
            loginPage.login(LOGIN_STANDARD_USER, PASSWORD);

            assertThat(productsPage.getProductsListLocator()).isVisible();
        });
    }
}
