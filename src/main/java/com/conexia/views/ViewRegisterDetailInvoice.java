package com.conexia.views;


import com.conexia.controller.ControllerDetailInvoice;
import com.conexia.entity.DetailinvoicesEntity;
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
@SpringView(name = ViewRegisterDetailInvoice.VIEW_NAME)
public class ViewRegisterDetailInvoice extends VerticalLayout implements View {

    public static final String VIEW_NAME = "detailInvoice";

    @Autowired
    ControllerDetailInvoice controllerDetailInvoice;
    //fields
    private MenuBar menuBar;
    //Layouts
    private VerticalLayout leftLayout = new VerticalLayout();
    private VerticalLayout rightLayout = new VerticalLayout();
    private HorizontalLayout principalLayout = new HorizontalLayout();
    private Panel principalPanel = new Panel("Consulta de detalle de factura");
    private HorizontalLayout buttonsSecondaryLayout = new HorizontalLayout();
    private HorizontalLayout menuLayout = new HorizontalLayout();
    private HorizontalLayout buttonsPrincipalLayout = new HorizontalLayout();
    private GridLayout fieldsLayout = new GridLayout(2, 5);
    private ListDataProvider<DetailinvoicesEntity> dataProvider;
    private ListDataProvider<DetailinvoicesEntity> dataProviderDetail;
    private Grid<DetailinvoicesEntity> grid = new Grid<>();
    private Grid<DetailinvoicesEntity> gridDetail = new Grid<>();
    private Grid<DetailinvoicesEntity> detailinvoicesEntityGrid = new Grid<>();
    List<DetailinvoicesEntity> detailinvoicesEntities;
    private DetailinvoicesEntity detailinvoicesEntity;
    private String action;

    public ViewRegisterDetailInvoice() {
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
        refreshInformationGrid();
        leftLayout.addComponent(grid);
        showFields(false);
        principalPanel.setSizeFull();
        principalPanel.setContent(principalLayout);
        this.addComponents(menuBar, principalPanel);
        this.setComponentAlignment(menuBar, Alignment.TOP_CENTER);
    }


    private void setPropertiesField() {

        /*name.setRequiredIndicatorVisible(true);
        surname.setRequiredIndicatorVisible(true);
        lastname.setRequiredIndicatorVisible(true);*/

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
     /*   btnCancel.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                clearFields();
                showFields(false);

            }
        });*/
      /*  btnAccept.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                if (action.equalsIgnoreCase("new")) {
                    addCook();
                } else if (action.equalsIgnoreCase("edit")) {
                    updateFields();
                } else if (action.equalsIgnoreCase("delete")) {
                    deleteCook();
                }
                clearFields();
                clearAction();
                showFields(false);
                refreshInformationGrid();
            }

        });*/

//        buttonsSecondaryLayout.addComponents(btnCancel, btnAccept);
        rightLayout.addComponent(buttonsSecondaryLayout);
    }

    private void deleteCook() {
//        controllerDetailInvoice.delete(detailinvoicesEntity);
    }

    private void updateFields() {
        /*detailinvoicesEntity.setName(name.getValue());
        detailinvoicesEntity.setSurname(surname.getValue());
        detailinvoicesEntity.setLastname(lastname.getValue());
*/
//        controllerDetailInvoice.update(detailinvoicesEntity);
    }

    private void addCook() {
       /* DetailinvoicesEntity entity = new DetailinvoicesEntity();
        entity.setSurname(surname.getValue());
        entity.setLastname(lastname.getValue());
        entity.setName(name.getValue());

        controllerDetailInvoice.save(entity);*/
    }

    private void showFields(boolean value) {

        /*surname.setVisible(value);
        lastname.setVisible(value);
        name.setVisible(value);
        buttonsSecondaryLayout.setVisible(value);*/
    }

    private void clearAction() {
        action = "";
    }

    private void buildFields() {

//        fieldsLayout.addComponents(name, surname,lastname);
        rightLayout.addComponent(fieldsLayout);
    }

    private void buildButtons() {

      /*  btnNew.addClickListener(new Button.ClickListener() {
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
        rightLayout.addComponent(buttonsPrincipalLayout);*/
    }

    private void clearFields() {

     /*   surname.clear();
        lastname.clear();
        name.clear();
*/
    }

    private void enableFields(boolean value) {

       /* surname.setEnabled(value);
        lastname.setEnabled(value);
        name.setEnabled(value);
*/

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
        List<DetailinvoicesEntity> detailinvoicesEntities = controllerDetailInvoice.loadGroupByIdInvoice();
        dataProvider = DataProvider.ofCollection(detailinvoicesEntities);

        grid.setEnabled(true);
        grid.addColumn(DetailinvoicesEntity::getIdinvoice).setCaption(EnumLabel.INVOICE_LABEL.getLabel());
        grid.setDataProvider(dataProvider);
        grid.addItemClickListener(new ItemClickListener<DetailinvoicesEntity>() {
            @Override
            public void itemClick(Grid.ItemClick<DetailinvoicesEntity> event) {
                detailinvoicesEntity = event.getItem();
                createGridDetail(detailinvoicesEntity);
                rightLayout.addComponent(gridDetail);

            }
        });
    }

    private void createGridDetail( DetailinvoicesEntity detailinvoicesEntity) {

        List<DetailinvoicesEntity> detailinvoicesEntities = controllerDetailInvoice.selectByInvoice(detailinvoicesEntity.getIdinvoice());
        dataProviderDetail = DataProvider.ofCollection(detailinvoicesEntities);

//        gridDetail.setEnabled(false);
        gridDetail.removeAllColumns();
        gridDetail.addColumn(DetailinvoicesEntity::getIdinvoice).setCaption(EnumLabel.INVOICE_LABEL.getLabel());
        gridDetail.addColumn(DetailinvoicesEntity::getPlate).setCaption(EnumLabel.PLATE_LABEL.getLabel());
        gridDetail.addColumn(DetailinvoicesEntity::getImporte).setCaption(EnumLabel.AMOUNT_LABEL.getLabel());
        gridDetail.setDataProvider(dataProviderDetail);

    }



    private void visibleGridLayout(boolean visible) {
        fieldsLayout.setVisible(visible);

    }

    private void refreshInformationGrid() {
        detailinvoicesEntities = controllerDetailInvoice.loadGroupByIdInvoice();
        dataProvider = DataProvider.ofCollection(detailinvoicesEntities);
        grid.setDataProvider(dataProvider);

    }

}
