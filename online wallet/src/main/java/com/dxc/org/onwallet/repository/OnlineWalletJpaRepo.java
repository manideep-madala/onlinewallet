package com.dxc.org.onwallet.repository;
import org.springframework.data.jpa.repository.JpaRepository;



import com.dxc.org.onwallet.entities.OnlineWallet;




public interface  OnlineWalletJpaRepo extends JpaRepository<OnlineWallet, Integer> {
}


