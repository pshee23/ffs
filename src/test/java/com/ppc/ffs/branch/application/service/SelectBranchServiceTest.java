package com.ppc.ffs.branch.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ppc.ffs.branch.adapter.in.web.form.BranchSelectResponse;
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
		BranchSelectResponse branchResponse = selectService.selectBranch(id);
		assertEquals(id, branchResponse.getBranch().getBranchId());
	}

	@Test
	void testSelectBranchEmployee() {

	}

}
