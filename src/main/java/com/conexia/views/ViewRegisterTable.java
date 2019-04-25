package com.conexia.views;


import com.conexia.controller.ControllerTable;
import com.conexia.entity.TablesEntity;
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
@SpringView(name = ViewRegisterTable.VIEW_NAME)
public class ViewRegisterTable extends VerticalLayout implements View {

    public static final String VIEW_NAME = "tables";

    @Autowired
    ControllerTable controllerTable;
    //fields
    private TextField maxDinners = new TextField(EnumLabel.MAX_COMENSALES_LABEL.getLabel());
    private TextField location = new TextField(EnumLabel.LOCATION_LABEL.getLabel());

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
    private Panel principalPanel = new Panel("Mantenimiento de mesas");
    private HorizontalLayout buttonsSecondaryLayout = new HorizontalLayout();
    private HorizontalLayout menuLayout = new HorizontalLayout();
    private HorizontalLayout buttonsPrincipalLayout = new HorizontalLayout();
    private GridLayout fieldsLayout = new GridLayout(2, 5);
    private ListDataProvider<TablesEntity> dataProvider;
    private Grid<TablesEntity> grid = new Grid<>();
    List<TablesEntity> collectionTables;
    private TablesEntity tablesEntitySelect;
    private String action;

    public ViewRegisterTable() {
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

        maxDinners.setRequiredIndicatorVisible(true);
        location.setRequiredIndicatorVisible(true);

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
                    addTable();
                } else if (action.equalsIgnoreCase("edit")) {
                    updateFields();
                } else if (action.equalsIgnoreCase("delete")) {
                    deleteTable();
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

    private void deleteTable() {
        controllerTable.delete(tablesEntitySelect);
    }

    private void updateFields() {
        tablesEntitySelect.setMaxdiners(Integer.valueOf(maxDinners.getValue()));
        tablesEntitySelect.setLocation(location.getValue());

        controllerTable.update(tablesEntitySelect);
    }

    private void addTable() {
        TablesEntity entity = new TablesEntity();
        entity.setLocation(location.getValue());
        entity.setMaxdiners(Integer.valueOf(maxDinners.getValue()));

        controllerTable.save(entity);
    }

    private void showFields(boolean value) {

        location.setVisible(value);
        maxDinners.setVisible(value);
        buttonsSecondaryLayout.setVisible(value);
    }

    private void clearAction() {
        action = "";
    }

    private void buildFields() {

        fieldsLayout.addComponents(maxDinners, location);
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

        location.clear();
        maxDinners.clear();

    }

    private void enableFields(boolean value) {

        location.setEnabled(value);
        maxDinners.setEnabled(value);


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
        List<TablesEntity> collectionTable = controllerTable.findAllTables();
        dataProvider = DataProvider.ofCollection(collectionTable);

        grid.setEnabled(true);
        grid.addColumn(TablesEntity::getIdtable).setCaption(EnumLabel.NUMBER_TABLE_LABEL.getLabel());
        grid.addColumn(TablesEntity::getLocation).setCaption(EnumLabel.LOCATION_LABEL.getLabel());
        grid.addColumn(TablesEntity::getMaxdiners).setCaption(EnumLabel.MAX_COMENSALES_LABEL.getLabel());
        grid.setDataProvider(dataProvider);
        grid.addItemClickListener(new ItemClickListener<TablesEntity>() {
            @Override
            public void itemClick(Grid.ItemClick<TablesEntity> event) {
                tablesEntitySelect = event.getItem();
                location.setValue(tablesEntitySelect.getLocation());
                maxDinners.setValue(String.valueOf(tablesEntitySelect.getMaxdiners()));


            }
        });
    }


    private void visibleGridLayout(boolean visible) {
        fieldsLayout.setVisible(visible);

    }

    private void refreshInformationGrid() {
        collectionTables = controllerTable.findAllTables();
        dataProvider = DataProvider.ofCollection(collectionTables);
        grid.setDataProvider(dataProvider);

    }

}
