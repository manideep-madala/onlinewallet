package com.dxc.org.onwallet.service;
import java.util.List;
import java.util.Optional;

import com.dxc.org.onwallet.entities.OnlineWallet;


public interface IOnlineWalletService {
    public OnlineWallet createOnlineWallet(OnlineWallet onlinewalletbean);
    public OnlineWallet addAmount(int customerId,int accountBalance);
    public OnlineWallet  findOnlineWalletById(int customerId );
    List<OnlineWallet> getAlldetails();
}

