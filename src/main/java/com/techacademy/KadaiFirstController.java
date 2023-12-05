package com.techacademy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    // 仕様1 指定日の曜日を算定する
    @GetMapping("/dayofweek/{val1}")
    public String dispDayOfWeek(@PathVariable int val1) {

        // 入力された整数値を文字列に変換し、LocalDateに変換
        LocalDate date = LocalDate.parse(String.valueOf(val1), DateTimeFormatter.BASIC_ISO_DATE);

        // 曜日を取得
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        String dayOfWeekString = dayOfWeek.getDisplayName(java.time.format.TextStyle.FULL, java.util.Locale.US);
        return "指定日の曜日:" + dayOfWeekString;
    }

    // 仕様2　四則計算を行なう
    // 足し算
    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = val1 + val2;
        return "計算結果：" + res;
    }

    // 引き算
    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = val1 - val2;
        return "計算結果：" + res;
    }

    // 掛け算
    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = val1 * val2;
        return "計算結果：" + res;
    }

    // 割り算
    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = val1 / val2;
        return "計算結果：" + res;
    }
}