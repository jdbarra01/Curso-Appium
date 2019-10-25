package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HomeApp {

    protected static AppiumDriver driver = null;

    public HomeApp(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "main_search")
    private MobileElement buscarNombre;

    @AndroidFindBy(id = "name")
    private MobileElement nombreBusccar;

    @AndroidFindBy(id = "result_list")
    private List<MobileElement> elementosSelector;

    public void buscar(String name) {
        buscarNombre.sendKeys(name);
    }

    public void resultadoBusqueda(String resultadoValor) {
        Assert.assertEquals(resultadoValor, nombreBusccar.getText());
    }

    public void validar(String valor) {
        boolean seleccionado = false;
        for (int i = 0; i < 4; i++) {
            if (elementosSelector.get(i).getText().equals(valor)) {
                seleccionado = true;
            }
        }

    }


}


