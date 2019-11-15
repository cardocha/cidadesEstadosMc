package cardocha.github.io.cidadesEstadosMc.dto;

import cardocha.github.io.cidadesEstadosMc.model.Cidade;

public class DesafioDto {

    private OutputDto idEstado;
    private OutputDto siglaEstado;
    private OutputDto regiaoNome;
    private OutputDto nomeCidade;
    private OutputDto nomeMesorregiao;
    private OutputDto nomeFormatado;

    public DesafioDto(OutputDto idEstado, OutputDto siglaEstado, OutputDto regiaoNome, OutputDto nomeCidade, OutputDto nomeMesorregiao, OutputDto nomeFormatado) {
        this.idEstado = idEstado;
        this.siglaEstado = siglaEstado;
        this.regiaoNome = regiaoNome;
        this.nomeCidade = nomeCidade;
        this.nomeMesorregiao = nomeMesorregiao;
        this.nomeFormatado = nomeFormatado;
    }

    public DesafioDto() {
    }

    public OutputDto getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(OutputDto idEstado) {
        this.idEstado = idEstado;
    }

    public OutputDto getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(OutputDto siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    public OutputDto getRegiaoNome() {
        return regiaoNome;
    }

    public void setRegiaoNome(OutputDto regiaoNome) {
        this.regiaoNome = regiaoNome;
    }

    public OutputDto getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(OutputDto nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public OutputDto getNomeMesorregiao() {
        return nomeMesorregiao;
    }

    public void setNomeMesorregiao(OutputDto nomeMesorregiao) {
        this.nomeMesorregiao = nomeMesorregiao;
    }

    public OutputDto getNomeFormatado() {
        return nomeFormatado;
    }

    public void setNomeFormatado(OutputDto nomeFormatado) {
        this.nomeFormatado = nomeFormatado;
    }

    public static DesafioDto from(Cidade cidade) {
        DesafioDto desafioDto = new DesafioDto();

        OutputDto idEstado = OutputDto.from(cidade
                .getMicroRegiao()
                .getMesoRegiao()
                .getEstado().getId(), "idEstado");
        desafioDto.setIdEstado(idEstado);

        OutputDto siglaEstado = OutputDto.from(cidade
                .getMicroRegiao()
                .getMesoRegiao()
                .getEstado()
                .getSigla(), "siglaEstado");
        desafioDto.setSiglaEstado(siglaEstado);

        OutputDto regiaoNome = OutputDto.from(cidade
                .getMicroRegiao()
                .getMesoRegiao()
                .getEstado()
                .getRegiao()
                .getNome(), "regiaoNome");
        desafioDto.setRegiaoNome(regiaoNome);

        OutputDto nomeCidade = OutputDto.from(cidade.getNome(), "nomeCidade");
        desafioDto.setNomeCidade(nomeCidade);

        OutputDto nomeMesoRegiao = OutputDto.from(cidade
                .getMicroRegiao()
                .getMesoRegiao()
                .getNome(), "nomeMesorregiao");
        desafioDto.setNomeMesorregiao(nomeMesoRegiao);

        OutputDto nomeFormatado = OutputDto.from(cidade.getNome() + " / " + cidade
                .getMicroRegiao()
                .getMesoRegiao()
                .getEstado()
                .getSigla(), "nomeFormatado");
        desafioDto.setNomeFormatado(nomeFormatado);

        return desafioDto;
    }
}
