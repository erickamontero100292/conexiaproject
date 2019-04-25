package com.conexia.views;


import com.conexia.controller.ControllerCustomer;
import com.conexia.entity.CustomersEntity;
import com.conexia.enums.EnumLabel;
import com.conexia.enums.EnumMessages;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import com.vaadin.ui.components.grid.ItemClickListener;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

@UIScope
@SpringView(name = ViewRegisterCustomer.VIEW_NAME)
public class ViewRegisterCustomer extends VerticalLayout implements View {

    public static final String VIEW_NAME = "customer";

    @Autowired
    ControllerCustomer controllerCustomer;
    //fields
    private TextField name = new TextField(EnumLabel.NAME_LABEL.getLabel());
    private TextField surname = new TextField(EnumLabel.SURNAME_LABEL.getLabel());
    private TextField lastname = new TextField(EnumLabel.LASTNAME_LABEL.getLabel());
    private TextField observations = new TextField(EnumLabel.OBSERVATION_LABEL.getLabel());

    //Buttons
    private Button btnNew = new Button(EnumLabel.REGISTRAR_LABEL.getLabel());
    private Button btnAccept = new Button(EnumLabel.ACEPTAR_LABEL.getLabel());
    private Button btnEdit = new Button(EnumLabel.EDITAR_LABEL.getLabel());
    private Button btnDelete = new Button(EnumLabel.ELIMINAR_LABEL.getLabel());
    private Button btnCancel = new Button(EnumLabel.CANCELAR_LABEL.getLabel());
    private MenuBar menuBar;
    //Layouts
    private VerticalLayout leftLayout = new VerticalLayout();
    private VerticalLayout rightLayout = new VerticalLayout();
    private HorizontalLayout principalLayout = new HorizontalLayout();
    private Panel principalPanel = new Panel("Mantenimiento de cliente");
    private HorizontalLayout buttonsSecondaryLayout = new HorizontalLayout();
    private HorizontalLayout menuLayout = new HorizontalLayout();
    private HorizontalLayout buttonsPrincipalLayout = new HorizontalLayout();
    private GridLayout fieldsLayout = new GridLayout(2, 5);
    private ListDataProvider<CustomersEntity> dataProvider;
    private Grid<CustomersEntity> grid = new Grid<>();
    List<CustomersEntity> collectionTables;
    private CustomersEntity customerEntitySelect;
    private String action;

    public ViewRegisterCustomer() {
    }

    @PostConstruct
    private void buildForm() {
        this.setWidth("100%");
        this.setHeightUndefined();
        if (menuBar == null)
            menuBar = ViewMenu.buildMenu();
        menuLayout.addComponent(menuBar);
        fieldsLayout.setSpacing(true);
        setPropertiesField();
        setLeftPanel();
        setRightPanel();
        createGrid();
        leftLayout.addComponent(grid);
        showFields(false);
        principalPanel.setSizeFull();
        principalPanel.setContent(principalLayout);
        this.addComponents(menuBar, principalPanel);
        this.setComponentAlignment(menuBar, Alignment.TOP_CENTER);
    }


    private void setPropertiesField() {

        name.setRequiredIndicatorVisible(true);
        surname.setRequiredIndicatorVisible(true);
        lastname.setRequiredIndicatorVisible(true);
        observations.setRequiredIndicatorVisible(true);

    }

    private void setLeftPanel() {
        principalLayout.setSizeFull();
        leftLayout.setSizeFull();
        principalLayout.addComponent(leftLayout);
    }


    private void setRightPanel() {

        rightLayout.setSizeFull();
        buildButtons();
        buildFields();
        buildButtonsFooter();
        principalLayout.addComponent(rightLayout);

    }

