package cardocha.github.io.cidadesEstadosMc.controller;

import cardocha.github.io.cidadesEstadosMc.api.ApiRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerPrincipal {

    @Autowired
    private ApiRequestService apiRequestService;

    @RequestMapping(value = "/arquivo", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public List refresh() {
        return apiRequestService.gerarArquivo();
    }
}
