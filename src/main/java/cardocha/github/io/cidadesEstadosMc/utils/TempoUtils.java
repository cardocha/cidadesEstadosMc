package cardocha.github.io.cidadesEstadosMc.utils;

public class TempoUtils {

    public static void aguardar(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
