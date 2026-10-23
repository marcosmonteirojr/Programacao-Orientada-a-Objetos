import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import View.MedicoVeterinarioView;
import Controller.MedicoVeterinarioController;
public class Principal {

    public static void main(String[] args) {

        // 1. (Opcional) Altera o design da interface para o padrão do Sistema Operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Não foi possível carregar o visual nativo do sistema.");
        }

        // 2. Inicia a aplicação na Thread correta de interface gráfica do Java (Event Dispatch Thread)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Passo A: Instancia a janela (View)
                // Neste momento ela ainda está invisível e os botões não fazem nada
                MedicoVeterinarioView view = new MedicoVeterinarioView();

                // Passo B: Instancia o Controller e entrega a View para ele
                // O Controller vai ligar-se à base de dados (DAO) e dar "vida" aos botões da View
                MedicoVeterinarioController controller = new MedicoVeterinarioController(view);

                // Passo C: Finalmente, exibe a janela pronta e funcional para o utilizador
                view.setVisible(true);
            }
        });
    }
}