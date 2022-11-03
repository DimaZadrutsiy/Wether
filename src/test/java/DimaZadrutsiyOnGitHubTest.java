import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DimaZadrutsiyOnGitHubTest {

//    TC_11_01
//    1.  Открыть базовую ссылку
//    2.  Нажать на пункт меню Guide
//    3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide и что title этой страницы
//        OpenWeatherMap API guide - OpenWeatherMap

    @Test
    public void testTitleEqualsOpenWeatherMapAPIGuide() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResult = "OpenWeatherMap API guide - OpenWeatherMap";
        String expectedResult2 = "https://openweathermap.org/guide";

        driver.get(url);
        Thread.sleep(5000);
        WebElement clickOnAnElementGuide = driver.findElement(By.xpath("//div[@id='desktop-menu']//li/" + "a[text()='Guide']"));
        clickOnAnElementGuide.click();


        String actualResult = driver.getTitle();

        String actualResult2 = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

        Assert.assertEquals(actualResult2, expectedResult2);


        driver.quit();
    }

//        TC_11_02
//        1.  Открыть базовую ссылку
//        2.  Нажать на единицы измерения Imperial: °F, mph
//        3.  Подтвердить, что температура для города показана в Фарингейтах.

    @Test
    public void testCityTemperatureFahrenheit() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResult = "true";

        driver.get(url);

        Thread.sleep(5000);
        WebElement changeCelsiusToFahrenheit = driver.findElement(By.xpath("//" + "div[@id='weather-widget']//div[text()='Imperial: °F, mph']"));
        changeCelsiusToFahrenheit.click();

        Thread.sleep(2000);
        WebElement confirmCityTemperatureFahrenheit = driver.findElement(By.xpath("//" + "div[@class='section-content']//span[@class='heading']"));

//        String actualResult = String.valueOf(confirmCityTemperatureFahrenheit.getText().charAt(3));
        String actualResult = String.valueOf(confirmCityTemperatureFahrenheit.getText().contains("F"));

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

//        TC_11_03
//        1.  Открыть базовую ссылку
//        2. Подтвердить, что внизу страницы есть панель с текстом “We use cookies which are essential for the site
//        to work. We also use non-essential cookies to help us improve our services. Any data collected is anonymised.
//        You can allow all cookies or manage them individually.”
//        3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”

    @Test
    public void testTextAndButton() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResult = "We use cookies which are essential for the site to work. We also use non-essential " + "cookies to help us improve our services. Any data collected is anonymised. You can allow all " + "cookies or manage them individually.";
        String expectedResult1 = "Allow all";
        String expectedResult2 = "Manage cookies";


        driver.get(url);

        Thread.sleep(5000);
        WebElement textCookies = driver.findElement(By.xpath("//div[@id = 'stick-footer-panel']//p"));
        String actualResult = textCookies.getText();

        Assert.assertEquals(actualResult, expectedResult);

        WebElement buttonAllowAll = driver.findElement(By.xpath("//div[@id = 'stick-footer-panel']" + "//button[text()='Allow all']"));
        String actualResult1 = buttonAllowAll.getText();

        Assert.assertEquals(actualResult1, expectedResult1);

        WebElement linkManageCookies = driver.findElement(By.xpath("//div[@id = 'stick-footer-panel']" + "//a[text()=' Manage cookies ']"));
        String actualResult2 = linkManageCookies.getText();

        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }

//    TC_11_04
//    1.  Открыть базовую ссылку
//    2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”

    @Test
    public void testIdSupport() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResult = "FAQ";
        String expectedResult1 = "How to start";
        String expectedResult2 = "Ask a question";

        driver.get(url);

        Thread.sleep(5000);
        driver.manage().window().maximize();

        WebElement clickOnSupport = driver.findElement(By.xpath("//div[@id='support-dropdown']"));

        clickOnSupport.click();

        WebElement availabilitySubmenu_FAQ = driver.findElement(By.xpath("//ul[@id='support-dropdown-menu']" + "//a[@href='/faq']"));

        String actualResult = availabilitySubmenu_FAQ.getText();

        Assert.assertEquals(actualResult, expectedResult);

        WebElement availabilitySubmenu_HowToStart = driver.findElement(By.xpath("//" + "ul[@id='support-dropdown-menu']//a[@href='/appid']"));

        String actualResult1 = availabilitySubmenu_HowToStart.getText();

        Assert.assertEquals(actualResult1, expectedResult1);

        WebElement availabilitySubmenu_AskAQuestion = driver.findElement(By.xpath("//" + "ul[@id='support-dropdown-menu']//a[@href='https://home.openweathermap.org/questions']"));

        String actualResult2 = availabilitySubmenu_AskAQuestion.getText();

        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();

    }


