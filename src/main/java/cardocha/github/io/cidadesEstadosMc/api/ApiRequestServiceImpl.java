package cardocha.github.io.cidadesEstadosMc.api;

import cardocha.github.io.cidadesEstadosMc.model.Cidade;
import cardocha.github.io.cidadesEstadosMc.model.Estado;
import cardocha.github.io.cidadesEstadosMc.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiRequestServiceImpl implements ApiRequestService {

    @Autowired
    private RequestUtils requestUtils;

    @Override
    public List getEstados() {
        return requestUtils.get(EndPoint.ESTADOS.toString(), Estado.class);
    }

    @Override
    public List getCidades(long estadoId) {
        String url = EndPoint.CIDADES.toString().replace("{UF}", String.valueOf(estadoId));
        return requestUtils.get(url, Cidade.class);
    }

    public List getInformacoesIBGE() {
        List<Estado> estados = getEstados();
        List<Cidade> cidades = new ArrayList<>();

        for (Estado estado : estados) {
            cidades.addAll(getCidades(estado.getId()));
        }

        return cidades;
    }

}
