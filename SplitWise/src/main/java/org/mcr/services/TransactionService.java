package org.mcr.services;

import org.mcr.components.User;
import org.mcr.utility.SplitType;

import java.util.HashMap;
import java.util.List;

public interface TransactionService {

    public HashMap<User, List<User>> createTransaction(User primaryUser,
                                                       List<User> secondaryUsers,
                                                       double paidAmount,
                                                       SplitType splitType,
                                                       List<Double> percentage,
                                                       List<Double> amountList);

}
