package cadastroRebeldeApp;

import cadastroRebeldeApp.Controller.InteligenciaCentral;
import cadastroRebeldeApp.View.ICView;
import cadastroRebeldeApp.View.RebeldeView;

public class main {
    public static void main(String[] args) {
        InteligenciaCentral inteligenciaCentral = new InteligenciaCentral();
        RebeldeView rebeldeView = new RebeldeView();
        ICView inteligenciaCentralView = new ICView(inteligenciaCentral, rebeldeView);
        inteligenciaCentralView.apresentarMenu();
    }
}
