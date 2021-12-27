package com.sha.springbootbookseller.controller;

import com.sha.springbootbookseller.entities.PurchaseHistory;
import com.sha.springbootbookseller.security.PersonPrincipal;
import com.sha.springbootbookseller.services.IPurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchase-history")
public class PurchaseHistoryController {

    @Autowired
    private IPurchaseHistoryService purchaseService;

    @PostMapping
    public ResponseEntity<?> savePurchaseHistory(@RequestBody PurchaseHistory purchaseHistory){
        return new ResponseEntity<>(purchaseService.savePurchaseHistory(purchaseHistory), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllPurchasesOfUser(@AuthenticationPrincipal PersonPrincipal personPrincipal){
        return ResponseEntity.ok(purchaseService.findPurchasedItemsOfUser(personPrincipal.getId()));
    }

}
