package org.mcr.services;

import org.mcr.components.User;
import org.mcr.utility.SplitType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TransactionServiceImpl implements TransactionService{


    List<HashMap<User, List<User>>> transactionList = new ArrayList<>();

    public HashMap<User, List<User>> createTransaction(User primaryUser,
                                                       List<User> secondaryUsers,
                                                       double paidAmount,
                                                       SplitType splitType,
                                                       List<Double> percentage,
                                                       List<Double> amountList){
        primaryUser.setPaidAmount(paidAmount);
        HashMap<User,List<User>> transaction = new HashMap<>();

        //update secondary user object with the share
        // they need to pay according to split strategy
        updateSecondaryUserTransaction(primaryUser,secondaryUsers,
                                        paidAmount,splitType,percentage,amountList);

        transaction.put(primaryUser,secondaryUsers);

        transactionList.add(transaction);
        return  transaction;

    }

    /**
     * For updating the User object according to split type
     * @param secondaryUsers
     * @param paidAmount
     * @param splitType
     * @param percentage
     * @param amountList
     */
    private void updateSecondaryUserTransaction(User primaryUser,
                                                List<User> secondaryUsers,
                                                double paidAmount,
                                                SplitType splitType,
                                                List<Double> percentage,
                                                List<Double> amountList) {

        switch (splitType){
           case Equal:
                 updateTransactionForEqual(primaryUser,paidAmount,secondaryUsers);
               break;
            case Exact:
                updateTransactionForExact(primaryUser,secondaryUsers,amountList);
                break;
            case Percentage:
                updateTransactionForPercentage(primaryUser,secondaryUsers,paidAmount,percentage);
                break;
            default:


        }


    }

    /**
     * For percentage
     * @param primaryUser
     * @param secondaryUsers
     * @param paidAmount
     * @param percentage
     */
    private void updateTransactionForPercentage(User primaryUser,
                                                List<User> secondaryUsers,
                                                Double paidAmount,
                                                List<Double> percentage) {
        for(int i = 0 ; i < secondaryUsers.size() ; i++){
            secondaryUsers.get(i).setOwedAmount(paidAmount * (percentage.get(i)/100));
            secondaryUsers.get(i).setOwesTo(primaryUser);
        }
    }

    /**
     * For Exact Amount
     * @param primaryUser
     * @param secondaryUsers
     * @param amountList
     */
    private void updateTransactionForExact(User primaryUser, 
                                           List<User> secondaryUsers, 
                                           List<Double> amountList) {
        
        for(int i = 0 ; i < secondaryUsers.size() ; i++){
            secondaryUsers.get(i).setOwedAmount(amountList.get(i));
            secondaryUsers.get(i).setOwesTo(primaryUser);
        }
        
    }
    
    

    /**
     * For Equal Amount
     * @param primaryUser
     * @param paidAmount
     * @param secondaryUsers
     */
    private void updateTransactionForEqual(User primaryUser,double paidAmount, List<User> secondaryUsers) {
        double equalAmount = paidAmount / (secondaryUsers.size() + 1);
        secondaryUsers.stream().forEach(u -> {
            u.setOwesTo(primaryUser);
            u.setOwedAmount(equalAmount);
        });
    }

    public List<HashMap<User, List<User>>> getTransactionList() {
        return transactionList;
    }

}
