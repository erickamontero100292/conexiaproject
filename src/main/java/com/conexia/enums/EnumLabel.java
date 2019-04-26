package com.conexia.enums;

public enum EnumLabel {
    REGISTRAR_LABEL("Registrar"),
    EDITAR_LABEL("Editar"),
    ELIMINAR_LABEL("Eliminar"),
    ACEPTAR_LABEL("Aceptar"),
    CANCELAR_LABEL("Cancelar"),
    NUMBER_TABLE_LABEL("Numero de mesa"),
    NUMBER_COOK_LABEL("Numero de cocinero"),
    NUMBER_WAITER_LABEL("Numero de mesonero"),
    NUMBER_CUSTOMER_LABEL("Numero de cliente"),
    MAX_COMENSALES_LABEL("Maximo de comensales"),
    NAME_LABEL ("Nombres"),
    SURNAME_LABEL ("Apellido"),
    LASTNAME_LABEL ("Apellido"),
    OBSERVATION_LABEL ("Observaciones"),
    LOCATION_LABEL("Locacion"),
    WAITER_LABEL("Mesonero"),
    COOK_LABEL("Cocinero"),
    CUSTOMER_LABEL("Cliente"),
    INVOICE_LABEL("Factura"),
    DATE_LABEL("Fecha"),
    ADD_DETAIL_LABEL("Agregar detalle"),
    PLATE_LABEL("Plato"),
    AMOUNT_LABEL("Importe");

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
