package com.sha.springbootbookseller.services;

import com.sha.springbootbookseller.entities.PurchaseHistory;
import com.sha.springbootbookseller.repositories.projection.IPurchaseItem;

import java.util.List;

public interface IPurchaseHistory {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<IPurchaseItem> findPurchasedItemsOfUser(Long personId);
}
