package com.j6d3.bean;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student2 {
    @NotBlank(message = "không để trống email")
    @Email(message = "không đúng định dạng email")
    String email;

    @NotBlank(message = "Không để trống họ và tên")
    String fullname;

    @NotNull(message = "không để trống điểm")
    @PositiveOrZero(message = "điểm phải lớn hơn hoặc bằng 0")
    @Max(value = 10, message = "Điểm phải nhỏ hơn bằng 10")
    Double marks;

    @NotNull(message = "Chọn giới tính")
    Boolean gender;

    @NotBlank(message = "Chọn quốc tích")
    String country;
}
