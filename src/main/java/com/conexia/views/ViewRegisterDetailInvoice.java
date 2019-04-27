package com.conexia.views;


import com.conexia.controller.ControllerDetailInvoice;
import com.conexia.entity.DetailinvoicesEntity;
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
import java.util.List;

@UIScope
@SpringView(name = ViewRegisterDetailInvoice.VIEW_NAME)
public class ViewRegisterDetailInvoice extends VerticalLayout implements View {

    public static final String VIEW_NAME = "detailInvoice";

    @Autowired
    private ControllerDetailInvoice controllerDetailInvoice;
    //fields
    private MenuBar menuBar;
    //Layouts
    private VerticalLayout leftLayout = new VerticalLayout();
    private VerticalLayout rightLayout = new VerticalLayout();
    private HorizontalLayout principalLayout = new HorizontalLayout();
    private Panel principalPanel = new Panel("Consulta de detalle de factura");
    private HorizontalLayout menuLayout = new HorizontalLayout();
    private GridLayout fieldsLayout = new GridLayout(2, 5);
    private ListDataProvider<DetailinvoicesEntity> dataProvider;
    private ListDataProvider<DetailinvoicesEntity> dataProviderDetail;
    private Grid<DetailinvoicesEntity> grid = new Grid<>();
    private Grid<DetailinvoicesEntity> gridDetail = new Grid<>();
    private List<DetailinvoicesEntity> detailinvoicesEntities;
    private DetailinvoicesEntity detailinvoicesEntity;

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
        setLeftPanel();
        setRightPanel();
        createGrid();
        refreshInformationGrid();
        leftLayout.addComponent(grid);
        principalPanel.setSizeFull();
        principalPanel.setContent(principalLayout);
        this.addComponents(menuBar, principalPanel);
        this.setComponentAlignment(menuBar, Alignment.TOP_CENTER);
    }
    private void setLeftPanel() {
        principalLayout.setSizeFull();
        leftLayout.setSizeFull();
        principalLayout.addComponent(leftLayout);
    }


    private void setRightPanel() {
        rightLayout.setSizeFull();
        principalLayout.addComponent(rightLayout);
    }


    private void createGrid() {
        List<DetailinvoicesEntity> detailInvoicesEntities = controllerDetailInvoice.loadGroupByIdInvoice();
        dataProvider = DataProvider.ofCollection(detailInvoicesEntities);

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
        List<DetailinvoicesEntity> detailinvoicesEntityList = controllerDetailInvoice.selectByInvoice(detailinvoicesEntity.getIdinvoice());
        dataProviderDetail = DataProvider.ofCollection(detailinvoicesEntityList);
        gridDetail.removeAllColumns();
        gridDetail.addColumn(DetailinvoicesEntity::getIdinvoice).setCaption(EnumLabel.INVOICE_LABEL.getLabel());
        gridDetail.addColumn(DetailinvoicesEntity::getPlate).setCaption(EnumLabel.PLATE_LABEL.getLabel());
        gridDetail.addColumn(DetailinvoicesEntity::getImporte).setCaption(EnumLabel.AMOUNT_LABEL.getLabel());
        gridDetail.setDataProvider(dataProviderDetail);

    }

    private void refreshInformationGrid() {
        detailinvoicesEntities = controllerDetailInvoice.loadGroupByIdInvoice();
        dataProvider = DataProvider.ofCollection(detailinvoicesEntities);
        grid.setDataProvider(dataProvider);
    }

}
