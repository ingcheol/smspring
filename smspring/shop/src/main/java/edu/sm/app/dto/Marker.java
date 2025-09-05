package edu.sm.app.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Marker {
    int target;
    String title;
    String img;
    double lat;
    double lng;
    String loc;
    String info;
    double distance;
}