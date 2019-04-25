package com.conexia.views;


import com.conexia.controller.ControllerCustomer;
import com.conexia.controller.ControllerInvoice;
import com.conexia.controller.ControllerTable;
import com.conexia.controller.ControllerWaiter;
import com.conexia.entity.CustomersEntity;
import com.conexia.entity.InvoicesEntity;
import com.conexia.entity.TablesEntity;
import com.conexia.entity.WaitersEntity;
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
import java.util.*;
import java.sql.Date;

@UIScope
@SpringView(name = ViewRegisterInvoice.VIEW_NAME)
public class ViewRegisterInvoice extends VerticalLayout implements View {

    public static final String VIEW_NAME = "invoice";

    @Autowired
    ControllerInvoice controllerInvoice;
    @Autowired
    ControllerCustomer controllerCustomer;
    @Autowired
    ControllerTable controllerTable;
    @Autowired
    ControllerWaiter controllerWaiter;
    //fields
    /*private TextField name = new TextField(EnumLabel.NAME_LABEL.getLabel());
    private TextField surname = new TextField(EnumLabel.SURNAME_LABEL.getLabel());
    private TextField lastname = new TextField(EnumLabel.LASTNAME_LABEL.getLabel());
    private TextField observations = new TextField(EnumLabel.OBSERVATION_LABEL.getLabel());*/
    private ComboBox<String> cmbTable = new ComboBox<>(EnumLabel.NUMBER_TABLE_LABEL.getLabel());
    private ComboBox<String> cmbCustomer = new ComboBox<>(EnumLabel.CUSTOMER_LABEL.getLabel());
    private ComboBox<String> cmbWaiter = new ComboBox<>(EnumLabel.WAITER_LABEL.getLabel());

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
    private Panel principalPanel = new Panel("Factura");
    private HorizontalLayout buttonsSecondaryLayout = new HorizontalLayout();
    private HorizontalLayout menuLayout = new HorizontalLayout();
    private HorizontalLayout buttonsPrincipalLayout = new HorizontalLayout();
    private GridLayout fieldsLayout = new GridLayout(2, 5);
    private ListDataProvider<InvoicesEntity> dataProvider;
    private Grid<InvoicesEntity> grid = new Grid<>();
    List<InvoicesEntity> collectionInvoice;
    private String action;
    private Collection<CustomersEntity> collectionsCustomer;
    private Collection<WaitersEntity> collectionsWaiter;
    private Collection<TablesEntity> collectionsTables;
    private Collection<InvoicesEntity> collectionsInvoice;
    private Collection<String> arrayTables = new ArrayList<>();
    private Collection<String> arrayWaiter = new ArrayList<>();
    private Collection<String> arrayCustomer = new ArrayList<>();
    private Label invoiceNumber = new Label();
    private InvoicesEntity invoiceSelected;


    public ViewRegisterInvoice() {
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

       /* name.setRequiredIndicatorVisible(true);
        surname.setRequiredIndicatorVisible(true);
        lastname.setRequiredIndicatorVisible(true);
        observations.setRequiredIndicatorVisible(true);*/
        cmbWaiter.setRequiredIndicatorVisible(true);
        cmbTable.setRequiredIndicatorVisible(true);
        cmbCustomer.setRequiredIndicatorVisible(true);

    }

    private void setLeftPanel() {
        principalLayout.setSizeFull();
        leftLayout.setSizeFull();
        principalLayout.addComponent(leftLayout);
    }


