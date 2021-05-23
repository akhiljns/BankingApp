package com.banking.app;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.banking.app.model.Account;
import com.banking.app.service.AccountService;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
class AppApplicationTests extends AbstractTest {

	AccountService accountService = Mockito.mock(AccountService.class);;

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void createTxGetStatementIntegratedTest() throws Exception {

		// unit test for controller layer and integrated test of the flow
		String createTransactionUri = "/account/createTransaction";

		String inputJsonTransaction = "{\"senderAccountNo\":2,\"recepientAccountNo\":1,\"amount\":2}";

		mvc.perform(MockMvcRequestBuilders.put(createTransactionUri).content(inputJsonTransaction)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.jsonPath("$.transaction_type", is("DEBIT")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.transaction_amount", is(2.0)));

		String getStatementUri = "/account/statement";

		String inputJsonStatement = "{\"accNo\":2}";

		mvc.perform(MockMvcRequestBuilders.post(getStatementUri).content(inputJsonStatement)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.jsonPath("$.accountNumber", is(2)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.balance", is(185.0)));

	}

	@Test
	public void testAccountService() throws Exception {
		// unit test for service layer
		when(accountService.findAccountByAccNo(1L)).thenReturn(new Account(1L, 234.0, null));

		Account a = accountService.findAccountByAccNo(1L);

		assertEquals(1L, a.getAccount_number());
		assertEquals(234.0, a.getBalance_value());
	}
}
