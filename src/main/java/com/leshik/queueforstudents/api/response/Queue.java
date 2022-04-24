package com.leshik.queueforstudents.api.response;

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
