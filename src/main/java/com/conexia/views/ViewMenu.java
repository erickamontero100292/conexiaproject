package com.conexia.views;

import com.conexia.navigator.UniverseNavigator;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Image;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;

@UIScope

@Title("Menu")
@SpringView(name = ViewMenu.VIEW_NAME, ui = ViewLogin.class)
public class ViewMenu extends VerticalLayout implements View {
    public static final String VIEW_NAME = "menu";
    MenuBar mainMenu;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        if (mainMenu == null) {
            mainMenu = buildMenu();
            addComponent(mainMenu);
        } else {
            addComponent(mainMenu);
        }
        this.setWidth("100%");
        this.setHeightUndefined();
        ExternalResource externalResource = new ExternalResource("VAADIN/img/menu.jpeg");
        Image image = new Image();
        image.setSource(externalResource);
        //image.setResponsive(true);
        image.setWidth("100%");
        image.setHeight("80%");
        addComponent(image);
        this.setComponentAlignment(mainMenu, Alignment.TOP_CENTER);
    }
    public static MenuBar buildMenu() {
        MenuBar mainMenu = new MenuBar();

        // A top-level menu item that opens a submenu
        MenuBar.MenuItem tablesMaintenance = mainMenu.addItem("Mesas", null, null);
        // Submenu item with a sub-submenu
        MenuBar.MenuItem menuItemTables = tablesMaintenance.addItem("Mantenimiento de mesas", null, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                UniverseNavigator.navigate(ViewRegisterTable.VIEW_NAME);
            }
        });
        MenuBar.MenuItem cookMaintenance = mainMenu.addItem("Cocineros", null, null);
        // Submenu item with a sub-submenu
        MenuBar.MenuItem menuItemCooks = cookMaintenance.addItem("Mantenimiento de cocineros", null, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                UniverseNavigator.navigate(ViewRegisterCook.VIEW_NAME);
            }
        });

        MenuBar.MenuItem waiterMaintenance = mainMenu.addItem("Mesoneros", null, null);
        // Submenu item with a sub-submenu
        MenuBar.MenuItem menuItemWaiters = waiterMaintenance.addItem("Mantenimiento de mesoneros", null, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                UniverseNavigator.navigate(ViewRegisterWaiter.VIEW_NAME);
            }
        });

        MenuBar.MenuItem customerMaintenance = mainMenu.addItem("Clientes", null, null);
        // Submenu item with a sub-submenu
        MenuBar.MenuItem menuItemCustomer = customerMaintenance.addItem("Mantenimiento de clientes", null, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                UniverseNavigator.navigate(ViewRegisterCustomer.VIEW_NAME);
            }
        });

        MenuBar.MenuItem invoiceMaintenance = mainMenu.addItem("Factura", null, null);
        // Submenu item with a sub-submenu
        MenuBar.MenuItem menuItemInvoice = invoiceMaintenance.addItem("Crear facturas", null, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                UniverseNavigator.navigate(ViewRegisterInvoice.VIEW_NAME);
            }
        });

        MenuBar.MenuItem detailMaintenance = mainMenu.addItem("Detalle de Factura", null, null);
        // Submenu item with a sub-submenu
        MenuBar.MenuItem menuItemdetailInvoice = detailMaintenance.addItem("Ver detalle", null, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                UniverseNavigator.navigate(ViewRegisterDetailInvoice.VIEW_NAME);
            }
        });




        return mainMenu;
    }





}
