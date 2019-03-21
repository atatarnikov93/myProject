package ru.ocrv.testtask.myProject.domain;

import lombok.Data;

// аннотация от ломбок, генерирует геттеры и сеттеры, плагин для intellij IDEA ставится отдельно
@Data
public class Parser {
    private String id_sample;
    private String num_id;
    private String id_location;
    private String id_signal_par;
    private String id_detected;
    private String id_class_det;
}
