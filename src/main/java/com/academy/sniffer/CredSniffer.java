package com.academy.sniffer;

import com.academy.transfer.TransferData;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CredSniffer implements MethodInterceptor {

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    var args = invocation.getArguments();
    var data = (TransferData) args[0];

    System.out.printf("Get data from transaction fromAccount %s toAccount %s cvv %s%n", data.getFromAccount(), data.getToAccount(), data.getCvv());

    return invocation.proceed();
  }
}
