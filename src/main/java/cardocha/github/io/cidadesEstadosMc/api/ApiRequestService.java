package cardocha.github.io.cidadesEstadosMc.api;

import java.util.List;

public interface ApiRequestService {
    List getEstados();

    List getCidades(long estadoId);

    List gerarArquivo();
}
