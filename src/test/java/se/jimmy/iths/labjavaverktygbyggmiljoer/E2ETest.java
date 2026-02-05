package se.jimmy.iths.labjavaverktygbyggmiljoer;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class E2ETest {

    @LocalServerPort
    private int port;
    private static Playwright playwright;
    private Browser browser;
    private Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
    }
    @AfterAll
    static void closePlayWright() {
        playwright.close();
    }

    @BeforeEach
    void createContext() {
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        page = browser.newPage();
    }

    @AfterEach
    void closeContext() {
        browser.close();
    }

    @Test
    @DisplayName("Sidan ska gå att nå och ha korrekt titel")
    void pageIsAccessibleAndHasCorrectTitle() {
        page.navigate("http://localhost:" + port + "/atm");
        assertThat(page).hasTitle("ATM Balance");
    }

    @Test
    @DisplayName("Sidan ska visa välkomstmeddelande och saldo-sektion")
    void pageDisplaysCorrectContent() {
        page.navigate("http://localhost:" + port + "/atm");
        assertThat(page.locator("h1")).containsText("Välkommen till Bankomaten");
                assertThat(page.locator("body")).containsText("Ditt nuvarande saldo är:");
    }
}
