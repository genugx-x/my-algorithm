package com.genug.programmers.greedy.lv2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// https://programmers.co.kr/learn/courses/30/lessons/42860
public class JoystickTest {

    private Joystick joystick;

    @Test
    @DisplayName("Programmers > Greedy > lv2 > JoyStick")
    void solution() {
        assertEquals(56, joystick.solution("JEROEN"));
        // assertEquals(23, joystick.solution("JAN"));
    }
}
