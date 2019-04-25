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
        MenuBar.MenuItem mantenimientoEventos = mainMenu.addItem("Mesas", null, null);
        // Submenu item with a sub-submenu
        MenuBar.MenuItem registrarEventos = mantenimientoEventos.addItem("Mantenimiento de mesas", null, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                UniverseNavigator.navigate(ViewRegisterTable.VIEW_NAME);
            }
        });
        return mainMenu;
    }





}
