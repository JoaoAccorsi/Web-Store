package com.webstore.orderservice.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Table(name = "table_order_line_items")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stockKeepingUnitCode;
    private String price;
    private Integer quantity;

    @Override
    public String toString() {
        return "OrderLineItems{" +
                "id=" + id +
                ", skuCode='" + stockKeepingUnitCode + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}