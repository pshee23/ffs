package com.ppc.ffs.branch.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ppc.ffs.branch.domain.BranchRegisterInfo;

@SpringBootTest
class RegisterBranchServiceTest {

	@Autowired
	private RegisterBranchService branchService;
	
	@Test
	void testRegisterBranch() {
		BranchRegisterInfo createInfo = BranchRegisterInfo.builder()
				.name("k2 fitness")
				.address("garak-dong")
				.phoneNumber("02-5221-1251").build();
		long branchId = branchService.registerBranch(createInfo);
		
		assertEquals(1, branchId);
	}

}
