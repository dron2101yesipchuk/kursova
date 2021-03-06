package com.yesipchuk.demo.service.buyer.impls;

import com.yesipchuk.demo.DAO.buyer.impls.BuyerDAOFakeImpl;
import com.yesipchuk.demo.model.Buyer;
import com.yesipchuk.demo.service.buyer.interfaces.IBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BuyerService implements IBuyerService{

    @Autowired
    BuyerDAOFakeImpl buyerDao;

    @Override
    public List<Buyer> getAll() throws SQLException {
        return buyerDao.getAll();
    }

    @Override
    public Buyer deleteBuyer(int id) throws SQLException {
        return buyerDao.deleteBuyer(id);
    }

    @Override
    public Buyer addBuyer(Buyer buyer) throws SQLException {
        return buyerDao.addBuyer(buyer);
    }

    @Override
    public Buyer updateBuyer(Buyer buyer) throws SQLException {
        return buyerDao.updateBuyer(buyer);
    }
}
