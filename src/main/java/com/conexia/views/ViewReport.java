package com.conexia.views;


import com.conexia.controller.ControllerDetailInvoice;
import com.conexia.entity.CooksEntity;
import com.conexia.entity.WaitersEntity;
import com.conexia.enums.EnumLabel;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import com.vaadin.ui.components.grid.ItemClickListener;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
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
    private VerticalLayout detailOrders = new VerticalLayout();
    private HorizontalLayout menuLayout = new HorizontalLayout();
    private HorizontalLayout buttonsPrincipalLayout = new HorizontalLayout();
    private GridLayout fieldsLayout = new GridLayout(2, 5);
    private ListDataProvider<String> dataProvider;
    Grid<String> grid = new Grid<>();


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
        setLeftPanel();
        setRightPanel();
        createGrid();
        principalPanel.setSizeFull();
        principalPanel.setContent(principalLayout);
        this.addComponents(menuBar, principalPanel);
        this.setComponentAlignment(menuBar, Alignment.TOP_CENTER);
    }

    private void createGrid() {

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


    private void consultOne() {
        List resultList = controllerDetailInvoice.consultCustomerByAmount();
        ArrayList<String> listDetail= new ArrayList<>();
        Iterator iterator = resultList.iterator();
        detailOrders.removeAllComponents();
        while (iterator.hasNext()) {
            Object[] o = (Object[]) iterator.next();
            Label result = new Label("EL cliente " + o[0] + " ha gastado " + o[1]);
            detailOrders.addComponent(result);
        }
//        createGrid(listDetail);
//        buttonsSecondaryLayout.addComponent(grid);
        buttonsSecondaryLayout.addComponent(detailOrders);
        buttonsSecondaryLayout.setVisible(true);
    }

    private void createGrid(List details) {
        dataProvider = DataProvider.ofCollection(details);
        grid.setEnabled(true);
//        grid.addColumn("Detail");
        grid.setCaption("Detail");
        grid.setDataProvider(dataProvider);
    }

    private void buildButtons() {

        btnConsultOne.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {

                consultOne();
            }
        });

        buttonsPrincipalLayout.addComponents(btnConsultOne);
        leftLayout.addComponent(buttonsPrincipalLayout);
    }

}
