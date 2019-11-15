package cardocha.github.io.cidadesEstadosMc.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

public class OutputDto {

    private String field;
    private String value;

    public OutputDto() {
    }

    public OutputDto(String field, String value) {
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static OutputDto from(Object o, String fieldName) {
        OutputDto outputDto = new OutputDto();
        outputDto.setField(fieldName);
        outputDto.setValue(o.toString());
        return outputDto;
    }
}
