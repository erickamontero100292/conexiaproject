package com.conexia.enums;

public enum EnumLabel {
    REGISTRAR_LABEL("Registrar"),
    EDITAR_LABEL("Editar"),
    ELIMINAR_LABEL("Eliminar"),
    ACEPTAR_LABEL("Aceptar"),
    CANCELAR_LABEL("Cancelar"),
    NUMBER_TABLE_LABEL("Numero de mesa"),
    MAX_COMENSALES_LABEL("Maximo de comensales"),
    LOCATION_LABEL("Locacion");

    EnumLabel(String label) {
        this.label = label;
    }

    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
