package org.mcr;

import org.mcr.components.User;
import org.mcr.services.TransactionService;
import org.mcr.services.TransactionServiceImpl;
import org.mcr.utility.SplitType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SplitWise
 *
 */
public class SplitWise
{
    public static void main( String[] args ){

        List<User> userList = new ArrayList<>();
        //Lets create some users
        User user1 = new User("u1",9234256789l);
        User user2 = new User("u2",9234256788l);
        User user3 = new User("u3",9234256787l);
        User user4 = new User("u4",9234256786l);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);


        //u1 paid 1000 with exact type
        //balance class should maintain the balance who owes whom and by how much
        //transaction service should handle the process of updating the balances
        TransactionService service = new TransactionServiceImpl();
        HashMap<User,List<User>> transaction = service.createTransaction(user1,
                userList.stream().
                        filter(u -> u.getPhnNumber()!=user1.getPhnNumber()).
                        collect(Collectors.toList()),
                1000, SplitType.Equal,null,null);

        System.out.println(transaction.toString());

        ArrayList<Double> equalAmounts = new ArrayList<>();
        equalAmounts.add(150.00);
        equalAmounts.add(250.00);
        equalAmounts.add(300.00);

        HashMap<User,List<User>> transaction2 = service.createTransaction(user1,
                userList.stream().
                        filter(u -> u.getPhnNumber()!=user1.getPhnNumber()).
                        collect(Collectors.toList()),
                1000, SplitType.Exact,null,equalAmounts);

        System.out.println(transaction2.toString());

        ArrayList<Double> percentages = new ArrayList<>();
        percentages.add(10.0);
        percentages.add(20.0);
        percentages.add(30.0);

        HashMap<User,List<User>> transaction3 = service.createTransaction(user1,
                userList.stream().
                        filter(u -> u.getPhnNumber()!=user1.getPhnNumber()).
                        collect(Collectors.toList()),
                1000, SplitType.Percentage,percentages,null);

        System.out.println(transaction3.toString());


    }

}
