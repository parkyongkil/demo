package com.example;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DemoController {

	@PersistenceContext
	EntityManager em;

	@RequestMapping("test1")
	@Transactional
	public String test1() throws Exception {
		T2 t2 = em.find(T2.class, "selani");
		if (t2 == null) {
			t2 = new T2();
			t2.setUserId("selani");
			em.persist(t2);
		} else {
			t2.setUserName(DateFormatUtils.format(new Date(), "yyyyMMdd HHmmss"));
		}
		t2 = em.find(T2.class, "selani");
		System.out.println(t2);
		return null;
	}
}