//    TC_11_05
//    1. Открыть базовую ссылку
//    2. Нажать пункт меню Support → Ask a question
//    3. Заполнить поля Email, Subject, Message
//    4. Не подтвердив CAPTCHA, нажать кнопку Submit
//    5. Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”

    @Test
    public void testErrorCaptcha() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String email = "HelloJava@icloud.com";
        String subject = "Other";
        String message = "Hi Lilu we are waiting for you";

        String expectedResult = "reCAPTCHA verification failed, please try again.";


        driver.get(url);

        Thread.sleep(5000);
        driver.manage().window().maximize();

        WebElement clickOnSupport = driver.findElement(By.xpath("//div[@id='support-dropdown']"));
        clickOnSupport.click();

        String originalWindow = driver.getWindowHandle();

        WebElement selectSubmenu_AskAQuestion = driver.findElement(By.xpath("//" + "ul[@id='support-dropdown-menu']//a[@href='https://home.openweathermap.org/questions']"));
        selectSubmenu_AskAQuestion.click();

        Thread.sleep(3000);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        WebElement enterEmail = driver.findElement(By.xpath("//input[@class='form-control string email " + "required']"));
        enterEmail.click();
        enterEmail.sendKeys(email);

        WebElement enterSubject = driver.findElement(By.xpath("//select[@class='form-control select " + "required']"));
        enterSubject.click();
        enterSubject.sendKeys(subject);

        WebElement enterMessage = driver.findElement(By.xpath("//textarea[@class='form-control text " + "required']"));
        enterMessage.click();
        enterMessage.sendKeys(message);
        Thread.sleep(2000);

        WebElement pressSubmit = driver.findElement(By.xpath("//input[@data-disable-with='Create Question " + "form']"));
        pressSubmit.click();

        WebElement confirmErrorCaptcha = driver.findElement(By.xpath("//div[@class='help-block']"));

        String actualResult = confirmErrorCaptcha.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

//    TC_11_06
//    1.  Открыть базовую ссылку
//    2.  Нажать пункт меню Support → Ask a question
//    3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
//    4.  Оставить пустым поле Email
//    5.  Заполнить поля  Subject, Message
//    6.  Подтвердить CAPTCHA
//    7.  Нажать кнопку Submit
//    8.  Подтвердить, что в поле Email пользователю будет показана ошибка “can't be blank”

    @Test
    public void testErrorEmail() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String subject = "Other";
        String message = "Hi Lilu we are waiting for you";

        String expectedResult = "can't be blank";


        driver.get(url);

        Thread.sleep(5000);
        driver.manage().window().maximize();

        WebElement clickOnSupport = driver.findElement(By.xpath("//div[@id='support-dropdown']"));
        clickOnSupport.click();

        String originalWindow = driver.getWindowHandle();
        Thread.sleep(5000);
        WebElement selectSubmenu_AskAQuestion = driver.findElement(By.xpath("//" + "ul[@id='support-dropdown-menu']//a[@href='https://home.openweathermap.org/questions']"));
        selectSubmenu_AskAQuestion.click();

        Thread.sleep(3000);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(4000);

        WebElement enterSubject = driver.findElement(By.xpath("//select[@class='form-control select " + "required']"));

        enterSubject.click();

        enterSubject.sendKeys(subject);

        Thread.sleep(5000);

        WebElement enterMessage = driver.findElement(By.xpath("//textarea[@class='form-control text " + "required']"));
        enterMessage.click();
        enterMessage.sendKeys(message);

        Thread.sleep(5000);

        String window2 = driver.getWindowHandle();

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='reCAPTCHA']")));

        WebElement enterCaptcha = driver.findElement(By.xpath("//span[@class='recaptcha-checkbox goog-" + "inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox']"));
        enterCaptcha.click();

        Thread.sleep(15000);

        driver.switchTo().window(window2);

        WebElement pressSubmit = driver.findElement(By.xpath("//input[@data-disable-with='Create Question " + "form']"));
        pressSubmit.click();

        WebElement confirmErrorEmail = driver.findElement(By.xpath("//span[@class='help-block']"));

        String actualResult = confirmErrorEmail.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }


