package com.yas.media.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void hasText_voiInputLaNull_traVeFalse() {
        // Trường hợp 1: Truyền vào null -> Phải trả về false
        assertFalse(StringUtils.hasText(null));
    }

    @Test
    void hasText_voiInputRong_traVeFalse() {
        // Trường hợp 2: Truyền vào chuỗi rỗng "" -> Phải trả về false
        assertFalse(StringUtils.hasText(""));
    }

    @Test
    void hasText_voiInputToanDauCach_traVeFalse() {
        // Trường hợp 3: Truyền vào toàn dấu cách "   " -> Phải trả về false
        assertFalse(StringUtils.hasText("   "));
    }

    @Test
    void hasText_voiInputChuan_traVeTrue() {
        // Trường hợp 4: Truyền vào chữ bình thường -> Phải trả về true
        assertTrue(StringUtils.hasText("yas"));
    }

    @Test
    void hasText_voiInputCoChuaDauCach_traVeTrue() {
        // Trường hợp 5: Truyền vào chữ có dấu cách ở hai đầu -> Phải trả về true
        assertTrue(StringUtils.hasText("  yas media  "));
    }
}