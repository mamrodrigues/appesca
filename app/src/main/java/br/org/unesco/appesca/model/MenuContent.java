package br.org.unesco.appesca.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuContent {

    public static final List<ItemMenuLateral> ITEMS = new ArrayList<ItemMenuLateral>();
    public static final Map<Integer, ItemMenuLateral> ITEM_MAP = new HashMap<Integer, ItemMenuLateral>();


    static {
            addItem(new ItemMenuLateral(1, "Todos", "Exibindo toda a lista de formulários.",1)); //TODO
            addItem(new ItemMenuLateral(2, "Enviados", "Exibindo somente os formulários enviados.",2)); //TODO
            addItem(new ItemMenuLateral(3, "Não Enviados","Exibindo somente os formulários não enviados.",3)); //TODO
    }

    private static void addItem(ItemMenuLateral item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }
}