//    TC_11_07
//    1.  Открыть базовую ссылку
//    2.  Нажать на единицы измерения Imperial: °F, mph
//
//    3.  Нажать на единицы измерения Metric: °C, m/s
//    4.  Подтвердить, что в результате этих действий, единицы измерения температуры изменились с F на С


    @Test
    public void testTemperatureFahrenheitOnCelsius() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResult = "true";
        String expectedResult2 = "true";


        driver.get(url);

        Thread.sleep(5000);
        WebElement changeCelsiusToFahrenheit = driver.findElement(By.xpath("//" + "div[@id='weather-widget']//div[text()='Imperial: °F, mph']"));
        changeCelsiusToFahrenheit.click();

        Thread.sleep(2000);
        WebElement confirmCelsiusTemperatureFahrenheit = driver.findElement(By.xpath("//" + "div[@class='section-content']//span[@class='heading']"));

//        String actualResult = String.valueOf(confirmCelsiusTemperatureFahrenheit.getText().charAt(3));
        String actualResult = String.valueOf(confirmCelsiusTemperatureFahrenheit.getText().contains("F"));

        Assert.assertEquals(actualResult, expectedResult);

        WebElement changeFahrenheitToCelsius = driver.findElement(By.xpath("//" + "div[@id='weather-widget']//div[text()='Metric: °C, m/s']"));
        changeFahrenheitToCelsius.click();

        Thread.sleep(2000);

        WebElement confirmFahrenheitTemperatureOnCelsius = driver.findElement(By.xpath("//" + "div[@class='section-content']//span[@class='heading']"));

//        String actualResult2 = String.valueOf(confirmFahrenheitTemperatureOnCelsius.getText().charAt(2));
        String actualResult2 = String.valueOf(confirmFahrenheitTemperatureOnCelsius.getText().contains("C"));

        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }


//    TC_11_08
//    1.  Открыть базовую ссылку
//    2.  Нажать на лого компании
//
//    3.  Дождаться, когда произойдет перезагрузка сайта, и подтвердить, что текущая ссылка не изменилась


    @Test
    public void testCompareEmail() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResult = "https://openweathermap.org/";

        driver.get(url);

        Thread.sleep(5000);

        WebElement clickOnTheLogo = driver.findElement(By.xpath("//" + "a[@href='/']/img[@src='/themes/openweathermap/assets/img/logo_white_cropped.png']"));
        clickOnTheLogo.click();

        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }

//        TC_11_09
//        1.  Открыть базовую ссылку
//        2.  В строке поиска в навигационной панели набрать “Rome”
//        3.  Нажать клавишу Enter
//        4.  Подтвердить, что вы перешли на страницу в ссылке которой содержатся слова “find” и “Rome”
//        5.  Подтвердить, что в строке поиска на новой странице вписано слово “Rome”


    @Test
    public void testSearchLineCityRome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String cityName = "Rome";
        String find = "find";

        String expectedResult2 = "Rome";

        driver.get(url);

        Thread.sleep(5000);

        WebElement searchLine = driver.findElement(By.name("q"));
        searchLine.click();
        searchLine.sendKeys(cityName);
        searchLine.sendKeys(Keys.ENTER);

        boolean actualResult = driver.getCurrentUrl().contains(find) && driver.getCurrentUrl().contains(cityName);

        Assert.assertTrue(actualResult);

        WebElement cityInTheSearchBar = driver.findElement(By.id("search_str"));

        String actualResult2 = cityInTheSearchBar.getAttribute("value");

        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }


//    TC_11_10
//    1.  Открыть базовую ссылку
//    2.  Нажать на пункт меню API
//    3.  Подтвердить, что на открывшейся странице пользователь видит 30 оранжевых кнопок

    @Test
    public void testOrangeBatton() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        int expectedResult = 30;

        driver.get(url);

        Thread.sleep(5000);

        WebElement linkAPI = driver.findElement(By.xpath("//a[@href='/api']"));
        linkAPI.click();

        int actualResult = driver.findElements(By.xpath("//a[contains(@class, 'orange')]")).size();

        Assert.assertEquals(actualResult, expectedResult);


        driver.quit();


    }

}







