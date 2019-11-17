package cardocha.github.io.cidadesEstadosMc.controller;

import cardocha.github.io.cidadesEstadosMc.api.ApiRequestService;
import cardocha.github.io.cidadesEstadosMc.dto.DesafioDto;
import cardocha.github.io.cidadesEstadosMc.model.Cidade;
import cardocha.github.io.cidadesEstadosMc.utils.FileOutputUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllerPrincipal {

    @Autowired
    private ApiRequestService apiRequestService;

    private List<DesafioDto> listaInformacoesIbge;

    private List<Cidade> listaCidades;

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public List json() {
        return listaInformacoesIbge;
    }

    @RequestMapping(value = "/csv", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public OutputStream csv(HttpServletResponse response) {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=infoCidadesIBGE.csv;");
        return new FileOutputUtils().toCsv(response, listaInformacoesIbge);
    }

    @RequestMapping(value = "/cidades/{nomeCidade}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public long getCidade(@PathVariable("nomeCidade") String nomeCidade) {
        Cidade cidade = listaCidades.stream()
                .filter(c -> nomeCidade.equals(c.getNome()))
                .findFirst()
                .orElse(null);

        return cidade.getId();
    }

    @EventListener(ApplicationReadyEvent.class)
    private void getListaInformacoesIBGE() {
        listaCidades = apiRequestService.getInformacoesIBGE();

        listaInformacoesIbge = new ArrayList<>();
        for (Cidade cidade : listaCidades) {
            listaInformacoesIbge.add(new DesafioDto(cidade));
        }
    }

}
