package com.rungroup.utils;

public interface PaymentStrategy {
    boolean pay(double amount);
}