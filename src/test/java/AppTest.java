import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Go Fish");
  }

  @Test
  public void handIsDisplayedTest() {
    goTo("http://localhost:4567/");
    submit(".btn");
    assertThat(pageSource()).contains("This is Your Hand");
  }
  @Test
  public void cardIsDisplayedTest() {
    goTo("http://localhost:4567/");
    submit(".btn");
    assertThat(pageSource()).contains(String.format("of"));
  }
}
