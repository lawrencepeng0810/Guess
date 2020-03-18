package com.example.guess
import java.util.*;

class SecretNumber {
    // 1 ~ 10 Random Number;
    // 凡是在 Class 設定 val 稱為屬性
    // 0~9 + 1
    val secret : Int = Random().nextInt(10) + 1;
    var count : Int = 0;

    fun validate(number : Int) : Int {
        count ++;
        return (number - this.secret);
    }
}

fun main() {
    // 將 Class 建立物件方法
    val secretNumber = SecretNumber();
    println("Random 數字 : "+secretNumber.secret);
    println("Secret Number Result : ${secretNumber.validate(3)}, Count: ${ secretNumber.count }");
}