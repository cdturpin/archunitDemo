package com.keyholesoftware.demo.archunit.persistence.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.keyholesoftware.demo.archunit.ArchunitApplication;
import com.keyholesoftware.demo.archunit.domain.DomainObject;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ArchunitApplication.class)
public class DomainObjectRepositoryTest {

    @Autowired
    private DomainObjectRepository<?> doRepo;

    @Test
    public void testContext() {
        assertNotNull(doRepo);
    }

    @Test
    public void givenAnyDomainObjectRepository_whenSaveAndRetreiveEntity_thenOK() {

        DomainObject domainObject = doRepo.save(new DomainObject(123456L));
        DomainObject foundEntity = doRepo.findOne(domainObject.getId());

        assertNotNull(foundEntity);
        assertEquals(domainObject.getId(), foundEntity.getId());
       
    }

}
