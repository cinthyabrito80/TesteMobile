package screens;

import base_screen.BaseScreen;
import page_objects.CompraPage;

public class CompraScreen extends BaseScreen {

    private CompraPage compraPage;

    public CompraScreen() {
        this.compraPage = new CompraPage(driver);
    }
}
