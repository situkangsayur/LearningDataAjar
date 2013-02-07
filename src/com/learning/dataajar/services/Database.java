/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learning.dataajar.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hendri
 */
public class Database {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static EntityManagerFactory getConnection() {

        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("LearningDataAjarPU");

        }
        return entityManagerFactory;
    }

    public static EntityManager getEntityManager() {

        if (entityManager == null) {
            entityManager = getConnection().createEntityManager();
        }

        return entityManager;

    }
}
