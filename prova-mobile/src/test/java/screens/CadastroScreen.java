package screens;

import base_screen.BaseScreen;
import page_objects.CadastroPage;

public class CadastroScreen extends BaseScreen {

    private CadastroPage cadastroPage;

    public CadastroScreen () {
        this.cadastroPage = new CadastroPage(driver);
    }
}
