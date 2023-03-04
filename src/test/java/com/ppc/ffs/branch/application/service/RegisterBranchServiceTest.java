package com.ppc.ffs.branch.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ppc.ffs.branch.domain.BranchInfo;
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
		BranchInfo branchInfo = branchService.registerBranch(createInfo);
		
		assertEquals(createInfo.getName(), branchInfo.getName());
		assertEquals(createInfo.getAddress(), branchInfo.getAddress());
		assertEquals(createInfo.getPhoneNumber(), branchInfo.getPhoneNumber());
	}

}
