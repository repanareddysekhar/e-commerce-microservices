package com.repana.orderservice.service;

import com.repana.orderservice.entity.OrderDetail;
import com.repana.orderservice.entity.OrderItem;
import com.repana.orderservice.repository.OrderDetailRepository;
import com.repana.orderservice.repository.OrderItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderDetailRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderDetail createOrUpdateOrder(OrderDetail order) {
        Optional<OrderDetail> orderOp;
        if (!ObjectUtils.isEmpty(order.getId())) {
            orderOp = orderRepository.findByIdAndIsDeleted(order.getId(), false);
            if (orderOp.isPresent()) {
                return updateOrder(orderOp.get(), order);
            }
        }
        return saveOrder(order);
    }

    private OrderDetail saveOrder(OrderDetail order) {
        return orderRepository.save(order);
    }

    private OrderDetail updateOrder(OrderDetail oldOrderDetail, OrderDetail order) {
        // Change only totalPrice
        if (!Objects.equals(oldOrderDetail.getTotalPrice(), order.getTotalPrice())) {
            oldOrderDetail.setTotalPrice(order.getTotalPrice());
            return saveOrder(oldOrderDetail); // Save and return the updated order
        }
        return oldOrderDetail;
    }

    public OrderItem createOrUpdateOrderItem(OrderItem orderItem) {
        Optional<OrderItem> orderItemOp;
        if (!ObjectUtils.isEmpty(orderItem.getId())) {
            orderItemOp = orderItemRepository.findByIdAndIsDeleted(orderItem.getId(), false);
            if (orderItemOp.isPresent()) {
                return updateOrderItem(orderItemOp.get(), orderItem);
            }
        }
        return saveOrderItem(orderItem);
    }

    private OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    private OrderItem updateOrderItem(OrderItem oldOrderItem, OrderItem orderItem) {
        if (!Objects.equals(oldOrderItem.getQuantity(), orderItem.getQuantity())) {
            oldOrderItem.setQuantity(orderItem.getQuantity());
            return orderItemRepository.save(oldOrderItem);
        }
        return oldOrderItem;
    }

    public List<OrderItem> createOrUpdateOrderItems(List<OrderItem> orderItems) {
        List<OrderItem> updatedOrderItems = new ArrayList<>();

        orderItems.forEach(orderItem -> {
            OrderItem oldOrderItem = createOrUpdateOrderItem(orderItem);
            updatedOrderItems.add(oldOrderItem);
        });

        return updatedOrderItems;
    }
}
