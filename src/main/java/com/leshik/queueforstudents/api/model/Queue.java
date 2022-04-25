package com.leshik.queueforstudents.api.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Queue {
    private Long ordering;
    private String userName;
}
