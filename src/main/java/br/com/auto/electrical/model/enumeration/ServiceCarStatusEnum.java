package br.com.auto.electrical.model.enumeration;

public enum ServiceCarStatusEnum {
    OPEN("Aberto"), FINISHED("Finalizado"), CANCELED("Cancelado");

    private final String label;

    ServiceCarStatusEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
