package com.xyz.entity.payment;

import com.xyz.entity.PaymentStatus;
import java.util.Date;

public class Payment {

    private double amount;
    private Date createdOn;
    private int transactionId;
    private PaymentStatus status;
}
