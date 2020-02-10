package be.hogent.eindproject.controller.DTO.mappers;

import be.hogent.eindproject.controller.DTO.TableDTO;
import be.hogent.eindproject.controller.DTO.WaiterDTO;
import be.hogent.eindproject.model.model.Table;

public class TableMapper {
    public static TableDTO mapToDTO(Table table) {
        TableDTO tableDTO = new TableDTO();
        tableDTO.setTableNumber(table.getTableNumber());
        tableDTO.setOrders(table.hasOrders());
        tableDTO.setWaiterDTO(getWaiterDtoFromOrdersOnTable(table));
        return tableDTO;
    }

    private static WaiterDTO getWaiterDtoFromOrdersOnTable(Table table) {
        WaiterDTO waiterDTO = null;
        if (table.hasOrders()) {
            waiterDTO = WaiterMapper.mapToWaiterDTO(table.getOpenOrders().get(0).getWaiter());
        }
        return waiterDTO;
    }
}
