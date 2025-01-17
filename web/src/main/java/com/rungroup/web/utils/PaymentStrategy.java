package com.rungroup.web.utils;

public interface PaymentStrategy {
    boolean pay(double amount);
}