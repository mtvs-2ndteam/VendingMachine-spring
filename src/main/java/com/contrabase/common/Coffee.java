package com.contrabase.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Coffee {
    private int sequence;
    private String name;
    private int price;
}
