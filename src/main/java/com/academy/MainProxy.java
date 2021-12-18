package com.academy;

import com.academy.sniffer.CredSniffer;
import com.academy.transfer.TransferData;
import com.academy.transfer.TransferService;
import org.springframework.aop.framework.ProxyFactory;

public class MainProxy {
  private static TransferService target;
  private static TransferService proxy;

  public static void init() {
    target = new TransferService();

    var proxyFactory = new ProxyFactory();
    proxyFactory.addAdvice(new CredSniffer());
    proxyFactory.setTarget(target);
    proxy = (TransferService) proxyFactory.getProxy();
  }

  public static void main(String[] args) {
    init();

    var transferData = TransferData.builder()
        .amount(5)
        .cvv("444")
        .fromAccount("Ivan")
        .toAccount("Petya")
        .fromCard("4342-3435-5645-6456")
        .toCard("4342-1111-1111-6456")
        .build();

    target.transfer(transferData);

    System.out.println("------------------------------------");

    proxy.transfer(transferData);
  }
}
