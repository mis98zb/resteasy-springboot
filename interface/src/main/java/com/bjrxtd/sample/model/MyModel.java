package com.bjrxtd.sample.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class MyModel {
    @Schema(name = "姓名", description = "叫什么名字啊？")
    private String name;

    @Schema(name = "年龄", description = "贵庚啊？")
    private int age;
}
