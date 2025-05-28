package com.clone.inflearn.util;

import org.springframework.transaction.support.TransactionSynchronizationManager;

public class LogUtils {
    public static void logTxInfo(String label) {
        String thread = Thread.currentThread().getName();
        boolean active = TransactionSynchronizationManager.isActualTransactionActive();
        Object tx = TransactionSynchronizationManager.getCurrentTransactionName();

        System.out.println("[" + label + "] 스레드: " + thread +
                ", 트랜잭션 활성: " + active +
                ", 트랜잭션 이름: " + tx);
    }
}
