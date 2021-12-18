package com.academy.transfer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferData {
  private String fromAccount;
  private String toAccount;
  private String fromCard;
  private String toCard;
  private String cvv;
  private double amount;
}
