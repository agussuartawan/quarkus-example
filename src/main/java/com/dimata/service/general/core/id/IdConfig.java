package com.dimata.service.general.core.id;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Date;


public class IdConfig implements IdentifierGenerator {

    public IdConfig(){}

    private static final int DEFAULT_APP_IDX = 3;
    private static long currentId = 0;


    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return generateId();
    }

    private synchronized long generateId(){
        var oid = new Date().getTime() + (0x01000000000000L * DEFAULT_APP_IDX);
        while(oid == currentId) {
            try {
                wait(10);
                oid = new Date().getTime() + (0x01000000000000L * DEFAULT_APP_IDX);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            
        }
        currentId = oid;
        return oid;
    }
}
