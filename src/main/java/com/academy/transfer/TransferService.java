package com.academy.transfer;

public class TransferService {
  public void transfer(TransferData transferData) {

    System.out.printf("Transfer amount %f from card %s to card %s%n", transferData.getAmount(), transferData.getFromCard(), transferData.getToCard());
  }
}
