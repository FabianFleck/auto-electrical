package br.com.auto.electrical.model.enumeration;

public enum CarColorEnum {
    YELLOW("Amarelo"),
    RED("Vermelho"),
    GREEN("Verde"),
    BLUE("Azul"),
    GRAY("Cinza"),
    CYAN("Ciano"),
    BLACK("Preto");

    private final String label;

    CarColorEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
