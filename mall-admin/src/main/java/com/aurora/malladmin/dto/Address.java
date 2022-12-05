package com.aurora.malladmin.dto;

import lombok.Data;

@Data
public class Address {
    private Long id;
    private String recipient_name;
    private String phone_number;
    private String detailed_address;
    private String default_shipping_address;
}
