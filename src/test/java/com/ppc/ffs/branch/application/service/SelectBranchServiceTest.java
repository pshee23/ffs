package com.ppc.ffs.branch.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ppc.ffs.branch.domain.BranchInfo;
import com.ppc.ffs.branch.domain.BranchRegisterInfo;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SelectBranchServiceTest {

	@Autowired
	private RegisterBranchService registerService;
	
	@Autowired
	private SelectBranchService selectService;
	
	@BeforeAll
	public void setUp() {
		BranchRegisterInfo createInfo = BranchRegisterInfo.builder()
				.name("k2 fitness")
				.address("garak-dong")
				.phoneNumber("02-5221-1251").build();
		registerService.registerBranch(createInfo);
	}
	
	@Test
	void testSelectAllBranch() {
		assertNotNull(selectService.selectAllBranch());
	}

	@Test
	void testSelectBranch() {
		Long id = 1L;
		BranchInfo branchInfo = selectService.selectBranch(id);
		assertEquals(id, branchInfo.getBranchId());
	}

	@Test
	void testSelectBranchEmployee() {
		fail("Not yet implemented");
	}

}
