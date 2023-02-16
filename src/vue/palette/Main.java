package vue.palette;
import java.awt.EventQueue;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {



        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                new Login();

            }
        });

    }

}