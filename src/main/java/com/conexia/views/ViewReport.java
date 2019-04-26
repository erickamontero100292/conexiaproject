package com.conexia.views;


import com.conexia.controller.ControllerDetailInvoice;
import com.conexia.entity.CooksEntity;
import com.conexia.enums.EnumLabel;
import com.conexia.enums.EnumMessages;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.List;

@UIScope
@SpringView(name = ViewReport.VIEW_NAME)
public class ViewReport extends VerticalLayout implements View {

    public static final String VIEW_NAME = "report";

    @Autowired
    ControllerDetailInvoice controllerDetailInvoice;


    //Buttons
    private Button btnConsultOne = new Button(EnumLabel.CONSULT_1.getLabel());
    private MenuBar menuBar;
    //Layouts
    private VerticalLayout leftLayout = new VerticalLayout();
    private VerticalLayout rightLayout = new VerticalLayout();
    private HorizontalLayout principalLayout = new HorizontalLayout();
    private Panel principalPanel = new Panel("Reportes");
    private HorizontalLayout buttonsSecondaryLayout = new HorizontalLayout();
    private HorizontalLayout menuLayout = new HorizontalLayout();
    private HorizontalLayout buttonsPrincipalLayout = new HorizontalLayout();
    private GridLayout fieldsLayout = new GridLayout(2, 5);
    private ListDataProvider<CooksEntity> dataProvider;


    public ViewReport() {
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
//        createGrid();
//        showFields(false);
        principalPanel.setSizeFull();
        principalPanel.setContent(principalLayout);
        this.addComponents(menuBar, principalPanel);
        this.setComponentAlignment(menuBar, Alignment.TOP_CENTER);
    }


    private void setPropertiesField() {



    }

    private void setLeftPanel() {
        principalLayout.setSizeFull();
        leftLayout.setSizeFull();
        buildButtons();
        principalLayout.addComponent(leftLayout);
    }


    private void setRightPanel() {

        rightLayout.setSizeFull();

        buildButtonsConsult();
        principalLayout.addComponent(rightLayout);

    }

    private void buildButtonsConsult() {

        rightLayout.addComponent(buttonsSecondaryLayout);
    }



    private void consultOne( ) {
        List resultList= controllerDetailInvoice.consultCustomerByAmount();
        Iterator iterator = resultList.iterator();
        while (iterator.hasNext()){
            Object[] o =  (Object[])iterator.next();
            Label label = new Label("EL cliente "+o[0] + " ha gastado " + o[1]);
            buttonsSecondaryLayout.addComponents(label);
        }
        buttonsSecondaryLayout.setVisible(true);
    }



    private void buildFields() {


        rightLayout.addComponent(fieldsLayout);
    }

    private void buildButtons() {

        btnConsultOne.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {

                consultOne( );
            }
        });

        buttonsPrincipalLayout.addComponents(btnConsultOne);
        leftLayout.addComponent(buttonsPrincipalLayout);
    }

    private void clearFields() {



    }

    private void enableFields(boolean value) {




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

    }


    private void visibleGridLayout(boolean visible) {
        fieldsLayout.setVisible(visible);

    }

    private void refreshInformationGrid() {


    }

}