    private void setRightPanel() {

        rightLayout.setSizeFull();
        loadInformationCombox();
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
                    addInvoice();
                } else if (action.equalsIgnoreCase("edit")) {
                    updateFields();
                } else if (action.equalsIgnoreCase("delete")) {
                    deleteInvoice();
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

    private void deleteInvoice() {
//        controllerCustomer.delete(customerEntitySelect);
    }

    private void updateFields() {
/*        customerEntitySelect.setName(name.getValue());
        customerEntitySelect.setSurname(surname.getValue());
        customerEntitySelect.setLastname(lastname.getValue());
        customerEntitySelect.setObservations(observations.getValue());*/

//        controllerCustomer.update(customerEntitySelect);
    }

    private void addInvoice() {
        InvoicesEntity invoicesEntity = new InvoicesEntity();
        if (!isValidationAllField(EnumMessages.MESSAGE_REQUIRED_FIELD.getMessage())) {
            try {

                for (TablesEntity tablesEntity : collectionsTables) {
                    if (tablesEntity.getIdtable().toString().equalsIgnoreCase(cmbTable.getValue())) {
                        invoicesEntity.setIdtable(tablesEntity.getIdtable());
                        break;
                    }
                }
                for (CustomersEntity customersEntity : collectionsCustomer) {
                    if (customersEntity.getName().equalsIgnoreCase(cmbCustomer.getValue())) {
                        invoicesEntity.setIdcustomer(customersEntity.getIdcustomer());
                        break;
                    }
                }

                for (WaitersEntity waitersEntity : collectionsWaiter) {
                    if (waitersEntity.getName().equalsIgnoreCase(cmbWaiter.getValue())) {
                        invoicesEntity.setIdwaiter(waitersEntity.getIdwaiter());
                        break;
                    }
                }
                Date date = new Date(Calendar.getInstance().getTime().getTime());
                invoicesEntity.setInvoicedate(date);

                controllerInvoice.save(invoicesEntity);
                refreshInformationGrid();
                clearFields();
                showFields(false);

            } catch (Exception e) {
                Notification.show(EnumMessages.MESSAGES_ERROR_SAVE.getMessage(), Notification.Type.ERROR_MESSAGE);
            }
        }
    }

    private void showFields(boolean value) {

/*        surname.setVisible(value);
        lastname.setVisible(value);
        observations.setVisible(value);
        name.setVisible(value);*/
        cmbWaiter.setVisible(value);
        cmbCustomer.setVisible(value);
        cmbTable.setVisible(value);
        buttonsSecondaryLayout.setVisible(value);
    }

    private void clearAction() {
        action = "";
    }

    private void buildFields() {

        fieldsLayout.addComponents(cmbCustomer, cmbWaiter, cmbTable);
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

/*        surname.clear();
        lastname.clear();
        observations.clear();
        name.clear();*/
        cmbCustomer.clear();
        cmbTable.clear();
        cmbWaiter.clear();

    }

    private void enableFields(boolean value) {

/*        surname.setEnabled(value);
        lastname.setEnabled(value);
        observations.setEnabled(value);
        name.setEnabled(value);*/
        cmbCustomer.setEnabled(value);
        cmbTable.setEnabled(value);
        cmbWaiter.setEnabled(value);


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
        collectionsInvoice = controllerInvoice.findAllInvoce();
        dataProvider = DataProvider.ofCollection(collectionsInvoice);
        collectionsWaiter = controllerWaiter.findAllWaiter();
        collectionsCustomer = controllerCustomer.findAllCustomer();
        collectionsTables = controllerTable.findAllTables();
        grid.setSizeFull();
        grid.setEnabled(true);
        grid.addColumn(InvoicesEntity::getIdinvoice).setCaption(EnumLabel.INVOICE_LABEL.getLabel());
        grid.addColumn(InvoicesEntity::getIdtable).setCaption(EnumLabel.NUMBER_TABLE_LABEL.getLabel());
        grid.addColumn(InvoicesEntity::getIdcustomer).setCaption(EnumLabel.CUSTOMER_LABEL.getLabel());
        grid.addColumn(InvoicesEntity::getIdwaiter).setCaption(EnumLabel.WAITER_LABEL.getLabel());
        grid.addColumn(InvoicesEntity::getInvoicedate).setCaption(EnumLabel.DATE_LABEL.getLabel());
        grid.setDataProvider(dataProvider);
        grid.addItemClickListener(new ItemClickListener<InvoicesEntity>() {
            @Override
            public void itemClick(Grid.ItemClick<InvoicesEntity> event) {
                invoiceSelected = event.getItem();
                for (TablesEntity tablesEntity : collectionsTables) {
                    if (tablesEntity.getIdtable().toString().equalsIgnoreCase(cmbTable.getValue())) {
                        cmbTable.setSelectedItem(String.valueOf(tablesEntity.getIdtable()));
                        break;
                    }
                }
                for (CustomersEntity customersEntity : collectionsCustomer) {
                    if (customersEntity.getName().equalsIgnoreCase(cmbCustomer.getValue())) {
                        cmbCustomer.setSelectedItem(customersEntity.getName());
                        break;
                    }
                }

                for (WaitersEntity waitersEntity : collectionsWaiter) {
                    if (waitersEntity.getName().equalsIgnoreCase(cmbWaiter.getValue())) {
                        cmbWaiter.setSelectedItem(waitersEntity.getName());
                        break;
                    }

                }
            }


        });
    }


    private void visibleGridLayout(boolean visible) {
        fieldsLayout.setVisible(visible);

    }

    private void refreshInformationGrid() {
        collectionsInvoice = controllerInvoice.findAllInvoce();
        dataProvider = DataProvider.ofCollection(collectionsInvoice);
        grid.setDataProvider(dataProvider);

    }

    private void loadInformationCombox() {
        collectionsTables = controllerTable.findAllTables();
        collectionsWaiter = controllerWaiter.findAllWaiter();
        collectionsCustomer = controllerCustomer.findAllCustomer();
        for (TablesEntity tablesEntity : collectionsTables) {
            arrayTables.add(String.valueOf(tablesEntity.getIdtable()));
        }
        cmbTable.setItems(arrayTables);

        for (CustomersEntity customersEntity : collectionsCustomer) {

            arrayCustomer.add(customersEntity.getName());
        }
        cmbCustomer.setItems(arrayCustomer);
        for (WaitersEntity waitersEntity : collectionsWaiter) {

            arrayWaiter.add(waitersEntity.getName());
        }
        cmbWaiter.setItems(arrayWaiter);
    }


}