    private void buildButtonsFooter() {
        btnCancel.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                clearFields();
                showFields(false);

            }
        });
        btnAccept.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                if (action.equalsIgnoreCase("new")) {
                    addCustomer();
                } else if (action.equalsIgnoreCase("edit")) {
                    updateFields();
                } else if (action.equalsIgnoreCase("delete")) {
                    deleteCustomer();
                }
                clearFields();
                clearAction();
                showFields(false);
                refreshInformationGrid();
            }

        });

        buttonsSecondaryLayout.addComponents(btnCancel, btnAccept);
        rightLayout.addComponent(buttonsSecondaryLayout);
    }

    private void deleteCustomer() {
        controllerCustomer.delete(customerEntitySelect);
    }

    private void updateFields() {
        customerEntitySelect.setName(name.getValue());
        customerEntitySelect.setSurname(surname.getValue());
        customerEntitySelect.setLastname(lastname.getValue());
        customerEntitySelect.setObservations(observations.getValue());

        controllerCustomer.update(customerEntitySelect);
    }

    private void addCustomer() {
        CustomersEntity entity = new CustomersEntity();
        entity.setSurname(surname.getValue());
        entity.setLastname(lastname.getValue());
        entity.setObservations(observations.getValue());
        entity.setName(name.getValue());

        controllerCustomer.save(entity);
    }

    private void showFields(boolean value) {

        surname.setVisible(value);
        lastname.setVisible(value);
        observations.setVisible(value);
        name.setVisible(value);
        buttonsSecondaryLayout.setVisible(value);
    }

    private void clearAction() {
        action = "";
    }

    private void buildFields() {

        fieldsLayout.addComponents(name, surname,lastname,observations);
        rightLayout.addComponent(fieldsLayout);
    }

    private void buildButtons() {

        btnNew.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                clearFields();
                showFields(true);
                action = "new";
            }
        });
        btnEdit.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                if (!isValidationAllField(EnumMessages.SELECT_REGISTER.getMessage())) {
                    action = "edit";
                    showFields(true);
                }
            }
        });
        btnDelete.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                if (!isValidationAllField(EnumMessages.SELECT_REGISTER.getMessage())) {
                    action = "delete";
                    showFields(true);
                    enableFields(false);
                }
            }
        });
        buttonsPrincipalLayout.addComponents(btnNew, btnEdit, btnDelete);
        rightLayout.addComponent(buttonsPrincipalLayout);
    }

    private void clearFields() {

        surname.clear();
        lastname.clear();
        observations.clear();
        name.clear();

    }

    private void enableFields(boolean value) {

        surname.setEnabled(value);
        lastname.setEnabled(value);
        observations.setEnabled(value);
        name.setEnabled(value);


    }

    private void processDeleteUser() {

        try {
            Notification.show(EnumMessages.MESSAGE_SUCESS_DELETE.getMessage(), Notification.Type.HUMANIZED_MESSAGE);
            clearFields();
            enableFields(true);
        } catch (Exception e) {
            Notification.show(EnumMessages.MESSAGES_ERROR_SAVE.getMessage(), Notification.Type.ERROR_MESSAGE);
        }
    }

    private boolean isValidationAllField(String message) {

        return false;
    }

    private boolean isValidationFieldEmpty(TextField textField) {
        boolean validation = false;
        if (textField.getValue().isEmpty()) {

            validation = true;
        }
        return validation;
    }

    private void hideFields() {
        visibleGridLayout(false);
    }

    private void createGrid() {
        List<CustomersEntity> collectionCustomer = controllerCustomer.findAllCustomer();
        dataProvider = DataProvider.ofCollection(collectionCustomer);

        grid.setEnabled(true);
        grid.addColumn(CustomersEntity::getIdcustomer).setCaption(EnumLabel.NUMBER_CUSTOMER_LABEL.getLabel());
        grid.addColumn(CustomersEntity::getName).setCaption(EnumLabel.NAME_LABEL.getLabel());
        grid.addColumn(CustomersEntity::getSurname).setCaption(EnumLabel.SURNAME_LABEL.getLabel());
        grid.addColumn(CustomersEntity::getLastname).setCaption(EnumLabel.LASTNAME_LABEL.getLabel());
        grid.addColumn(CustomersEntity::getObservations).setCaption(EnumLabel.OBSERVATION_LABEL.getLabel());
        grid.setDataProvider(dataProvider);
        grid.addItemClickListener(new ItemClickListener<CustomersEntity>() {
            @Override
            public void itemClick(Grid.ItemClick<CustomersEntity> event) {
                customerEntitySelect = event.getItem();
                surname.setValue(customerEntitySelect.getSurname());
                lastname.setValue(customerEntitySelect.getLastname());
                observations.setValue(customerEntitySelect.getObservations() == null ? "" : customerEntitySelect.getObservations());
                name.setValue(customerEntitySelect.getName());


            }
        });
    }


    private void visibleGridLayout(boolean visible) {
        fieldsLayout.setVisible(visible);

    }

    private void refreshInformationGrid() {
        collectionTables = controllerCustomer.findAllCustomer();
        dataProvider = DataProvider.ofCollection(collectionTables);
        grid.setDataProvider(dataProvider);

    }

}
